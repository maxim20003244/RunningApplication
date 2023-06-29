package com.rungroup.web.runninapplication.impl;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.models.Club;
import com.rungroup.web.runninapplication.repository.ClubRepository;
import com.rungroup.web.runninapplication.service.ClubService;

import java.util.List;
import java.util.stream.Collectors;

public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;

    }

    @Override
    public List<ClubDto> findClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubs(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubs(Club club){
      ClubDto clubDto = ClubDto.builder()
              .content(club.getContent())
              .photoUrl(club.getPhotoUrl())
              .id(club.getId())
              .title(club.getTitle())
              .createOn(club.getCreateOn())
              .updateOn(club.getUpdateOn())
              .build();
      return clubDto;
    }
}
