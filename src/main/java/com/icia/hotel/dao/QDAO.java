package com.icia.hotel.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.hotel.dto.QUESTION;

@Repository
public class QDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public int qWrite(QUESTION question) {
		return sql.insert("Question.qWrite", question);
	}

}
