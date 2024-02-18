package com.icia.hotel.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class REVIEW {
	
	private int RENo;
	private String REId;
	private String RETitle;
	private String REContent;
	private MultipartFile REFile;
	private String REFileName;

}
