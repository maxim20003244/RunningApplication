package com.rungroup.web.runninapplication.controller;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.dto.EventDto;
import com.rungroup.web.runninapplication.models.Event;
import com.rungroup.web.runninapplication.service.EventService;
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
    public String createEvent(@PathVariable("clubId") Long clubId, Model model, EventDto eventDto,
                              BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("event", eventDto);
            return "clubs-create";
        }
        eventService.createEvent(clubId, eventDto);

        return "redirect:/clubs/"+ clubId;
    }


    @GetMapping("/event")
    public String eventList(Model model){
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("event/{eventId}")
    public String viewEvent(@PathVariable("eventId") long eventId, Model model){
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event",event);
        return "event-detail";
    }

    @GetMapping ("event/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model){
    EventDto eventDto = eventService.findByEventId(eventId);
    model.addAttribute("event", eventDto);
    return "event-edit";
    }
    @PostMapping("/event/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId,
                             @Valid @ModelAttribute("event") EventDto eventDto,Model model,
                             BindingResult result){
        if(result.hasErrors()){
             model.addAttribute("event", eventDto);
            return "event-edit";
        }
        EventDto eventDto1 = eventService.findByEventId(eventId);
       eventDto.setId(eventId);
       eventDto.setClub(eventDto1.getClub());

      eventService.updateEvent(eventDto);
        return "redirect:/event";
    }

}
