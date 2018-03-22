package fr.pawo.partners.cdl.rest.controller;


import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/role")
    public List<AppRole> listRole(){
        return accountService.getAllRole();
    }

    @GetMapping("/role/{id}")
    public AppRole getRole(@PathVariable(value = "id") Long idRole){

        return accountService.getRole(idRole);
    }

    @PostMapping("/role")
    public void saveRole(@RequestBody AppRole role){
        this.accountService.saveRole(role);
    }
    @PutMapping("/role/{id}")
    public AppRole updateRole(@PathVariable(value = "id") Long idRole,
                           @Valid @RequestBody AppRole role){

        return this.accountService.updateRole(idRole,role);
    }

    @DeleteMapping("/role/{id}")
    public void deleteRole(@PathVariable Long id) {
        this.accountService.deleteRole(id);

    }


}
