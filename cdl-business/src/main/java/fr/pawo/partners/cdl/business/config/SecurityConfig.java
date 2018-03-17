package fr.pawo.partners.cdl.business.config;

import fr.pawo.partners.cdl.business.service.security.JWTAuthenticationFilter;
import fr.pawo.partners.cdl.business.service.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /*@Autowired
    private DataSource dataSource;*/


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select user_name as principal, password as credentials, active from user where user_name=?")
        .authoritiesByUsernameQuery("select u.user_name, r.role_name from user u join role r on u.id_role = r.id_role where user_name = ?")
        .passwordEncoder(new BCryptPasswordEncoder());*/

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /*http.formLogin();
        pour dire à spring security que tous les rquete doit être authentifier
        http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasAuthority("ADMIN");*/
        http.authorizeRequests().antMatchers("/login/**").permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
}
