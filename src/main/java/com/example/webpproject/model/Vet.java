package com.example.webpproject.model;

import com.example.webpproject.security.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import java.util.*;

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

    @Transient
    private Set<Visit> visits = new LinkedHashSet<>();

    protected Set<Visit> getVisitsInternal() {
        if (this.visits == null) {
            this.visits = new HashSet<>();
        }
        return this.visits;
    }

    public void setVisitsInternal(Collection<Visit> visits) {
        this.visits = new LinkedHashSet<>(visits);
    }

    public List<Visit> getVisits() {
        List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
        PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
        return Collections.unmodifiableList(sortedVisits);
    }

    public void addVisit(Visit visit) {
        getVisitsInternal().add(visit);
        visit.setPetId(this.getId());
    }

}