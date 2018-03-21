package fr.pawo.partners.cdl.rest.controller;


import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/role")
    public List<AppRole> listRole(){
        return accountService.getAllRole();
    }
    @PostMapping("/role")
    public void saveRole(@RequestBody AppRole role){
        this.accountService.saveRole(role);
    }

}
