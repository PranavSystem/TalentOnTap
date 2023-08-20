package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Professional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long>  {

}
