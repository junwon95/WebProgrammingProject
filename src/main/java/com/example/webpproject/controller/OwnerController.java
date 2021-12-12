package com.example.webpproject.controller;

import com.example.webpproject.Owner.Owner;
import com.example.webpproject.Owner.OwnerRepository;
import com.example.webpproject.dto.RegisterDto;
import com.example.webpproject.dto.ReservationDto;
import com.example.webpproject.dto.TreatmentDto;
import com.example.webpproject.model.*;
import com.example.webpproject.security.Member;
import com.example.webpproject.security.MemberRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
class OwnerController {
    private final OwnerRepository ownerRepository;
    private final VetRepository vetRepository;
    private final MemberRepository memberRepository;
    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final TreatmentRepository treatmentRepository;

    public OwnerController(VetRepository vetRepository, MemberRepository memberRepository, TreatmentRepository treatmentRepository,
                           VisitRepository visitRepository, PetRepository petRepository, OwnerRepository ownerRepository) {
        this.vetRepository = vetRepository;
        this.memberRepository = memberRepository;
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @GetMapping("/checkReservation")
    public String checkForm(Map<String, Object> model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);
        Owner owner = ownerRepository.findByMemberId(member.getId());
        Collection<Pet> pets = petRepository.findPetsByOwnerId(owner.getId());

        List<Visit> reservations = new ArrayList<>();
        for (Pet pet : pets) {
            List<Visit> visits = visitRepository.findVisitsByPetId(pet.getId());
            for (Visit visit : visits){
                if(!visit.isTreated()) reservations.add(visit);
            }
        }
        model.put("owner",owner);
        model.put("reservations", reservations);
        return "owner/checkReservation";
    }

    @GetMapping("/myPetList")
    public String myPetsForm(Map<String, Object> model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);
        Owner owner = ownerRepository.findByMemberId(member.getId());
        Collection<Pet> pets = petRepository.findPetsByOwnerId(owner.getId());

        model.put("pets",pets);
        return "owner/petList";
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Map<String, Object> model) {
        Pet pet = new Pet();
        model.put("pet", pet);
        return "owner/petAdd";
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Pet pet, BindingResult result, ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);
        Owner owner = ownerRepository.findByMemberId(member.getId());
        pet.setOwner(owner);
        petRepository.save(pet);
        return "redirect:/myPetList";
    }

    @GetMapping("/makeReservation")
    public String reservationForm(Map<String, Object> model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);
        Owner owner = ownerRepository.findByMemberId(member.getId());

        Visit visit = new Visit();
        visit.setTreated(false);
        model.put("visit",visit);
        model.put("owner",owner);

        Collection<Pet> pets = owner.getPets();
        model.put("pets",pets);

        Collection<Vet> vets = vetRepository.findAll();
        model.put("vets",vets);
        return "owner/makeReservation";
    }

    @PostMapping("/makeReservation")
    public String reservationPostForm(Map<String, Object> model, @Valid Visit visit, BindingResult result, @RequestParam("ownerName") String name ){
        if (result.hasErrors()) {
            return "owner/makeReservation";
        }
        else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();
            Member member = memberRepository.findByUsername(username);
            Owner owner = ownerRepository.findByMemberId(member.getId());
            owner.setName(name);

            visitRepository.save(visit);
            Pet pet = petRepository.findPetById(visit.getPetId());
            pet.setVisitsInternal(visitRepository.findVisitsByPetId(pet.getId()));
            return "redirect:/";
        }
    }

    @GetMapping("/treatmentRecords")
    public String treatmentForm(Map<String, Object> model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);
        Owner owner = ownerRepository.findByMemberId(member.getId());

        Collection<Pet> pets = owner.getPets();

        List<TreatmentDto> treatments = new ArrayList<>();

        for(Pet pet : pets){
            Collection<Visit> visits = pet.getVisits();
            for(Visit visit : visits){
                if(!visit.isTreated()){
                    TreatmentDto treatmentDto = new TreatmentDto();
                    Treatment treatment = treatmentRepository.findByVisitId(visit.getId());
                    Vet vet = vetRepository.findById(treatment.getVetId()).orElse(new Vet());
                    treatmentDto.setVetName(vet.getName());
                    treatmentDto.setDescription(treatment.getDescription());
                    treatmentDto.setOwnerName(owner.getName());
                    treatmentDto.setPetName(pet.getName());
                    treatments.add(treatmentDto);
                }
            }
        }
        model.put("treatments",treatments);
        return "owner/treatmentRecords";
    }
}