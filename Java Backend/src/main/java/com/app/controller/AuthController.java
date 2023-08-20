package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;

import com.app.dto.AuthRequestDTO;
import com.app.entities.Customer;
import com.app.entities.Professional;
import com.app.entities.User;
//import com.app.jwt_utils.JwtTokenUtil;
import com.app.repository.UserRepository;
import com.app.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {
	   
	 @Autowired
	    private UserService userService;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    //login wale autowired
//	    @Autowired
//	    private AuthenticationManager authenticationManager;
//
//	    @Autowired
//	    private UserDetailsService userDetailsService;
//
//	    @Autowired
//	    private JwtTokenUtil jwtTokenUtil;
//	    
	    //ithee end zale
	    
	    //customer registration
	    @PostMapping("/register/customer")
	    public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer request) {
	        if (userService.existsByEmail(request.getEmail())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already in use");
	        }

	        userService.registerCustomer(request);

	        return ResponseEntity.status(HttpStatus.CREATED).body("Customer registration successful");
	    }
	    
	    //professional registration
	    @PostMapping("/register/professional")
	    public ResponseEntity<String> registerProfessional(@Valid @RequestBody Professional request) {
	        if (userService.existsByEmail(request.getEmail())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already in use");
	        }

	        userService.registerProfessional(request);

	        return ResponseEntity.status(HttpStatus.CREATED).body("Professional registration successful");
	    }
	    
	    //RoleBAsedLogin
	    
//	    @PostMapping("/login/customer")
//	    public ResponseEntity<String> loginCustomer(@Valid @RequestBody AuthRequestDTO request) {
//	        return loginUser(request, "Customer");
//	    }
//
//	    @PostMapping("/login/professional")
//	    public ResponseEntity<String> loginProfessional(@Valid @RequestBody AuthRequestDTO request) {
//	        return loginUser(request, "Professional");
//	    }
//
//	    @PostMapping("/login/admin")
//	    public ResponseEntity<String> loginAdmin(@Valid @RequestBody AuthRequestDTO request) {
//	        return loginUser(request, "Admin");
//	    }
//
//	    private ResponseEntity<String> loginUser(AuthRequestDTO request, String role) {
//	        try {
//	            Authentication authentication = authenticationManager.authenticate(
//	                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//	            );
//
//	            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
//	            if (!userDetails.getAuthorities().contains(role)) {
//	                return ResponseEntity.badRequest().body("Invalid role for login");
//	            }
//
//	            final String token = jwtTokenUtil.generateToken(userDetails);
//
//	            return ResponseEntity.ok(token);
//	        } catch (UsernameNotFoundException e) {
//	            return ResponseEntity.badRequest().body("Invalid email or password");
//	        }
//	    }
	    
	    

	

}
