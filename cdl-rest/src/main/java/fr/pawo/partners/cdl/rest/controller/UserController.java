package fr.pawo.partners.cdl.rest.controller;

import fr.pawo.partners.cdl.rest.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
@RestController
public class UserController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/user")
    public List<AppUser> userList() {
        return accountService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public AppUser getUser(@PathVariable(value = "id") Long idUser){
        return accountService.getUser(idUser);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody  AppUser user) {
        accountService.saveUser(user);
    }

    @PutMapping("/user/{id}")
    public AppUser updateUser(@PathVariable(value = "id") Long idUser,
                              @Valid @RequestBody AppUser user){

        return this.accountService.updateUser(idUser,user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.accountService.deleteUser(id);

    }
}
