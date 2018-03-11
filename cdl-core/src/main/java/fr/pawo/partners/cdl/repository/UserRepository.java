package fr.pawo.partners.cdl.repository;

import fr.pawo.partners.cdl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    public User findByUserName(String username);
}
