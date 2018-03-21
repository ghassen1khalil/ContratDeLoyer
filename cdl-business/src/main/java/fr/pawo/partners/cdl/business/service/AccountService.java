package fr.pawo.partners.cdl.business.service;

import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;

import java.util.List;

public interface AccountService {

    AppUser saveUser(AppUser user);

    AppRole saveRole(AppRole role);

    List<AppRole> getAllRole();
    List<AppUser> getAllUser();
    void addRoleToUser(AppUser user, AppRole role);

    AppUser findUserByUserName(String userName);
}
