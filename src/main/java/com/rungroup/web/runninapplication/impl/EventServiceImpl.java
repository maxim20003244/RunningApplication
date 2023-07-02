package com.rungroup.web.runninapplication.impl;

import com.rungroup.web.runninapplication.dto.EventDto;
import com.rungroup.web.runninapplication.models.Club;
import com.rungroup.web.runninapplication.models.Event;
import com.rungroup.web.runninapplication.repository.ClubRepository;
import com.rungroup.web.runninapplication.repository.EventRepository;
import com.rungroup.web.runninapplication.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);


    }
    private Event mapToEvent(EventDto eventDto){
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .createOn(eventDto.getCreateOn())
                .updateTime(eventDto.getUpdateTime())
                .build();
    }
}
