package com.rungroup.web.runninapplication.impl;

import com.rungroup.web.runninapplication.dto.ClubDto;
import com.rungroup.web.runninapplication.models.Club;
import com.rungroup.web.runninapplication.models.UserEntity;
import com.rungroup.web.runninapplication.repository.ClubRepository;
import com.rungroup.web.runninapplication.repository.UserRepository;
import com.rungroup.web.runninapplication.security.SecurityUtil;
import com.rungroup.web.runninapplication.service.ClubService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rungroup.web.runninapplication.mappper.ClubMapper.mapToClub;
import static com.rungroup.web.runninapplication.mappper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;
    private final UserRepository userRepository;

    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;

        this.userRepository = userRepository;

    }

    @Override
    public List<ClubDto> findClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
*/
        String currentUserName = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByEmail(currentUserName);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubsById(long clubId) {
        Club club = clubRepository.findById(clubId).get();

        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String userName  =  SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByEmail(userName);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        clubRepository.save(club);
    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);

    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClub(query);

        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

}
