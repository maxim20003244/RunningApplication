package com.rungroup.web.runninapplication.controller;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.models.Club;
import com.rungroup.web.runninapplication.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
    @GetMapping(value = {"","/","/clubs","/home"})
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

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") long clubId){
        clubService.delete(clubId);
        return "redirect:/clubs";
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

        @GetMapping("/clubs/search")
        public String searchClub(@RequestParam(value = "query")String query, Model model){
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
        }

        @GetMapping("/clubs/{clubId}")
        public String clubDetails(@PathVariable("clubId") long clubId,Model model){
        ClubDto clubDto = clubService.findClubsById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-detail";

        }

        @PostMapping("/clubs/{clubId}/edit")
        public String updateClub(@PathVariable("clubId") long clubId,
                             @Valid @ModelAttribute("club") ClubDto clubDto,Model model,
                             BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("club",clubDto);
            return "clubs-edit";
        }
        clubDto.setId(clubId);
        clubService.updateClub(clubDto);
        return "redirect:/clubs";
    }
}
