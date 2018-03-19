package fr.pawo.partners.cdl.rest.controller;

import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/role")
    public List<AppRole> userList() {
        return accountService.getAllRole();
    }
    @PostMapping("/role")
    public void saveUser(@RequestBody  AppRole role) {
        accountService.saveRole(role);
    }

}
