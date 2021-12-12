package com.example.webpproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @Column(name = "pet_id")
    private Integer petId;

    @Column(name = "vet_id")
    private Integer vetId;

    @Transient
    private List<Treatment> treatments = new ArrayList<>();

    public List<Treatment> getTreatments() {
        return this.treatments;
    }

    public void setTreatments(Collection<Treatment> treatments) {
        this.treatments = new ArrayList<>(treatments);
    }

    @Transient
    private boolean isTreated = false;

    public boolean isTreated() {
        return isTreated;
    }

    public void setTreated(boolean treated) {
        isTreated = treated;
    }

    /**
     * Creates a new instance of Visit for the current date
     */
    public Visit() {
        this.date = LocalDate.now();
    }

}