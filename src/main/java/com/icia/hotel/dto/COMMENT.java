package com.icia.hotel.dto;

import lombok.Data;

@Data
public class COMMENT {
	
	private int CNo;			// 댓글번호(PK)
	private int CBNo;			// 게시글번호(FK)
	private String CWriter;		// 작성자
	private String CContent;	// 댓글내용
	
}
