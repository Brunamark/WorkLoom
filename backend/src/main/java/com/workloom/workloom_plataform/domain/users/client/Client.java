package com.workloom.workloom_plataform.domain.users.client;

import java.util.List;

import com.workloom.workloom_plataform.domain.users.User;
import com.workloom.workloom_plataform.domain.users.embedded.Address;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "client")
@Entity
@Getter
@Setter
public class Client extends User {

    @Column(nullable = false)
    private String enterpriseName;

    @Column(nullable = false)
    private String cnpj;

    @ElementCollection
    @CollectionTable(
        name = "client_addresses",
        joinColumns = @JoinColumn(name = "client_id")
    )
    private List<Address> address;

  

}
