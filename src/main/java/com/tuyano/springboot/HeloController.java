package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	@RequestMapping("/home")
	public String Home() {
		return "starter_test";
	}

	@RequestMapping("/regist/player")
	public String RegistPlayer() {
		return "starter_test_form";
	}

	@RequestMapping("/regist/training")
	public String home() {
		return "starter_test_form_training";
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
