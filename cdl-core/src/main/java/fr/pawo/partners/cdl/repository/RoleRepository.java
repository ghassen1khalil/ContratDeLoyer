package fr.pawo.partners.cdl.repository;

import fr.pawo.partners.cdl.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "role", path = "role")
public interface RoleRepository extends JpaRepository<Role, Long>, PagingAndSortingRepository<Role, Long> {
}
