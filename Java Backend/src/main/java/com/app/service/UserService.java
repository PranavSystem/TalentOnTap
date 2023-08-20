package com.app.service;

import com.app.entities.Customer;
import com.app.entities.Professional;

public interface UserService {

	    boolean existsByEmail(String email);

	    Customer registerCustomer(Customer request);

	    Professional registerProfessional(Professional request);

	    // Other methods for user-related functionality
	

}
