package fr.pawo.partners.cdl.business.groupe;

import fr.pawo.partners.cdl.core.domain.AppUser;
import fr.pawo.partners.cdl.core.domain.Groupe;
import fr.pawo.partners.cdl.core.repository.GroupeRepository;
import fr.pawo.partners.cdl.core.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GroupeServiceImpl implements GroupeService {

    @Autowired
    GroupeRepository groupeRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Groupe addGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public Groupe updateGroupe(Long idGroupe,Groupe groupe) {
        groupe.setIdGroupe(idGroupe);
        return groupeRepository.save(groupe);
    }
    @Override
    public void deleteGroupe(Long idGroupe) {
        this.groupeRepository.deleteById(idGroupe);
    }

    /*@Override
    public void addUserToGroupe(AppUser appUser, Groupe groupe) {
        appUser.getGroupes().add(groupe);
        userRepository.save(appUser);
    }*/

    @Override
    public Optional<Groupe> findGroupeById(long id) {
        return groupeRepository.findById(id);
    }

    @Override
    public List<Groupe> getAllgroupes() {
        return groupeRepository.findAll();
    }
}
