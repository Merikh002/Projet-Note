package com.example.git_test_note.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.git_test_note.model.Client;
import com.example.git_test_note.model.Demande;
import com.example.git_test_note.repository.ClientRepository;
import com.example.git_test_note.repository.DemandeRepository;
import com.example.git_test_note.model.DetailDevis;
import com.example.git_test_note.repository.DetailDevisRepository;
import com.example.git_test_note.model.Devis;
import com.example.git_test_note.repository.DevisRepository;
import com.example.git_test_note.model.Statut;
import com.example.git_test_note.repository.StatutRepository;
import com.example.git_test_note.model.Travaux;
import com.example.git_test_note.repository.TravauxRepository;
import com.example.git_test_note.model.StatutDemande;
import com.example.git_test_note.repository.StatutDemandeRepository;
import com.example.git_test_note.model.TypeDevis;
import com.example.git_test_note.repository.TypeDevisRepository;


@Service
public class CRUDService {

   
    
    //Client
    private final ClientRepository ClientRepository;


    public void createClient(Client client) {
        ClientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return ClientRepository.findAll();
    }

    public Client findByIdClient(Long id) {
        return ClientRepository.findById(id).orElse(null);
    }

    public boolean deleteClient(Long id) {
        if (ClientRepository.existsById(id)) {
            ClientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Demande
    private final DemandeRepository DemandeRepository;

    public void createDemande(Demande demande) {
        DemandeRepository.save(demande);
    }

    public List<Demande> getAllDemandes() {
        return DemandeRepository.findAll();
    }

    public Demande findByIdDemande(Long id) {
        return DemandeRepository.findById(id).orElse(null);
    }

    public boolean deleteDemande(Long id) {
        if (DemandeRepository.existsById(id)) {
            DemandeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //DetailDevis
    private final DetailDevisRepository DetailDevisRepository;

    public void createDetailDevis(DetailDevis detailDevis) {
        DetailDevisRepository.save(detailDevis);
    }

    public List<DetailDevis> getAllDetailDeviss() {
        return DetailDevisRepository.findAll();
    }

    public DetailDevis findByIdDetailDevis(Long id) {
        return DetailDevisRepository.findById(id).orElse(null);
    }

    public boolean deleteDetailDevis(Long id) {
        if (DetailDevisRepository.existsById(id)) {
            DetailDevisRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Devis
    private final DevisRepository DevisRepository;

    public void createDevis(Devis Devis) {
        DevisRepository.save(Devis);
    }

    public List<Devis> getAllDeviss() {
        return DevisRepository.findAll();
    }

    public Devis findByIdDevis(Long id) {
        return DevisRepository.findById(id).orElse(null);
    }

    @Transactional
    public boolean deleteDevis(Long id) {
        if (DevisRepository.existsById(id)) {
            DetailDevisRepository.deleteByDevisId(id);
            DevisRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Statut
    private final StatutRepository StatutRepository;

    public void createStatut(Statut Statut) {
        StatutRepository.save(Statut);
    }

    public List<Statut> getAllStatuts() {
        return StatutRepository.findAll();
    }

    public Statut findByIdStatut(Long id) {
        return StatutRepository.findById(id).orElse(null);
    }

    public boolean deleteStatut(Long id) {
        if (StatutRepository.existsById(id)) {
            StatutRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Travaux
    private final TravauxRepository TravauxRepository;

    public void createTravaux(Travaux Travaux) {
        TravauxRepository.save(Travaux);
    }

    public List<Travaux> getAllTravaux() {
        return TravauxRepository.findAll();
    }

    public Travaux findByIdTravaux(Long id) {
        return TravauxRepository.findById(id).orElse(null);
    }

    public boolean deleteTravaux(Long id) {
        if (TravauxRepository.existsById(id)) {
            TravauxRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //StatutDemande

    private final StatutDemandeRepository StatutDemandeRepository;

    public boolean createStatutDemande(StatutDemande statutDemande) {
        if(!StatutDemandeRepository.existsByDemande_idAndStatut_id(statutDemande.getDemande().getId(), statutDemande.getStatut().getId())){
            StatutDemandeRepository.save(statutDemande);
            return true;
        }
        return false;
    }

    public List<StatutDemande> getAllStatutDemande() {
        return StatutDemandeRepository.findAll();
    }

    public StatutDemande findByIdStatutDemande(Long id) {
        return StatutDemandeRepository.findById(id).orElse(null);
    }

    public boolean deleteStatutDemande(Long id) {
        if (StatutDemandeRepository.existsById(id)) {
            StatutDemandeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //TypeDevis

    private final TypeDevisRepository TypeDevisRepository;

    public void createTypeDevis(TypeDevis TypeDevis) {
        TypeDevisRepository.save(TypeDevis);
    }

    public List<TypeDevis> getAllTypeDeviss() {
        return TypeDevisRepository.findAll();
    }

    public TypeDevis findByIdTypeDevis(Long id) {
        return TypeDevisRepository.findById(id).orElse(null);
    }

    public boolean deleteTypeDevis(Long id) {
        if (TypeDevisRepository.existsById(id)) {
            TypeDevisRepository.deleteById(id);
            return true;
        }
        return false;
    }



    public CRUDService(ClientRepository ClientRepository,
                       DemandeRepository DemandeRepository,
                       DetailDevisRepository DetailDevisRepository,
                       DevisRepository DevisRepository,
                       StatutRepository StatutRepository,
                       TravauxRepository TravauxRepository,
                       StatutDemandeRepository StatutDemandeRepository,
                       TypeDevisRepository TypeDevisRepository) {
        this.ClientRepository = ClientRepository;
        this.DemandeRepository = DemandeRepository;
        this.DetailDevisRepository = DetailDevisRepository;
        this.DevisRepository = DevisRepository;
        this.StatutRepository = StatutRepository;
        this.TravauxRepository = TravauxRepository;
        this.StatutDemandeRepository = StatutDemandeRepository;
        this.TypeDevisRepository = TypeDevisRepository;
    }
}
