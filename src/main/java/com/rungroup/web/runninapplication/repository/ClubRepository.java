package com.rungroup.web.runninapplication.repository;

import com.rungroup.web.runninapplication.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
}
