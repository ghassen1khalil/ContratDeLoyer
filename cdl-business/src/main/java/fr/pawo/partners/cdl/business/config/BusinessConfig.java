package fr.pawo.partners.cdl.business.config;

import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;
import fr.pawo.partners.cdl.core.repository.RoleRepository;
import fr.pawo.partners.cdl.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BusinessConfig implements CommandLineRunner  {
    public static void main(String[] args) {
        SpringApplication.run(BusinessConfig.class, args);
    }
    @Autowired
    private UserRepository userReposetory;
    @Autowired
    private RoleRepository roleReposetory;

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        AppRole admin = new AppRole(null, "ADMIN", null);
        AppRole user = new AppRole(null, "USER", null);
        AppRole superadmin = new AppRole(null, "SUPER_ADMIN", null);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("admin");

        AppUser u1 = new AppUser(null, "admin", pass, true, admin, null);
        AppUser u2 = new AppUser(null, "user", pass, true, user, null);
        AppUser u3 = new AppUser(null, "super_admin", pass, true, superadmin, null);
        this.roleReposetory.save(admin);
        this.roleReposetory.save(user);
        this.roleReposetory.save(superadmin);
        this.userReposetory.save(u1);
        this.userReposetory.save(u2);
        this.userReposetory.save(u3);
    }
}
