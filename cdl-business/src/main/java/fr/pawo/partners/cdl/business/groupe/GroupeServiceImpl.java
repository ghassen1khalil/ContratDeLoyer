package fr.pawo.partners.cdl.business.groupe;

import fr.pawo.partners.cdl.core.domain.Groupe;
import fr.pawo.partners.cdl.core.repository.GroupeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GroupeServiceImpl implements GroupeService {

    @Autowired
    GroupeRepository groupeRepository;

    @Override
    public Optional<Groupe> findGroupeById(long id) {
        return groupeRepository.findById(id);
    }

    @Override
    public List<Groupe> findAll() {
        return groupeRepository.findAll();
    }
}
