package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreannotations.beans.Elephent;
import com.bcits.springcoreannotations.beans.Goat;

@Configuration
public class AnimalConfig {
	@Bean
	public Goat getGoat() {
		return new Goat();
	}
	@Bean
	@Primary
	public Elephent getElephant() {
		return new Elephent();
	}

}//End of class
