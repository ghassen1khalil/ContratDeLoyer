package fr.pawo.partners.cdl.rest.controller;


import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppRole;
import fr.pawo.partners.cdl.core.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository accountService;


    @GetMapping("/role")
    public List<AppRole> listRole(){
        return accountService.findAll();
    }
    @PostMapping("/role")
    public void saveRole(@RequestBody AppRole role){
        this.accountService.save(role);
    }
    @PutMapping("/role/{id}")
    public void updateRole(@RequestBody AppRole role){
        this.accountService.save(role);
    }
    @DeleteMapping("/role")
    public void deleteRole(@RequestBody AppRole role){
        this.accountService.save(role);
    }
}
