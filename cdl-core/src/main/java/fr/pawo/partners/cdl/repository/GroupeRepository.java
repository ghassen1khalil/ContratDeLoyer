package fr.pawo.partners.cdl.repository;

import fr.pawo.partners.cdl.domain.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "groupe", path = "groupe")
public interface GroupeRepository extends JpaRepository<Groupe, Long>, PagingAndSortingRepository<Groupe, Long> {
}
