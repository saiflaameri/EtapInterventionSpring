package com.example.EtapStage.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name="Role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TypeRole typeRole;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return "ROLE_" + typeRole.name();
    }
}
