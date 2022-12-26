package com.example.spring.datajpa.service;

import org.springframework.stereotype.Component;

import com.example.spring.datajpa.model.Tutorial;

@Component
public interface TutorialsService {
	Tutorial postTutorial(Tutorial t);

	Tutorial getTutorial(long id);

	Tutorial updateTutorial(Tutorial params, long id);

	String deleteTutorial(long id);

}
