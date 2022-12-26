package com.example.spring.datajpa.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.datajpa.model.Tutorial;
import com.example.spring.datajpa.repository.TutorialRepository;
import com.example.spring.datajpa.service.TutorialsService;

@Service
public class TutorialsServiceImpl implements TutorialsService {

	@Autowired
	private TutorialRepository tutorialRepository;
	

	@Override
	public Tutorial postTutorial(Tutorial c) {

		return tutorialRepository.save(c);
	}

	@Override
	public Tutorial getTutorial(long id) {
		// TODO Auto-generated method stub
		return tutorialRepository.findById(id).get();
	}

	

	@Override
	public Tutorial updateTutorial(Tutorial params, long id) {
		// TODO Auto-generated method stub
		Tutorial _tutorial = tutorialRepository.findById(id).get();
		_tutorial.setTitle(params.getTitle());
		_tutorial.setDescription(params.getDescription());
		return tutorialRepository.save(_tutorial);
	}

	@Override
	public String deleteTutorial(long id) {
		// TODO Auto-generated method stub
		tutorialRepository.deleteById(id);
		return "the tutorial with id " + id + " has been deleted...";
	}
	
}
