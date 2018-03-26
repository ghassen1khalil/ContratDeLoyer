package fr.pawo.partners.cdl.business.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BusinessConfig implements CommandLineRunner  {
    public static void main(String[] args) {
        SpringApplication.run(BusinessConfig.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }

}
