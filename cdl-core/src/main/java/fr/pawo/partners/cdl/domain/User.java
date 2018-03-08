package fr.pawo.partners.cdl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String userName;
    private String password;
    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_groupe", joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idGroupe"))
    private List<Groupe> groupes;


    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
