//package service;
//
//import fr.pawo.partners.cdl.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//
//import org.springframework.stereotype.Service;
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private AccountService accountService;
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        fr.pawo.partners.cdl.domain.User user =accountService.findUserByUserName(userName);
//        if (user==null) throw new UsernameNotFoundException(userName);
//         GrantedAuthority authoritie = new SimpleGrantedAuthority(user.getRole().getRoleName());
//
//        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), (Collection<? extends GrantedAuthority>) authoritie);
//    }
//}
