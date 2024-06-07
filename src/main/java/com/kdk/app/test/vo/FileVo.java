package com.kdk.app.test.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileVo {

	private String fileSn;
	private String isExistFile;
	private MultipartFile file;

}
