package com.example.webpproject.model;

import com.example.webpproject.security.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vets")
public class Vet extends NamedEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "member_id")
    private Integer memberId;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}