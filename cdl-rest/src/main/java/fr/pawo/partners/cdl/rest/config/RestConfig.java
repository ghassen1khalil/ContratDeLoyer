package fr.pawo.partners.cdl.rest.config;

import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;
import fr.pawo.partners.cdl.core.domain.Groupe;
import fr.pawo.partners.cdl.core.repository.RoleRepository;
import fr.pawo.partners.cdl.core.repository.UserRepository;
import fr.pawo.partners.cdl.rest.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories(basePackages = {"fr.pawo.partners.cdl"})
@EntityScan(basePackages = {"fr.pawo.partners.cdl"})
@ComponentScan(basePackages = {"fr.pawo.partners.cdl",})
public class RestConfig implements CommandLineRunner {


    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupeService groupeService;

    public static void main(String[] args) {
        SpringApplication.run(RestConfig.class, args);
    }


    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void run(String... args) throws Exception {

        //create role
        AppRole admin = new AppRole("ADMIN");
        AppRole user = new AppRole("USER");
        AppRole superadmin = new AppRole("SUPER_ADMIN");
        this.roleRepository.save(admin);
        this.roleRepository.save(user);
        this.roleRepository.save(superadmin);
        // create Groupe
        Groupe g1 = new Groupe("g1");
        Groupe g2 = new Groupe("g2");
        groupeService.addGroupe(g1);
        groupeService.addGroupe(g2);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("admin");

        AppUser u1 = new AppUser("admin", pass, true, admin);
        AppUser u2 = new AppUser("user", pass, true, user);
        AppUser u3 = new AppUser("super_admin", pass, true, superadmin);
        this.userRepository.save(u1);
        this.userRepository.save(u2);
        this.userRepository.save(u3);

        //Affect user to groupe
        groupeService.addUserToGroupe(u1,g1);
        groupeService.addUserToGroupe(u1,g2);
        groupeService.addUserToGroupe(u2,g1);
    }
}

