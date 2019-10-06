package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class RController {

	@Autowired
	PlayerService playerService;

	@Autowired
	ManageService manageService;

	@Autowired
	TrainingService trainingService;

	@Autowired
	ResultService resultService;

	// 一覧表示
	@RequestMapping(value = "/playerall")
	public List<Player> playerSelectAll() {
		return playerService.selectAll();
	}

	// 一覧表示
	@RequestMapping(value = "/manageall", method = RequestMethod.GET)
	public List<Manage> manageSelectAll() {
		return manageService.selectAll();
	}

	// 一覧表示
	@RequestMapping(value = "/trainingall", method = RequestMethod.GET)
	public List<Training> TrainingSelectAll() {
		return trainingService.selectAll();
	}

	// 一覧表示
	@RequestMapping(value = "/resultall", method = RequestMethod.GET)
	public List<Result> resultSelectAll() {
		return resultService.selectAll();
	}

}
