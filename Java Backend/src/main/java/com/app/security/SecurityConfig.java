//package com.app.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//public class SecurityConfig {
//
//	
//	    @Autowired
//	    private UserDetailsService userDetailsService;
//
//	    @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	    }
//
////	    @Bean
////	    public PasswordEncoder passwordEncoder() {
////	        return new BCryptPasswordEncoder();
////	    }
//
//	    @Bean
//	    @Override
//	    public AuthenticationManager authenticationManagerBean() throws Exception {
//	        return super.authenticationManagerBean();
//	    }
//
//}
