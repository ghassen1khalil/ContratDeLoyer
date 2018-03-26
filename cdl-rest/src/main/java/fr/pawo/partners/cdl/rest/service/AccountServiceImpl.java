package fr.pawo.partners.cdl.rest.service;


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
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public List<AppRole> getAllRole() {
        return this.roleRepository.findAll();
    }

    @Override
    public List<AppUser> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public AppRole updateRole(Long idRole,AppRole role) {
       role.setIdRole(idRole);
       return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long idRole) {
          this.roleRepository.deleteById(idRole);
    }

    @Override
    public AppRole getRole(Long idRole) {
        AppRole role =this.roleRepository.getOne(idRole);
        System.out.println(role);
        return role;
    }
    @Override
    public AppUser updateUser(Long idUser,AppUser user) {
        user.setIdUser(idUser);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        this.userRepository.deleteById(idUser);
    }

    @Override
    public AppUser getUser(Long idUser) {
        AppUser user =this.userRepository.getOne(idUser);
        return user;
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
