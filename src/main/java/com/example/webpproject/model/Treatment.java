package com.example.webpproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "treatments")
public class Treatment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private Visit visit;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @Column(name = "description")
    private String description;
}
