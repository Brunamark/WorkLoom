package com.workloom.workloom_plataform.domain.users;

import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "client")
@Entity
@Getter
@Setter
public class Client extends User {

    @Column(nullable = true)
    private String enterpriseName;

    @Column(nullable = true)
    private String cnpj;

    @ElementCollection
    @CollectionTable(
        name = "client_addresses",
        joinColumns = @JoinColumn(name = "client_id")
    )
    private List<Address> address;

    @ManyToMany
    @JoinTable(
        name = "client_skills", 
        joinColumns = @JoinColumn(name = "client_id"), 
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;
    


}
