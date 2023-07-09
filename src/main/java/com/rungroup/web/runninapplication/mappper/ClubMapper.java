package com.rungroup.web.runninapplication.mappper;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.models.Club;

import java.util.stream.Collectors;

import static com.rungroup.web.runninapplication.mappper.EventMapper.mapToEventDto;

public class ClubMapper {

    public static Club mapToClub(ClubDto club){
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createOn(club.getCreateOn())
                .createdBy(club.getCreatedBy())
                .updateOn(club.getUpdateOn())

                .build();
        return clubDto;
    }

    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .id(club.getId())
                .title(club.getTitle())
                .createdBy(club.getCreatedBy())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .events(club.getEvent().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
