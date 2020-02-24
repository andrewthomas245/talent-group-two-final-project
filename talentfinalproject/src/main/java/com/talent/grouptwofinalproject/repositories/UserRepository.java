package com.talent.grouptwofinalproject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talent.grouptwofinalproject.entities.*;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserid(Long id);
}
