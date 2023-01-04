//package com.masai.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.masai.security.CustomUserDetailService;
//import com.masai.security.JwtAuthenticationEntryPoint;
//import com.masai.security.JwtAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity
//public class SecurityCong extends WebSecurityConfigurerAdapter{
//
//	
//	@Autowired
//	private CustomUserDetailService customUserDetailService;
//	
//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	
//	@Autowired
//	private JwtAuthenticationFilter jwtAuthenticationFilter;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//
//		http
//		   .csrf()
//		   .disable()
//		   .authorizeHttpRequests()
//		   .antMatchers("/api/v1/auth/login").permitAll()
//		   .anyRequest()
//		   .authenticated()
//		   .and()
//		   .exceptionHandling()
//		   .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//		   .and()
//		   .sessionManagement()
//		   .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		   
//		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		
//	}
//
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//
//		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
//		
//	}
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//
//
//        return new BCryptPasswordEncoder();
//
//    }
//
//}
