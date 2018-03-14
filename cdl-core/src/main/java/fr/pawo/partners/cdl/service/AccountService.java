package fr.pawo.partners.cdl.service;

import fr.pawo.partners.cdl.domain.Role;
import fr.pawo.partners.cdl.domain.User;

public interface AccountService {

    public User saveUser(User user);
    public Role saveRole(Role role);
    public void addRoleToUser(User user,Role role);
    public User findUserByUserName(String userName);
}
