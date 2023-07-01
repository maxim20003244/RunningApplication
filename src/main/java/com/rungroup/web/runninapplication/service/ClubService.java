package com.rungroup.web.runninapplication.service;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findClubs();
    Club saveClub(Club club);

    ClubDto findClubsById(long clubId);

    void updateClub(ClubDto clubDto);
}
