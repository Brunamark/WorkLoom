package com.workloom.workloom_plataform.domain.users.client;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workloom.workloom_plataform.domain.users.Role;
import com.workloom.workloom_plataform.domain.users.User;
import com.workloom.workloom_plataform.domain.users.embedded.Address;
import com.workloom.workloom_plataform.domain.users.skill.Skill;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "client")
@Entity
@Getter
@Setter
public class Client extends User {

    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private Role role;
    private List<Skill> skills;
    private String enterpriseName;
    private String cnpj;
    private String phone;
    @ElementCollection
    @CollectionTable(name = "client_addresses", joinColumns = @JoinColumn(name = "client_id"))
    private List<Address> address;
    private LocalDateTime createdAt;
    //@JsonIgnore
    private String password;


    public Client() {
    }
    public Client(String name, String email, Role role, List<Skill> skills, String enterpriseName, String cnpj,String phone, List<Address> address) {
        setName(name);
        setEmail(email);
        setRole(role);
        setSkills(skills);
        setEnterpriseName(enterpriseName);
        setCnpj(cnpj);
        setPhone(phone);
        setAddress(address);
    }

}
