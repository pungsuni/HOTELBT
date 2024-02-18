package com.icia.hotel.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.hotel.dto.AROUND;
import com.icia.hotel.dto.NOTICE;
import com.icia.hotel.dto.PAGE;
import com.icia.hotel.dto.ROOM;

@Repository
public class RDAO {

	@Autowired
	private SqlSessionTemplate sql;

	// 객실 목록보기
	public List<ROOM> rList() {
		return sql.selectList("Room.rList");
	}

	// 객실 상세보기
	public ROOM rView(String RFileName) {
		return sql.selectOne("Room.rView", RFileName);
	}

	// 주변시설 보기
	public List<AROUND> rAround() {
		return sql.selectList("Room.rAround");
	}

	public int rNListCount() {
		return sql.selectOne("Room.rNListCount");
	}

	public List<NOTICE> rNotice(PAGE paging) {
		return sql.selectList("Room.rNlist", paging);
	}

	public NOTICE rNview(int NNo) {
		return sql.selectOne("Room.rNview", NNo);
	}
}
