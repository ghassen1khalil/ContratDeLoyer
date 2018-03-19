package fr.pawo.partners.cdl.business.service.groupe;

import fr.pawo.partners.cdl.core.domain.Groupe;

import java.util.List;
import java.util.Optional;

public interface GroupeService {

    Optional<Groupe> findGroupeById(long id);

    List<Groupe> findAll();
}
