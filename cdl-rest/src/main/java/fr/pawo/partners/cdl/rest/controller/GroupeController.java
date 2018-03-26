package fr.pawo.partners.cdl.rest.controller;

import fr.pawo.partners.cdl.rest.service.GroupeService;
import fr.pawo.partners.cdl.core.domain.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GroupeController {

    @Autowired
    GroupeService groupeService;

    @GetMapping("/groupe")
    public List<Groupe> listGroupe(){
        return groupeService.getAllgroupes();
    }

    @GetMapping("/groupe/{id}")
    public Optional<Groupe> getGroupe(@PathVariable(value = "id") Long idGroupe){
        return groupeService.findGroupeById(idGroupe);
    }

    @PostMapping("/groupe")
    public void saveGroupe(@RequestBody Groupe groupe){
        this.groupeService.addGroupe(groupe);
    }

    @PutMapping("/groupe/{id}")
    public Groupe updateGroupe(@PathVariable(value = "id") Long idGroupe,
                              @Valid @RequestBody Groupe groupe){

        return this.groupeService.updateGroupe(idGroupe,groupe);
    }

    @DeleteMapping("/groupe/{id}")
    public void deletegroupe(@PathVariable Long id) {
        this.groupeService.deleteGroupe(id);

    }


}
