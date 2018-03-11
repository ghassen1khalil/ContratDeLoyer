package service;


import fr.pawo.partners.cdl.domain.Role;
import fr.pawo.partners.cdl.domain.User;
import fr.pawo.partners.cdl.repository.RoleRepository;
import fr.pawo.partners.cdl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User saveUser(User user) {
        String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        Role role =roleRepository.findByRoleName(roleName);
        User user = userRepository.findByUserName(userName);
        user.getRole().setRoleName(roleName);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
