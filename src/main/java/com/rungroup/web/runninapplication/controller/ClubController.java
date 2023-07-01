package com.rungroup.web.runninapplication.controller;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.models.Club;
import com.rungroup.web.runninapplication.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs= clubService.findClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
        public String createClubForm (Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
        }

        @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,BindingResult result,Model model){
           if(result.hasErrors()){
           model.addAttribute("club", clubDto);
           return "clubs-create";
}
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
        }

        @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm (@PathVariable("clubId") long clubId,Model model){
       ClubDto club = clubService.findClubsById(clubId);
       model.addAttribute("club",club);
        return "clubs-edit";
        }

        @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") long clubId,
                             @Valid @ModelAttribute("club") ClubDto clubDto,
                             BindingResult result){
        if(result.hasErrors()){
            return "clubs-edit";
        }
        clubDto.setId(clubId);
        clubService.updateClub(clubDto);
        return "redirect:/clubs";
    }
}
