package com.kdk.app.test.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileParamVo {

	private String jsonData;
	@JsonIgnore
	private List<MultipartFile> imgFile;

}
