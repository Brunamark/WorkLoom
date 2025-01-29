package com.workloom.workloom_plataform.domain.users.client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.workloom.workloom_plataform.domain.users.Role;
import com.workloom.workloom_plataform.domain.users.embedded.AddressDTO;
import com.workloom.workloom_plataform.domain.users.skill.Skill;

public class ClientRequestDTO {
    private UUID id;
    private String name;
    private String email;
    private Role role;
    private List<Skill> skills;
    private String enterpriseName;
    private String cnpj;
    private String phone;
    private List<AddressDTO> addresses = new ArrayList<>();
    private String password;


    public ClientRequestDTO() {
    }

    public ClientRequestDTO(String name, String email, Role role, List<Skill> skills, String enterpriseName, String cnpj, String phone) {
        setName(name);
        setEmail(email);
        setRole(role);
        setSkills(skills);
        setEnterpriseName(enterpriseName);
        setCnpj(cnpj);
        setPhone(phone);
        
    }
    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    

    public Role getRole() {
        return role;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getCnpj() {
        return cnpj;
    }

    
    
    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

   

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<AddressDTO> getAddresses() {
        return addresses;
    }
    
    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
    
}
