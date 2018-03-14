package fr.pawo.partners.cdl.config;

import fr.pawo.partners.cdl.domain.Role;
import fr.pawo.partners.cdl.domain.User;
import fr.pawo.partners.cdl.repository.RoleRepository;
import fr.pawo.partners.cdl.repository.UserRepository;
import fr.pawo.partners.cdl.service.AccountService;
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
@ComponentScan(basePackages = {"fr.pawo.partners.cdl","rest.controller"})
public class CoreConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userReposetory;
    @Autowired
    private RoleRepository roleReposetory;
    @Autowired
    private AccountService accountService;

    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
    public static void main(String[] args) {
        SpringApplication.run(CoreConfig.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        Role r1= accountService.saveRole(new Role(null, "ADMIN",null));
//        Role r2 =accountService.saveRole(new Role(null, "USER",null));
//        Role r3 =accountService.saveRole(new Role(null,"SUPER_ADMIN",null));
//        User u1 = accountService.saveUser(new User(null,"admin","1234",true,null,null));
//        User u2 = accountService.saveUser(new User(null,"user","1234",true,null,null));
//        User u3=  accountService.saveUser(new User(null,"super_admin","1234",true,null,null));
//        accountService.addRoleToUser(u1, r1);
//        accountService.addRoleToUser(u2,r2);
//        accountService.addRoleToUser(u3, r3);

//        Role admin = new Role(null,"ADMIN",null);
//        Role user = new Role(null,"USER",null);
//        Role superadmin= new Role(null,"SUPER_ADMIN",null);
//
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String pass = bCryptPasswordEncoder.encode("admin");
//
//        User u1 = new User(null,"admin",pass,true,admin,null);
//        User u2 = new User(null,"user",pass,true,user,null);
//        User u3 = new User(null,"super_admin",pass,true,superadmin,null);
//        this.roleReposetory.save(admin);
//        this.roleReposetory.save(user);
//        this.roleReposetory.save(superadmin);
//        this.userReposetory.save(u1);
//        this.userReposetory.save(u2);
//        this.userReposetory.save(u3);
    }
}
