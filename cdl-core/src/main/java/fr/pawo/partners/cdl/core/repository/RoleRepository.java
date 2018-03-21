package fr.pawo.partners.cdl.core.repository;

import fr.pawo.partners.cdl.core.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "role", path = "role")
public interface RoleRepository extends JpaRepository<AppRole, Long>, PagingAndSortingRepository<AppRole, Long> {

}
