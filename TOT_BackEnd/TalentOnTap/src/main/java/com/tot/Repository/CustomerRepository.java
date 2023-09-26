package com.tot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tot.Classes.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByemailIDAndPassword(String email, String password);

	public Customer findByemailID(String email);
}
