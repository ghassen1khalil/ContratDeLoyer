package fr.pawo.partners.cdl.core.repository;

import fr.pawo.partners.cdl.core.domain.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long>, PagingAndSortingRepository<Groupe, Long> {
}
