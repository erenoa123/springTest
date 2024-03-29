package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainingService {

	@Autowired
	TrainingRepository repository;

	public List<Training> selectAll(){
		return repository.findAll(new Sort(Sort.Direction.ASC, "trainingid"));
	}

	public Training save(Training training) {
		return repository.save(training);
	}

}
