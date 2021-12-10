package com.example.webpproject.controller;

import com.example.webpproject.Owner.Owner;
import com.example.webpproject.Owner.OwnerRepository;
import com.example.webpproject.model.Vet;
import com.example.webpproject.model.VetRepository;
import com.example.webpproject.security.Member;
import com.example.webpproject.security.MemberRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
class VetController {
    private final VetRepository vetRepository;
    private final MemberRepository memberRepository;

    public VetController(VetRepository vetRepository, MemberRepository memberRepository) {
        this.vetRepository = vetRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/profile")
    public String profileForm(Map<String, Object> model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // petclinic member
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            Member member = memberRepository.findByUsername(username);

            Vet vet = vetRepository.findByMemberId(member.getId());
            model.put("member", member);
            model.put("vet", vet);

            return "security/profile";
        }
        // OAUTH member
        else {
            // TODO: link OAUTH with Members
            // redirect to custom
            return "redirect:";
        }

    }

}