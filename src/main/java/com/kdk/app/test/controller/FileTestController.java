package com.kdk.app.test.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdk.app.test.vo.FileParamVo;
import com.kdk.app.test.vo.FileVo;

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
@RequestMapping("/files")
public class FileTestController {

	@GetMapping("/screen")
	public ModelAndView screen() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("files/screen");
		return mav;
	}

	@ResponseBody
	@PostMapping("/result")
	public void result(FileParamVo vo) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<FileVo> list = Arrays.asList(mapper.readValue(vo.getJsonData(), FileVo[].class));

		// 머지
		int nIdx = -1;
		for (FileVo fileVo : list) {
			if ( fileVo.getIsExistFile().equals("Y") ) {
				nIdx ++;
				fileVo.setFile( vo.getImgFile().get(nIdx) );
			}
		}

		for (FileVo fileVo : list) {
			log.info("{}", fileVo);
		}
	}

}
