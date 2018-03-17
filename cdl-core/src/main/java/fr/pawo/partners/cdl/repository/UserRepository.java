package fr.pawo.partners.cdl.repository;

import fr.pawo.partners.cdl.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>, PagingAndSortingRepository<AppUser, Long> {
    public AppUser findByUserName(String username);
}
