package com.rungroup.web.runninapplication.mappper;

import com.rungroup.web.runninapplication.dto.EventDto;
import com.rungroup.web.runninapplication.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto){
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
    public static EventDto mapToEventDto(Event event){
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .createOn(event.getCreateOn())
                .updateTime(event.getUpdateTime())
                .build();
    }
}
