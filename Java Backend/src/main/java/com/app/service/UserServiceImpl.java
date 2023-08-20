package com.app.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Customer;
import com.app.entities.Professional;
import com.app.entities.User;
import com.app.repository.CustomerRepository;
import com.app.repository.ProfessionalRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	    @Autowired
	    private UserRepository userRepository;
	    
	    @Autowired
	    private CustomerRepository customerRepository;
	    
	    @Autowired
	    private ProfessionalRepository professionalRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @Autowired
		private ModelMapper mapper;

	    public boolean existsByEmail(String email) {
	        return userRepository.existsByEmail(email);
	    }

	    public Customer registerCustomer(Customer request) {
	        Customer customer = mapper.map(request, Customer.class);
	        
//	        customer.setCust_name(request.getCust_name());
//	        customer.setEmail(request.getEmail());
	        customer.setPassword(passwordEncoder.encode(request.getPassword()));
//	        customer.setContact_no(request.getContact_no());
//	        customer.setAddress(request.getAddress());
	        
	        
	        customerRepository.save(customer);
	        
	        //user
	        User user=mapper.map(request, User.class);
//	        user.setEmail(request.getEmail());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        user.setRole("Customer"); // Set the customer role
	        userRepository.save(user);
	        return customer;
	    }

	    public Professional registerProfessional(Professional request) {
	    	Professional professional = mapper.map(request, Professional.class);
//	        professional.setP_name(request.getP_name());
//	        professional.setEmail(request.getEmail());
	        professional.setPassword(passwordEncoder.encode(request.getPassword()));
//	        professional.setContactNo(request.getContactNo());
//	        professional.setRegion(request.getRegion());
//	        professional.setAddress(request.getAddress());
	        professionalRepository.save(professional);
	        
	       //user
	        User user=mapper.map(request, User.class);
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        user.setRole("Professional"); // Set the professional role
	       professionalRepository.save(professional);
	       return professional;
	    }


}
