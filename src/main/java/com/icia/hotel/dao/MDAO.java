package com.icia.hotel.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.hotel.dto.MEMBER;
import com.icia.hotel.dto.QUESTION;

@Repository
public class MDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public int mJoin(MEMBER member) {
		System.out.println("[3]dao : member -> " + member);
		return sql.insert("Member.mJoin", member);
	}
	
	public MEMBER mLogin(MEMBER member) {
		return sql.selectOne("Member.mLogin", member);
	}
	
	public MEMBER mView(String MId) {
		return sql.selectOne("Member.mView", MId);
	}

	public String idOverlap(String MId) {
		System.out.println("333333333");
		return sql.selectOne("Member.idOverlap", MId);
	}

	public List<QUESTION> qList(String QId) {
		return sql.selectList("Member.qList", QId);
	}

	public QUESTION qView(HashMap<String, String> map) {
		System.out.println(map);
		System.out.println(map.get("Id"));
		System.out.println(map.get("Title"));
		return sql.selectOne("Member.qView", map);
	}
}
