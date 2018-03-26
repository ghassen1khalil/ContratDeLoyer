package fr.pawo.partners.cdl.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<AppUser> user= new ArrayList<>();


    public AppRole(String roleName) {
        this.roleName = roleName;
    }

    @JsonIgnore
    public List<AppUser> getUser() {
        return user;
    }

}
