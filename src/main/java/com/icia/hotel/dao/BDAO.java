package com.icia.hotel.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.hotel.dto.BOOKDTO;
import com.icia.hotel.dto.PAGE;

@Repository
public class BDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public int bBook(BOOKDTO book) {
		System.out.println("[3]dao : book -> " + book);
		return sql.insert("BOOKDTO.bBook", book);
	}

	public int bCancle(int BNo) {
		return sql.delete("BOOKDTO.bCancle", BNo);
	}
	
	public List<BOOKDTO> bMlist(PAGE paging) {
		// System.out.println("[3-1]dao : paging -> " + paging);
		return sql.selectList("BOOKDTO.bMlist", paging);
	}

	public int bMlistCount() {
		return sql.selectOne("BOOKDTO.bMlistCount");
	}

	public BOOKDTO bMview(int BNo) {
		return sql.selectOne("BOOKDTO.bMview", BNo);
	}

	public int roomPrice(String SO2) {
		System.out.println("SO2 : " + SO2);
		int price = sql.selectOne("BOOKDTO.roomPrice", SO2);
		System.out.println("price : " + price);
		
		return price;
	}

	
}
