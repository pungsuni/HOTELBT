package com.icia.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.hotel.dto.COMMENT;
import com.icia.hotel.dto.MEMBER;
import com.icia.hotel.dto.NOTICE;
import com.icia.hotel.dto.PAGE;
import com.icia.hotel.dto.QUESTION;

@Repository
public class ADAO {

	@Autowired
	private SqlSessionTemplate sql;

	public int aMListCount() {
		System.out.println("[2-2]dao");
		return sql.selectOne("Admin.aMlistCount");
	}

	public List<MEMBER> aMlist(PAGE paging) {
		System.out.println("[3]dao :  paging -> " + paging);
		return sql.selectList("Admin.aMlist", paging);
	}

	public MEMBER aMview(String MId) {
		System.out.println("[3]dao :  MId -> " + MId);
		return sql.selectOne("Admin.aMview", MId);
	}

	public int aNwrite(NOTICE notice) {
		System.out.println("[3]dao : notice -> " + notice);
		return sql.insert("Admin.aNwrite", notice);
	}

	public int aQListCount() {
		return sql.selectOne("Admin.aQListCount");
	}

	public List<QUESTION> aQlist(PAGE paging) {
		return sql.selectList("Admin.aQlist", paging);
	}

	public QUESTION aQview(int qNo) {
		return sql.selectOne("Admin.aQview", qNo);
	}
	
	
	List<COMMENT> commentList = new ArrayList<COMMENT>();

	public List<COMMENT> cList(int cBNo) {
		return sql.selectList("Admin.cList", cBNo);
	}

	public int cWrite(COMMENT comment) {
		return sql.insert("Admin.cWriter", comment);
	}

	public int cDelete(COMMENT comment) {
		return sql.delete("Admin.cDelete", comment);
	}
}
