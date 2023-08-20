package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;
import com.app.entities.User;

public interface CustomerRepository extends JpaRepository<Customer, Long> 
{
   

}
