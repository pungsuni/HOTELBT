package com.icia.hotel.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class NOTICE {
	
	private int NNo;
	private String NTitle;
	private String NContent;
	private Date NDate;
}
