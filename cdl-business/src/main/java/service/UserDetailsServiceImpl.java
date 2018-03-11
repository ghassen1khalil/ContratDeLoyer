package service;

import fr.pawo.partners.cdl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
        User user =accountService.findUserByUserName(userName);
        if (user==null) throw new UsernameNotFoundException(userName);
        GrantedAuthority authorities = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return null;
            }
        };

        return null;
    }
}
