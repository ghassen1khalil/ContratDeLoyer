package fr.pawo.partners.cdl.business.config;

import fr.pawo.partners.cdl.business.groupe.GroupeService;
import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;
import fr.pawo.partners.cdl.core.domain.Groupe;
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

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BusinessConfig implements CommandLineRunner  {
    public static void main(String[] args) {
        SpringApplication.run(BusinessConfig.class, args);
    }
    @Autowired
    private AccountService accountService;
    @Autowired
    private GroupeService groupeService;

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {


        AppRole admin = new AppRole(null, "ADMIN", null);
        AppRole user = new AppRole(null, "USER", null);
        AppRole superadmin = new AppRole(null, "SUPER_ADMIN", null);
        this.accountService.saveRole(admin);
        this.accountService.saveRole(user);
        this.accountService.saveRole(superadmin);

        Groupe g1 = new Groupe(null,"g1",null);
        Groupe g2 = new Groupe(null,"g2",null);

        groupeService.addGroupe(g1);
        groupeService.addGroupe(g2);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("admin");

        AppUser u1 = new AppUser(null, "admin", pass, true, admin);
        AppUser u2 = new AppUser(null, "user", pass, true, user);
        AppUser u3 = new AppUser(null, "super_admin", pass, true, superadmin);
        this.accountService.saveUser(u1);
        this.accountService.saveUser(u2);
        this.accountService.saveUser(u3);

        //groupeService.addUserToGroupe(u1,g1);
        //groupeService.addUserToGroupe(u2,g2);
    }
}
