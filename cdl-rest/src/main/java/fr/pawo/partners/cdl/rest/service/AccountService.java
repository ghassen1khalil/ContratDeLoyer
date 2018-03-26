package fr.pawo.partners.cdl.rest.service;

import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.domain.AppUser;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    AppUser saveUser(AppUser user);

    AppRole saveRole(AppRole role);

    List<AppRole> getAllRole();
    List<AppUser> getAllUser();
    AppRole getRole(Long idRole);
    AppUser getUser(Long idUser);
    AppRole updateRole(Long idRole,AppRole role);
    void deleteRole(Long idRole);
    AppUser updateUser(Long idUser,AppUser user);
    void deleteUser(Long idUser);

    void addRoleToUser(AppUser user, AppRole role);

    AppUser findUserByUserName(String userName);
}
