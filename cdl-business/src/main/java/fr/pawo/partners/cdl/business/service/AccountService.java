package fr.pawo.partners.cdl.business.service;


import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;

import java.util.List;

public interface AccountService {

    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);

    List<AppUser> getAllUser();
    List<AppRole> getAllRole();


    void addRoleToUser(AppUser user, AppRole role);

    AppUser findUserByUserName(String userName);
}
