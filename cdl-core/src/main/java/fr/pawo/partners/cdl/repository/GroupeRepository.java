package fr.pawo.partners.cdl.repository;

import fr.pawo.partners.cdl.domain.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long>, PagingAndSortingRepository<Groupe, Long> {
}
