package com.workloom.workloom_plataform.domain.users.client;

import java.util.List;
import java.util.UUID;
import com.workloom.workloom_plataform.domain.users.Role;
import com.workloom.workloom_plataform.domain.users.skill.Skill;

public class ClientRequestDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private List<Skill> skills;
    private String enterpriseName;
    private String cnpj;
    private String streetName;
    private int streetNumber;
    private String city;
    private String state;
    private long zipCode;
    private String phone;

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

    public String getPassword() {
        return password;
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

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public long getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
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

    public void setPassword(String password) {
        this.password = password;
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

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
