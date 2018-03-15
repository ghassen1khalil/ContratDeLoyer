package fr.pawo.partners.cdl.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class AppUser implements Serializable{
    @Id
    @GeneratedValue()
    private Long id;
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
}
