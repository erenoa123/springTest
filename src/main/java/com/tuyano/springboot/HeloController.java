package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	@Autowired
	PlayerService playerService;

	@Autowired
	ManageService manageService;

	@Autowired
	TrainingService trainingService;

	@Autowired
	ResultService resultService;

	@RequestMapping("/home")
	public String Home() {
		return "starter_test";
	}

	@RequestMapping("/regist/player")
	public String RegistPlayer(Model model) {
		model.addAttribute("player",new Player());
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		return "starter_test_form";
	}

	@RequestMapping("/regist/training")
	public String RegistTraining(Model model) {
		model.addAttribute("training",new Training());
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		return "starter_test_form_training";
	}

	@RequestMapping("/regist/manage")
	public String RegistManage(Model model) {
		model.addAttribute("manage",new ManageBean());
		model.addAttribute("playerList", playerService.selectAll());
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		return "starter_test_form_manage";
	}

	@RequestMapping("/result/player1")
	public String Result1(Model model) {
		model.addAttribute("manage",new ManageBean());
		model.addAttribute("playerList", playerService.selectAll());
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		return "starter_test_form_result1";
	}

	@PostMapping(value = "/result/player2")
	public ModelAndView Result2(@ModelAttribute("manage") ManageBean manage , ModelAndView mav) {

		TrainingResultBean result = new TrainingResultBean();

		result.setDate(manage.getDate());
		result.setPlayerid(Integer.valueOf(manage.getPid()));
		List<Manage> manageList = manageService.selectAll();

		for(Manage manageall: manageList) {
			if(result.getDate().equals(manageall.getDate()) && Integer.valueOf(result.getPlayerid()) == manageall.getPlayerid()) {
				result.setClass1(manageall.getClass1());
				}
		}

		List<Training> trainingList = trainingService.selectAll();

		for(Training trainingall : trainingList ) {
			if(result.getDate().equals(trainingall.getDate()) && result.getClass1().equals(trainingall.getClass1())) {
				result.setTrainingid(trainingall.getTrainingid());
				result.setStrength(trainingall.getStrength());
				result.setMenu(trainingall.getMenu());
				result.setKoma(trainingall.getKoma());
				result.setCount(trainingall.getCount());
			}
		}

		List<Player> playerList = playerService.selectAll();

		for(Player playerall : playerList) {
			if(Integer.valueOf(result.getPlayerid()) == playerall.getPlayerid()) {
				result.setName(playerall.getName());
			}
		}

		mav.setViewName("starter_test_form_result2");
		mav.addObject("result",result);

		mav.addObject("check", false);
		mav.addObject("trueVal", "");

		return mav;
	}

	@PostMapping(value = "/result/player3")
	public ModelAndView Result3(@ModelAttribute("result") TrainingResultBean result , ModelAndView mav) {

		Result resultEnt = new Result();

		resultEnt.setPlayerid(Integer.valueOf(result.getPlayerid()));
		resultEnt.setTrainingid(Integer.valueOf(result.getTrainingid()));
		resultEnt.setRank(Integer.valueOf(result.getRank()));

		resultService.save(resultEnt);
		mav.setViewName("starter_test_form_result1");
		mav.addObject("manage",new ManageBean());
		mav.addObject("playerList", playerService.selectAll());
		mav.addObject("check", true);
		mav.addObject("trueVal", "登録完了！");

		return mav;
	}




	@PostMapping(value = "/controller/managesave")
	public ModelAndView insertManage(@ModelAttribute("manage") ManageBean manage , ModelAndView mav) {

		Manage manageEnt = new Manage();

		manageEnt.setDate(manage.getDate());
		manageEnt.setClass1(manage.getClass1());
		manageEnt.setPlayerid(Integer.valueOf(manage.getPid()));
		manageService.save(manageEnt);
		mav.setViewName("starter_test_form_manage");
		mav.addObject("manage",new ManageBean());
		mav.addObject("playerList", playerService.selectAll());
		mav.addObject("check", true);
		mav.addObject("trueVal", "登録完了！");

		return mav;
	}

	@PostMapping(value = "/controller/playersave")
	public ModelAndView insertPlayer(@ModelAttribute("player") Player player, ModelAndView mav) {

		mav.setViewName("starter_test_form");
		mav.addObject("player",new Player());
		playerService.save(player);
		mav.addObject("check", true);
		mav.addObject("trueVal", "登録完了！");

		return mav;
	}

	@PostMapping(value = "/controller/trainingsave")
	public ModelAndView insertTraining(@ModelAttribute("training") Training training, ModelAndView mav) {

		mav.setViewName("starter_test_form_training");
		mav.addObject("training",new Training());
		trainingService.save(training);
		mav.addObject("check", true);
		mav.addObject("trueVal", "登録完了！");

		return mav;
	}


	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView index2(ModelAndView mav) {

		String label[] = {"a","b","c","d","e","f","g"};
		int point[] = {5,3,7,1,8,3,4,};

		mav.addObject("label",label);
		mav.addObject("point",point);


		mav.setViewName("index");
		mav.addObject("msg", "お名前を書いて送信してください");

		return mav;
	}

	@RequestMapping(value = "/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("text1")String str, ModelAndView mav) {

		String label[] = {"a","b","c","d","e","f","g"};
		int point[] = {5,3,7,1,8,3,4,};

		mav.addObject("label",label);
		mav.addObject("point",point);
		mav.addObject("msg", "こんにちは"+str+"さん！");
		mav.addObject("value", str);
		mav.setViewName("index");


		return mav;
	}
}
