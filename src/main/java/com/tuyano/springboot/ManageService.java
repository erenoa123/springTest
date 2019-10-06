package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManageService {

	@Autowired
	ManageRepository repository;

	public List<Manage> selectAll(){
		return repository.findAll(new Sort(Sort.Direction.ASC, "playerid"));
	}

	public Manage save(Manage manage) {
		return repository.save(manage);
	}

}
