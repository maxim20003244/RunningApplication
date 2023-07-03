package com.rungroup.web.runninapplication.service;

import com.rungroup.web.runninapplication.dto.EventDto;

import java.util.List;


public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findByEventId(long eventId);
    void updateEvent(EventDto eventDto);
    void deleteEvent(Long eventId);
}
