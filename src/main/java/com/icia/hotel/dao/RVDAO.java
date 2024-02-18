package com.icia.hotel.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.hotel.dto.PAGE;
import com.icia.hotel.dto.REVIEW;

@Repository
public class RVDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public List<REVIEW> rvList(PAGE paging) {
		return sql.selectList("Review.rvList", paging);
	}

	public int rvListCount() {
		return sql.selectOne("Review.rvListCount");
	}

	public int rvWrite(REVIEW review) {
		System.out.println(review);
		return sql.insert("Review.rvWrite", review);
	}

	public REVIEW rvView(int RENo) {
		return sql.selectOne("Review.rvView", RENo);
	}

}
