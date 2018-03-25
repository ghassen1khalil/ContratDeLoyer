package fr.pawo.partners.cdl.business.groupe;


import fr.pawo.partners.cdl.core.domain.AppUser;
import fr.pawo.partners.cdl.core.domain.Groupe;
import java.util.List;
import java.util.Optional;

public interface GroupeService {

    Groupe addGroupe (Groupe groupe);
    Groupe updateGroupe(Long idGroupe,Groupe groupe);
    void deleteGroupe(Long idGroupe);
   // void addUserToGroupe(AppUser appUser, Groupe groupe);
    Optional<Groupe> findGroupeById(long id);
    List<Groupe> getAllgroupes();
}
