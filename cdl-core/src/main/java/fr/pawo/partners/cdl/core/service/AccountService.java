package fr.pawo.partners.cdl.core.service;

import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;

public interface AccountService {

    AppUser saveUser(AppUser user);

    AppRole saveRole(AppRole role);

    void addRoleToUser(AppUser user, AppRole role);

    AppUser findUserByUserName(String userName);
}
