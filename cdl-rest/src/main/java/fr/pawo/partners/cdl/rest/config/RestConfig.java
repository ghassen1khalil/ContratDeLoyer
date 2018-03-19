package fr.pawo.partners.cdl.rest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EntityScan(basePackages = {"fr.pawo.partners.cdl"})
@EnableJpaRepositories(basePackages = {"fr.pawo.partners.cdl"})
@ComponentScan(basePackages = {"fr.pawo.partners.cdl"})
public class RestConfig {

    public static void main(String[] args) {
        SpringApplication.run(RestConfig.class, args);
    }
}
