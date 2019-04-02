package com.devpull.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpull.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
