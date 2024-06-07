package com.kdk.app.test.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdk.app.test.vo.PostVo;

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
@RequestMapping("/objects")
public class ObjectTestController {

	@GetMapping("/screen")
	public ModelAndView screen() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("objects/screen");
		return mav;
	}

	@ResponseBody
	@PostMapping("/result")
	public void result(@RequestBody List<PostVo> posts) {

		for (PostVo vo : posts) {
			log.info("vo : {}", vo);
		}
	}

	@GetMapping("/screen2")
	public ModelAndView screen2() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("objects/screen2");
		return mav;
	}

	@ResponseBody
	@PostMapping("/result2")
	public void result2(String jsonData) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<PostVo> list = Arrays.asList(mapper.readValue(jsonData, PostVo[].class));

		for (PostVo vo : list) {
			log.info("vo : {}", vo);
		}
	}

}
