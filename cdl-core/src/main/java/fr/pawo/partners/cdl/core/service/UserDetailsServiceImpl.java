package fr.pawo.partners.cdl.core.service;

import fr.pawo.partners.cdl.core.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = accountService.findUserByUserName(userName);
        if (appUser == null) throw new UsernameNotFoundException(userName);

        Collection<GrantedAuthority> authoritie = new ArrayList<>();
        authoritie.add(new SimpleGrantedAuthority(appUser.getRole().getRoleName()));
        return new org.springframework.security.core.userdetails.User(appUser.getUserName(), appUser.getPassword(), authoritie);


    }
}
