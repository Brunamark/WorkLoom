package com.workloom.workloom_plataform.domain.users;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
public class Skill {
    
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = true, unique = true)
    private String name;
    
}
