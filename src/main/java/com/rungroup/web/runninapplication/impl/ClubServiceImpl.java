package com.rungroup.web.runninapplication.impl;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.models.Club;
import com.rungroup.web.runninapplication.repository.ClubRepository;
import com.rungroup.web.runninapplication.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
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

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubsById(long clubId) {
        Club club = clubRepository.findById(clubId).get();

        return mapToClubs(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    private Club mapToClub(ClubDto club){
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())

                .build();
        return clubDto;
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
