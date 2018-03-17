package fr.pawo.partners.cdl.core.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AppUser implements Serializable {
    @Id
    @GeneratedValue()
    private Long idUser;
    private String userName;
    private String password;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "idRole")
    private AppRole role;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_groupe", joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idGroupe"))
    private List<Groupe> groupes;


    public AppUser() {
    }

    public AppUser(Long idUser, String userName, String password, boolean active, AppRole role, List<Groupe> groupes) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.role = role;
        this.groupes = groupes;
        this.idUser = idUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @JsonIgnore
    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }
}
