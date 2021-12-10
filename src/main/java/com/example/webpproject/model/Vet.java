package com.example.webpproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "vets")
public class Vet extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}