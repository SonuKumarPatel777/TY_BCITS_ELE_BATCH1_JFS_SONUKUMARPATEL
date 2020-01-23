package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bcits.springcoreannotations.beans.Pet;
@Import(AnimalConfig.class)
@Configuration
public class PetConfig {
	
	
	@Bean
	public Pet getPet() {
		Pet myPet =new Pet();
		myPet.setName("ann");
		return myPet;
	}

}//end of class
