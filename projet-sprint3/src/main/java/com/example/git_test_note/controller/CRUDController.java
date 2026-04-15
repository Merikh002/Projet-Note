package com.example.git_test_note.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.git_test_note.model.Client;
import com.example.git_test_note.model.Demande;
import com.example.git_test_note.model.DetailDevis;
import com.example.git_test_note.model.Devis;
import com.example.git_test_note.model.Statut;
import com.example.git_test_note.model.StatutDemande;
import com.example.git_test_note.model.Travaux;
import com.example.git_test_note.model.TypeDevis;
import com.example.git_test_note.service.CRUDService;

@RestController
@RequestMapping("/api")
public class CRUDController {

    private final CRUDService crudService;

    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
    }

    // ====================
    // Clients
    // ====================

    @PostMapping("/clients")
    public void createClient(@RequestBody Client client) {
        crudService.createClient(client);
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return crudService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Long id) {
        return crudService.findByIdClient(id);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        boolean deleted = crudService.deleteClient(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // Demandes
    // ====================

    @PostMapping("/demandes")
    public void createDemande(@RequestBody Demande demande) {
        crudService.createDemande(demande);
    }

    @GetMapping("/demandes")
    public List<Demande> getAllDemandes() {
        return crudService.getAllDemandes();
    }

    @GetMapping("/demandes/{id}")
    public Demande getDemandeById(@PathVariable Long id) {
        return crudService.findByIdDemande(id);
    }

    @DeleteMapping("/demandes/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        boolean deleted = crudService.deleteDemande(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // Detail des devis
    // ====================

    @PostMapping("/detailDeviss")
    public void createDetailDevis(@RequestBody DetailDevis detailDevis) {
        crudService.createDetailDevis(detailDevis);
    }

    @GetMapping("/detailDeviss")
    public List<DetailDevis> getAllDetailDeviss() {
        return crudService.getAllDetailDeviss();
    }

    @GetMapping("/detailDeviss/{id}")
    public DetailDevis getDetailDevisById(@PathVariable Long id) {
        return crudService.findByIdDetailDevis(id);
    }

    @DeleteMapping("/detailDeviss/{id}")
    public ResponseEntity<Void> deleteDetailDevis(@PathVariable Long id) {
        boolean deleted = crudService.deleteDetailDevis(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // devis
    // ====================

    @PostMapping("/devis")
    public void createDevis(@RequestBody Devis devis) {
        crudService.createDevis(devis);
    }

    @GetMapping("/devis")
    public List<Devis> getAllDeviss() {
        return crudService.getAllDeviss();
    }

    @GetMapping("/devis/{id}")
    public Devis getDevisById(@PathVariable Long id) {
        return crudService.findByIdDevis(id);
    }

    @DeleteMapping("/devis/{id}")
    public ResponseEntity<Void> deleteDevis(@PathVariable Long id) {
        boolean deleted = crudService.deleteDevis(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // Statuts
    // ====================

    @PostMapping("/statuts")
    public void createStatut(@RequestBody Statut statut) {
        crudService.createStatut(statut);
    }

    @GetMapping("/statuts")
    public List<Statut> getAllStatuts() {
        return crudService.getAllStatuts();
    }

    @GetMapping("/statuts/{id}")
    public Statut getStatutById(@PathVariable Long id) {
        return crudService.findByIdStatut(id);
    }

    @DeleteMapping("/statuts/{id}")
    public ResponseEntity<Void> deleteStatut(@PathVariable Long id) {
        boolean deleted = crudService.deleteStatut(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // Statut de demande
    // ====================

    @PostMapping("/statutDemande")
    public ResponseEntity<Void> createStatutDemande(@RequestBody StatutDemande statutDemande) {
        
        boolean inserer = crudService.createStatutDemande(statutDemande);
        if (inserer){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(409).build();
        }
    }

    @GetMapping("/statutDemande")
    public List<StatutDemande> getAllStatutDemandes() {
        return crudService.getAllStatutDemande();
    }

    @GetMapping("/statutDemande/{id}")
    public StatutDemande getStatutDemandeById(@PathVariable Long id) {
        return crudService.findByIdStatutDemande(id);
    }

    @DeleteMapping("/statutDemande/{id}")
    public ResponseEntity<Void> deleteStatutDemande(@PathVariable Long id) {
        boolean deleted = crudService.deleteStatutDemande(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // Travaux
    // ====================

    @PostMapping("/travaux")
    public void createTravaux(@RequestBody Travaux travaux) {
        crudService.createTravaux(travaux);
    }

    @GetMapping("/travaux")
    public List<Travaux> getAllTravaux() {
        return crudService.getAllTravaux();
    }

    @GetMapping("/travaux/{id}")
    public Travaux getTravauxById(@PathVariable Long id) {
        return crudService.findByIdTravaux(id);
    }

    @DeleteMapping("/travaux/{id}")
    public ResponseEntity<Void> deleteTravaux(@PathVariable Long id) {
        boolean deleted = crudService.deleteTravaux(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // ====================
    // type devis
    // ====================

    @PostMapping("/typeDevis")
    public void createTypeDevis(@RequestBody TypeDevis typeDevis) {
        crudService.createTypeDevis(typeDevis);
    }

    @GetMapping("/typeDevis")
    public List<TypeDevis> getAllTypeDeviss() {
        return crudService.getAllTypeDeviss();
    }

    @GetMapping("/typeDevis/{id}")
    public TypeDevis getTypeDevisById(@PathVariable Long id) {
        return crudService.findByIdTypeDevis(id);
    }

    @DeleteMapping("/typeDevis/{id}")
    public ResponseEntity<Void> deleteTypeDevis(@PathVariable Long id) {
        boolean deleted = crudService.deleteTypeDevis(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}