package com.example.git_test_note.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.git_test_note.model.Note;
import com.example.git_test_note.model.NoteFinal;
import com.example.git_test_note.repository.NoteFinalRepository;
import com.example.git_test_note.repository.NoteRepository;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteFinalRepository noteFinalRepository;
    private final DeliberationService deliberationService;

    public NoteService(NoteRepository noteRepository,
                       NoteFinalRepository noteFinalRepository,
                       DeliberationService deliberationService) {
        this.noteRepository = noteRepository;
        this.noteFinalRepository = noteFinalRepository;
        this.deliberationService = deliberationService;
    }

    /**
     * Count how many distinct professors graded a given student for a given subject.
     */
    public long countCorrecteurs(Long etudiantId, Long matiereId) {
        return noteRepository.countDistinctProfesseurs(etudiantId, matiereId);
    }

    /**
     * Calculate the difference between the maximum and minimum note for a student
     * in a specific subject.
     */
    public BigDecimal calculerDifferenceNote(Long etudiantId, Long matiereId) {
        List<Note> notes = noteRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        if (notes.isEmpty()) {
            return BigDecimal.ZERO;
        }
        double min = notes.stream().mapToDouble(Note::getValeur).min().orElse(0);
        double max = notes.stream().mapToDouble(Note::getValeur).max().orElse(0);
        return BigDecimal.valueOf(max - min);
    }

    /**
     * Return the final note for a student in a subject.  If there is no stored
     * value the deliberation service is invoked and the result persisted.
     */
    @Transactional
    public Double getNoteFinale(Long etudiantId, Long matiereId) {
        Optional<NoteFinal> existing = noteFinalRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        if (existing.isPresent()) {
            return existing.get().getValeur();
        }
        // no final note yet, compute it
        return deliberationService.delibererPourEtudiantMatiere(etudiantId, matiereId);
    }

    /**
     * List all final notes stored in the repository.
     */
    public List<NoteFinal> listerNotesFinales() {
        return new ArrayList<>(noteFinalRepository.findAll());
    }
}
