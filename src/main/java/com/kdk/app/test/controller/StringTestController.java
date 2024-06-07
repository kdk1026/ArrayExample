package com.kdk.app.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2024. 6. 7. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@Slf4j
@Controller
@RequestMapping("/strings")
public class StringTestController {

	@GetMapping("/screen")
	public ModelAndView screen() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("strings/screen");
		return mav;
	}

	@ResponseBody
	@PostMapping("/result")
	public void result(@RequestParam(value = "reviews[]") List<String> reviews) {
		log.info("reviews : {}", reviews);
	}

}
