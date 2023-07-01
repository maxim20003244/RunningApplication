package com.rungroup.web.runninapplication.controller;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.service.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
