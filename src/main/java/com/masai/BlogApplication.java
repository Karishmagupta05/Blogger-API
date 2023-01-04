package com.masai;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BlogApplication {
//public class BlogApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    
//    
//	@Override
//	public void run(String... args) throws Exception {
//		
//
//		System.out.println(this.passwordEncoder.encode("xyz"));
//		
//	}

}
