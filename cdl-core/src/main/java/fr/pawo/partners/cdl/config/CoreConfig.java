package fr.pawo.partners.cdl.config;

import fr.pawo.partners.cdl.domain.Role;
import fr.pawo.partners.cdl.repository.RoleRepository;
import fr.pawo.partners.cdl.repository.UserRepository;
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
@EnableJpaRepositories(basePackages = {"fr.pawo.partners.cdl"})
@EntityScan(basePackages = {"fr.pawo.partners.cdl"})
@ComponentScan(basePackages = {"fr.pawo.partners.cdl","security"})
public class CoreConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userReposetory;
    @Autowired
    private RoleRepository roleReposetory;
//    @Autowired
//    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(CoreConfig.class, args);
    }
    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

//        accountService.saveRole(new Role(null,"USER",null));
//        Role r1 = new Role("ADMIN");
//
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String pass = bCryptPasswordEncoder.encode("admin");
//
//        User u1 = new User("admin",pass,r1,true);
//        User u2 = new User("dali2",pass,r1,true);
//        this.roleReposetory.save(r1);
//        this.userReposetory.save(u1);
//        this.userReposetory.save(u2);
    }
}
