package fr.pawo.partners.cdl.core.repository;

import fr.pawo.partners.cdl.core.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>, PagingAndSortingRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}
