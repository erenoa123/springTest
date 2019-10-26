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

/**
 *URLに対応した処理及び画面遷移を行うクラス
 *
 * @author kurihara
 *
 */
@Controller
public class HeloController {

	/**
	 * 選手情報を扱うサービス
	 * table名：player
	 */
	@Autowired
	PlayerService playerService;

	/**
	 * 選手管理情報を扱うサービス
	 * table名:manage
	 */
	@Autowired
	ManageService manageService;

	/**
	 * トレーニング情報を扱うサービス
	 * table名:training
	 */
	@Autowired
	TrainingService trainingService;

	/**
	 * トレーニング結果を扱うサービス
	 * table名:result
	 */
	@Autowired
	ResultService resultService;

	/**
	 * トレーニング結果画面を表示する
	 * url:/home
	 * @return "starter_test"
	 */
	@RequestMapping("/home")
	public String Home() {
		return "starter_test";
	}

	/**
	 * 選手情報登録画面を表示する
	 * url:/regist/player
	 * @param model
	 * @return "starter_test_form"
	 */
	@RequestMapping("/regist/player")
	public String RegistPlayer(Model model) {
		//登録画面にて選手情報を格納するインスタンスを設定
		model.addAttribute("player",new Player());

		//追加メッセージ表示しない設定
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		//選手登録画面に遷移
		return "starter_test_form";
	}

	/**
	 * トレーニング情報登録画面を表示する
	 * url:/regist/training
	 * @param model
	 * @return "starter_test_form_training"
	 */
	@RequestMapping("/regist/training")
	public String RegistTraining(Model model) {
		//登録画面にてトレーニング情報を格納するインスタンスを設定
		model.addAttribute("training",new Training());

		//追加メッセージを表示しない設定
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		//トレーニング情報登録画面に遷移
		return "starter_test_form_training";
	}

	/**
	 * 選手管理情報を表示する
	 * url:/regist/manage
	 * @param model
	 * @return "starter_test_form_manage"
	 */
	@RequestMapping("/regist/manage")
	public String RegistManage(Model model) {
		//登録画面にて選手管理情報を格納するインスタンスを設定
		model.addAttribute("manage",new ManageBean());

		//登録画面にて選手名をリストで表示するため、選手リストを設定
		model.addAttribute("playerList", playerService.selectAll());

		//追加メッセージを表示しない設定
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		//選手管理情報登録画面に遷移
		return "starter_test_form_manage";
	}

	/**
	 * トレーニング結果表示画面①を表示する
	 * url:/result/player1
	 *
	 * トレーニング実施日及び選手名の入力画面
	 *
	 * @param model
	 * @return "starter_test_form_result1"
	 */
	@RequestMapping("/result/player1")
	public String Result1(Model model) {
		//選手管理情報を格納するインスタンスを設定
		model.addAttribute("manage",new ManageBean());

		//選手名をリストで表示するため、選手リストを設定
		model.addAttribute("playerList", playerService.selectAll());

		//追加メッセージを表示しない設定
		model.addAttribute("check", false);
		model.addAttribute("trueVal","");

		//トレーニング結果表示画面①に遷移
		return "starter_test_form_result1";
	}

	/**
	 * トレーニング結果表示画面②を表示する
	 * url:/result/player2
	 *
	 * トレーニング実施日及び選手名、クラスからトレーニング情報を表示する。
	 * 該当トレーニングの順位を入力する画面。
	 *
	 * @param manage
	 * @param mav
	 * @return mav("starter_test_form_result1")
	 */
	@PostMapping(value = "/result/player2")
	public ModelAndView Result2(@ModelAttribute("manage") ManageBean manage , ModelAndView mav) {
		//トレーニング情報及び結果を格納するインスタンス
		TrainingResultBean result = new TrainingResultBean();

		//選手管理リストの取得
		List<Manage> manageList = manageService.selectAll();

		//選手リストの取得
		List<Player> playerList = playerService.selectAll();

		//トレーニングリストの取得
		List<Training> trainingList = trainingService.selectAll();

		//トレーニング結果表示画面①にて入力された、トレーニング実施日、playeridを取得する
		result.setDate(manage.getDate());
		result.setPlayerid(Integer.valueOf(manage.getPid()));

		//選手idから選手名を設定
		for(Player playerall : playerList) {
			if(Integer.valueOf(result.getPlayerid()) == playerall.getPlayerid()) {
				result.setName(playerall.getName());
			}
		}

		//選手id及びトレーニング実施日から該当クラスを設定
		for(Manage manageall: manageList) {
			if(result.getDate().equals(manageall.getDate()) && Integer.valueOf(result.getPlayerid()) == manageall.getPlayerid()) {
				result.setClass1(manageall.getClass1());
			}
		}

		//クラスが取得出来なかった場合、該当トレーニング実施日に、対象選手情報が登録されていないことを追加メッセージにて表示
		if(result.getClass1() == null) {
			//トレーニング結果表示画面②を設定
			mav.setViewName("starter_test_form_result1");

			//選手管理情報を格納するインスタンスを設定
			mav.addObject("manage",new ManageBean());

			//選手リストを設定
			mav.addObject("playerList", playerService.selectAll());

			//追加メッセージを設定する
			mav.addObject("check", true);
			mav.addObject("trueVal", result.getDate()+"に"+result.getName()+"さんの管理情報が登録されていません");

			//画面遷移
			return mav;
		}

		//トレーニング情報及び結果インスタンスのトレーニングidを初期化
		result.setTrainingid(0);

		//実施日及びクラスからトレーニング情報を取得
		for(Training trainingall : trainingList ) {
			if(result.getDate().equals(trainingall.getDate()) && result.getClass1().equals(trainingall.getClass1())) {
				result.setTrainingid(trainingall.getTrainingid());
				result.setStrength(trainingall.getStrength());
				result.setMenu(trainingall.getMenu());
				result.setKoma(trainingall.getKoma());
				result.setCount(trainingall.getCount());
			}
		}

		//トレーニング情報が取得出来なかった場合、該当トレーニング実施日のトレーニング情報が登録されていないことを追加メッセージで表示
		if(result.getTrainingid() == 0) {
			//トレーニング結果表示画面②を設定
			mav.setViewName("starter_test_form_result1");

			//選手管理情報を格納するインスタンスを設定
			mav.addObject("manage",new ManageBean());

			//選手リストを設定
			mav.addObject("playerList", playerService.selectAll());

			//追加メッセージを設定する
			mav.addObject("check", true);
			mav.addObject("trueVal", result.getDate()+"に"+result.getClass1()+"のトレーニング情報が登録されていません");

			//画面遷移
			return mav;
		}

		//トレーニング結果表示画面②を設定
		mav.setViewName("starter_test_form_result2");

		//トレーニング情報及び結果インスタンスを設定
		mav.addObject("result",result);

		//追加メッセージを表示しない設定
		mav.addObject("check", false);
		mav.addObject("trueVal", "");

		//画面遷移
		return mav;
	}

	/**
	 * 登録完了の旨をトレーニング結果表示画面①にて表示
	 * url:/regist/player3
	 *
	 * トレーニング結果表示画面②で入力した、順位をdbに登録し、登録完了の旨を表示する
	 *
	 * @param result
	 * @param mav
	 * @return mav("starter_test_form_result1")
	 */
	@PostMapping(value = "/result/player3")
	public ModelAndView Result3(@ModelAttribute("result") TrainingResultBean result , ModelAndView mav) {

		//トレーニング結果インスタンスを設定
		Result resultEnt = new Result();

		//トレーニング結果の設定
		//選手idの設定
		resultEnt.setPlayerid(Integer.valueOf(result.getPlayerid()));
		//トレーニングidの設定
		resultEnt.setTrainingid(Integer.valueOf(result.getTrainingid()));
		//順位の設定
		resultEnt.setRank(Integer.valueOf(result.getRank()));
		//順位から得点を設定
		//得点算出式 : 11 - 順位
		resultEnt.setPoint(11-Integer.valueOf(result.getRank()));

		//トレーニング結果をdbに登録
		resultService.save(resultEnt);

		//トレーニング結果表示画面①を設定
		mav.setViewName("starter_test_form_result1");

		//選手管理情報を格納するインスタンスを設定
		mav.addObject("manage",new ManageBean());

		//選手リストを設定
		mav.addObject("playerList", playerService.selectAll());

		//追加メッセージを表示しない設定
		mav.addObject("check", true);
		mav.addObject("trueVal", "登録完了！");

		//画面遷移
		return mav;
	}

	/**
	 * 選手管理情報を登録
	 *
	 * @param manage
	 * @param mav
	 * @return
	 */
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

	/**
	 * 選手情報を登録
	 *
	 * @param player
	 * @param mav
	 * @return
	 */
	@PostMapping(value = "/controller/playersave")
	public ModelAndView insertPlayer(@ModelAttribute("player") Player player, ModelAndView mav) {

		mav.setViewName("starter_test_form");
		mav.addObject("player",new Player());
		playerService.save(player);
		mav.addObject("check", true);
		mav.addObject("trueVal", "登録完了！");

		return mav;
	}

	/**
	 * トレーニング情報を登録
	 *
	 * @param training
	 * @param mav
	 * @return
	 */
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


		mav.setViewName("starter_test");

		return mav;
	}

	@RequestMapping(value = "/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("text1")String str, ModelAndView mav) {

//		String label[] = {"a","b","c","d","e","f","g"};
//		int point[] = {5,3,7,1,8,3,4,};
//
//		mav.addObject("label",label);
//		mav.addObject("point",point);
//		mav.addObject("msg", "こんにちは"+str+"さん！");
//		mav.addObject("value", str);
		mav.setViewName("starter_test");


		return mav;
	}
}
