package fr.pawo.partners.cdl.service;

import fr.pawo.partners.cdl.domain.AppRole;
import fr.pawo.partners.cdl.domain.AppUser;

public interface AccountService {

    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(AppUser user, AppRole role);
    public AppUser findUserByUserName(String userName);
}
