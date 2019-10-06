package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlayerService {

	@Autowired
	PlayerRepository repository;

	public List<Player> selectAll(){
		return repository.findAll(new Sort(Sort.Direction.ASC, "playerid"));
	}

	 public Player save(Player player) {
		    return repository.save(player);
		  }

}
