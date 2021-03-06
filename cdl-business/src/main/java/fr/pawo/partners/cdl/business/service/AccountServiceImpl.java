package fr.pawo.partners.cdl.business.service;


import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;
import fr.pawo.partners.cdl.core.repository.RoleRepository;
import fr.pawo.partners.cdl.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return userRepository.save(user);
    }

    @Override
    public List<AppUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<AppRole> getAllRole() {
        return this.roleRepository.findAll();
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(AppUser user, AppRole role) {
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public AppUser findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
