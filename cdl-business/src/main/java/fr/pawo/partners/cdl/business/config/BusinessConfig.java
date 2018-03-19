package fr.pawo.partners.cdl.business.config;

import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;
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
    private AccountService accountService;
    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    public void run(String... args) throws Exception {
        AppRole admin = new AppRole(null, "ADMIN", null);
        AppRole user = new AppRole(null, "USER", null);
        AppRole superadmin = new AppRole(null, "SUPER_ADMIN", null);
        this.accountService.saveRole(admin);
        this.accountService.saveRole(user);
        this.accountService.saveRole(superadmin);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("admin");

        AppUser u1 = new AppUser(null, "admin", pass, true, admin, null);
        AppUser u2 = new AppUser(null, "user", pass, true, user, null);
        AppUser u3 = new AppUser(null, "super_admin", pass, true, superadmin, null);
        this.accountService.saveUser(u1);
        this.accountService.saveUser(u2);
        this.accountService.saveUser(u3);
    }
}
