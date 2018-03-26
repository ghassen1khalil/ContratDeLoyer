package fr.pawo.partners.cdl.core.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class AppUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<Groupe> groupes= new ArrayList<>();


    public AppUser() {
    }

    public AppUser(String userName, String password, boolean active, AppRole role) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.role = role;
    }

}
