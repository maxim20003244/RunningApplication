package com.rungroup.web.runninapplication.service;

import com.rungroup.web.runninapplication.dto.EventDto;


public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
}
