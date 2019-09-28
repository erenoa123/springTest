package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

//	@RequestMapping("/")
//	public String index(Model model) {
//		 // 横軸
//        // ラベルです。String型の配列に、適当に値を入れておきます。
//        String label[] = {"a","b","c","d","e","f","g"};
//
//        // 縦軸
//        // 具体的な値です。int型で、この値も適当です。
//        int point[] = {5,3,7,1,8,3,4,};
//
//        // Modelに格納します。ビュー側でグラフ用の配列を受け取れるようにしておきます。
//        model.addAttribute("label",label);
//        model.addAttribute("point",point);
//
//		return "index";
//	}

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
