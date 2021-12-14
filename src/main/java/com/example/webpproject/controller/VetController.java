package com.example.webpproject.controller;

import com.example.webpproject.Owner.Owner;
import com.example.webpproject.Owner.OwnerRepository;
import com.example.webpproject.dto.ScheduleDto;
import com.example.webpproject.dto.TreatmentDto;
import com.example.webpproject.model.*;
import com.example.webpproject.security.Member;
import com.example.webpproject.security.MemberRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
class VetController {
    private final VetRepository vetRepository;
    private final MemberRepository memberRepository;
    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final TreatmentRepository treatmentRepository;


    public VetController(VetRepository vetRepository, MemberRepository memberRepository, TreatmentRepository treatmentRepository,
                         VisitRepository visitRepository, PetRepository petRepository, OwnerRepository ownerRepository) {
        this.vetRepository = vetRepository;
        this.memberRepository = memberRepository;
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @GetMapping("/vetsInfo")
    public String vetsInfoForm(Map<String, Object> model) {

        Collection<Vet> results = this.vetRepository.findAll();
        List<Vet> vets = new ArrayList<>();
        for(Vet vet : results){
            if(vet.getName() != null){
                vets.add(vet);
            }
        }
        model.put("vets", vets);
        return "vetsInfo";
    }

    @GetMapping("/profile")
    public String profileForm(Map<String, Object> model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);

        Vet vet = vetRepository.findByMemberId(member.getId());
        model.put("member", member);
        model.put("vet", vet);

        return "security/profile";

    }
    @PostMapping("/profile")
    public String profileChangeForm(Map<String, Object> model, Vet vet) {
        vetRepository.save(vet);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);

        Vet vet2 = vetRepository.findByMemberId(member.getId());
        model.put("member", member);
        model.put("vet", vet2);

        return "security/profile";
    }

    @GetMapping("/schedule")
    public String scheduleForm(Map<String, Object> model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);
        Vet vet = vetRepository.findByMemberId(member.getId());

        Collection<Visit> visits = visitRepository.findByVetId(vet.getId());
        List<ScheduleDto> schedules = new ArrayList<ScheduleDto>();
        for (Visit visit : visits) {
            Integer petId = visit.getPetId();
            Pet pet = petRepository.findPetById(petId);
            Owner owner = pet.getOwner();
            ScheduleDto scheduleDto = new ScheduleDto();
            scheduleDto.setDate(visit.getDate());
            scheduleDto.setDescription(visit.getDescription());
            scheduleDto.setOwnerName(owner.getName());
            scheduleDto.setPetName(pet.getName());
            scheduleDto.setVisitId(visit.getId());
            schedules.add(scheduleDto);
        }

        model.put("schedules", schedules);

        return "vet/schedule";
    }

    @GetMapping("/treatment")
    public String treatmentForm(Map<String, Object> model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Member member = memberRepository.findByUsername(username);
        Vet vet = vetRepository.findByMemberId(member.getId());

        Collection<Visit> visits = visitRepository.findByVetId(vet.getId());
        List<ScheduleDto> schedules = new ArrayList<ScheduleDto>();
        for (Visit visit : visits) {
            if (treatmentRepository.findByVisitId(visit.getId()) != null) {
                Integer petId = visit.getPetId();
                Pet pet = petRepository.findPetById(petId);
                Owner owner = pet.getOwner();
                ScheduleDto scheduleDto = new ScheduleDto();
                scheduleDto.setDate(visit.getDate());
                scheduleDto.setDescription(visit.getDescription());
                scheduleDto.setOwnerName(owner.getName());
                scheduleDto.setPetName(pet.getName());
                scheduleDto.setPrescription(treatmentRepository.findByVisitId(visit.getId()).getDescription());
                schedules.add(scheduleDto);
            }
        }

        model.put("visits", schedules);
        return "vet/treatments";
    }


    @PostMapping("/treatment/new")
    public String postTreatmentForm(Treatment treatment, BindingResult result, ModelMap model) {

        return "redirect:vet/newTreatment";
    }



}