package com.rungroup.web.runninapplication.repository;

import com.rungroup.web.runninapplication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role ,Long> {
    Role findByName(String name);
}
