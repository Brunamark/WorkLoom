package com.workloom.workloom_plataform.domain.users;

import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Table(name="freelancer")
@Entity
@Getter
@Setter
public class Freelancer extends User {
   

    @ElementCollection
    @CollectionTable(
        name = "freelancer_addresses",
        joinColumns = @JoinColumn(name = "freelancer_id")
    )
    private Address address;

    @ElementCollection
    @CollectionTable(
        name = "freelancer_interest_fields",
        joinColumns = @JoinColumn(name = "freelancer_id")
    )
    private List<String> interestFields;

    @ElementCollection
    @CollectionTable(
        name = "freelancer_experiences",
        joinColumns = @JoinColumn(name = "freelancer_id")
    )
    private List<String> experiences;

    @ElementCollection
    @CollectionTable(
        name = "freelancer_enterprises",
        joinColumns = @JoinColumn(name = "freelancer_id")
    )    
    private List<String> enterprises;
}
