package com.rungroup.web.runninapplication.controller;

import com.rungroup.web.runninapplication.dto.EventDto;
import com.rungroup.web.runninapplication.models.Event;
import com.rungroup.web.runninapplication.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    private final  EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/{clubId}/new")

    public String createEventForm(@PathVariable("clubId") Long clubId, Model model){
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event" , event);
        return "events-create";

    }
    @PostMapping("/event/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, Model model, EventDto eventDto){
        eventService.createEvent(clubId, eventDto);
        return "redirect:/clubs/"+ clubId;
    }

}
