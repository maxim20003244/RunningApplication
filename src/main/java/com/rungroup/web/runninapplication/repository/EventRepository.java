package com.rungroup.web.runninapplication.repository;

import com.rungroup.web.runninapplication.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event, Long >{

}
