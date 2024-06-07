package com.kdk.app.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kdk.app.common.util.json.JacksonUtil;
import com.kdk.app.test.vo.ComplexVo;

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
@RequestMapping("/complex")
public class ComplexTestController {

	@GetMapping("/screen")
	public ModelAndView screen() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("complex/screen");
		return mav;
	}

	@ResponseBody
	@PostMapping("/result")
	public void result(ComplexVo vo) {
		List<Map<String, Object>> list = JacksonUtil.FromJson.converterJsonStrToList(vo.getListJson());

		log.info("vo : {}", vo);

		for (Map<String, Object> map : list) {
			log.info("map : {}", map);
		}
	}

}
