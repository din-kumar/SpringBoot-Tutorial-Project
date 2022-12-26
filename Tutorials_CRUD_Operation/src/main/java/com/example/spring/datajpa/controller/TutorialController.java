package com.example.spring.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.datajpa.model.Tutorial;
import com.example.spring.datajpa.repository.TutorialRepository;
import com.example.spring.datajpa.service.TutorialsService;


@RestController
public class TutorialController {

	@Autowired
	TutorialRepository tutorialRepository;
	
	@Autowired
	TutorialsService tutorialsService;


	@PostMapping(value = "/placeTutorials")
	public Tutorial addController(@RequestBody Tutorial tutorials) {
		return tutorialsService.postTutorial(tutorials);
	}

	// get a tutorials
	@GetMapping(value = "/getTutorials/{id}")
	public Tutorial getController(@PathVariable long id) {
		return tutorialsService.getTutorial(id);
	}


	
	

	// update a tutorials
	@PutMapping(value = "/updateTutorials/{id}")
	public Tutorial updateController(@PathVariable long id, @RequestBody Tutorial tutorials) {
		return tutorialsService.updateTutorial(tutorials, id);
	}

	// delete a tutorials

	@DeleteMapping(value = "/deleteTutorials/{id}")
	public String deleteController(@PathVariable int id) {
		return tutorialsService.deleteTutorial(id);
	}

	// add a tutorials (with ResponseEntity)
	@PostMapping("/TutorialsValid")
	public ResponseEntity<Tutorial> addValidTutorial(@Validated @RequestBody Tutorial p) {
		Tutorial savedTutorial = tutorialsService.postTutorial(p);
		return new ResponseEntity<Tutorial>(savedTutorial, HttpStatus.CREATED);

	}
	
}
