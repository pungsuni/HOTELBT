package com.icia.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dao.RDAO;
import com.icia.hotel.dto.AROUND;
import com.icia.hotel.dto.NOTICE;
import com.icia.hotel.dto.PAGE;
import com.icia.hotel.dto.ROOM;

@Service
public class Rservice {

	@Autowired
	private RDAO dao;
	private ModelAndView mav = new ModelAndView();

	// 객실목록 보기
	public ModelAndView rList() {

		List<ROOM> roomList = dao.rList();

		System.out.println(roomList);
		mav.addObject("roomList", roomList);
		mav.setViewName("R_List");

		return mav;
	}

	// 객실 상세보기
	public ModelAndView rView(String RFileName) {
		ROOM room = dao.rView(RFileName);

		mav.addObject("view", room);
		mav.setViewName("R_View");
		return mav;
	}

	// 주변시설 보기
	public ModelAndView rAround() {
		List<AROUND> aroundList = dao.rAround();

		System.out.println("aroundList");
		mav.addObject("aroundList", aroundList);
		mav.setViewName("R_Around");

		return mav;
	}
	
	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;

	public ModelAndView rNotice(int page) {
		System.out.println("[2-1]service : page -> " + page);

		PAGE paging = new PAGE();

		int listCount = dao.rNListCount();
		System.out.println("[2-3]service : listCount -> " + listCount);

		int startRow = (page - 1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;

		int maxPage = (int) (Math.ceil((double) listCount / PAGE_LIMIT));
		int startPage = (((int) (Math.ceil((double) page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		paging.setPage(page);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);

		////////////////////////////////////////////////////////////////////////////

		List<NOTICE> noticeList = dao.rNotice(paging);
		System.out.println("[4]service : memberList -> " + noticeList);

		mav.addObject("noticeList", noticeList);
		mav.addObject("paging", paging);
		mav.setViewName("R_Notice");

		return mav;
	}

	
	public ModelAndView rNview(int page, int NNo) {
		NOTICE notice = dao.rNview(NNo);

		mav.addObject("view", notice);
		mav.addObject("page", page);
		mav.setViewName("R_Nview");

		return mav;
	}

}
