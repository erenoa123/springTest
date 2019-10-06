package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResultService {

	@Autowired
	ResultRepository repository;

	public List<Result> selectAll(){
		return repository.findAll();
	}

	public Result save(Result result) {
		return repository.save(result);
	}

}
