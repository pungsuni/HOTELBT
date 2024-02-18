package com.icia.hotel.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dao.ADAO;
import com.icia.hotel.dto.COMMENT;
import com.icia.hotel.dto.MEMBER;
import com.icia.hotel.dto.NOTICE;
import com.icia.hotel.dto.PAGE;
import com.icia.hotel.dto.QUESTION;

@Service
public class Aservice {

	@Autowired
	private ADAO dao;

	@Autowired
	private HttpSession session;

	private ModelAndView mav = new ModelAndView();

	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;

	// 회원 목록 조회
	public ModelAndView aMlist(int page) {
		System.out.println("[2-1]service : page -> " + page);

		PAGE paging = new PAGE();

		int listCount = dao.aMListCount();
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

		List<MEMBER> memberList = dao.aMlist(paging);
		System.out.println("[4]service : memberList -> " + memberList);

		mav.addObject("memberList", memberList);
		mav.addObject("paging", paging);
		mav.setViewName("A_Mlist");

		return mav;
	}

	// 회원 상세 보기
	public ModelAndView aMview(String MId, int page) {
		// System.out.println("[2]service : MId -> " + MId);

		MEMBER member = dao.aMview(MId);
		// System.out.println("[4]service : member -> " + member);

		mav.addObject("view", member);
		mav.addObject("page", page);
		mav.setViewName("A_Mview");
		return mav;
	}

	// 공지사항 작성
	public ModelAndView aNwrite(NOTICE notice) {
		System.out.println("[2]service : notice -> " + notice);
		// bFileName을 board객체에 추가하기

		int result = dao.aNwrite(notice);

		if (result > 0) {
			mav.setViewName("redirect:/R_notice");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	// 문의사항 목록 보기
	public ModelAndView aQlist(int page) {
		// BoardService.out.println("[2-1]service : page -> " + page);
		PAGE paging = new PAGE();

		// 전체 게시글 갯수 조회
		int listCount = dao.aQListCount();
		// System.out.println("[2-2]service : listCount -> " + listCount);

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

		/////////////////////////////////////////////////////////////////////////////////////////////

		List<QUESTION> questionList = dao.aQlist(paging);
		// System.out.println("[4]service : boardList -> " + boardList);

		mav.addObject("questionList", questionList);
		mav.addObject("paging", paging);
		mav.setViewName("A_Qlist");

		return mav;
	}

	public ModelAndView aQview(int page, int qNo) {
		QUESTION question = dao.aQview(qNo);

		mav.addObject("view", question);
		mav.addObject("page", page);
		mav.setViewName("A_Qview");

		return mav;
	}

	List<COMMENT> commentList = new ArrayList<COMMENT>();

	public List<COMMENT> cList(int CBNo) {
		List<COMMENT> commentList = dao.cList(CBNo);
		return commentList;
	}

	public List<COMMENT> cWrite(COMMENT comment) {
		List<COMMENT> commentList = null;
		int result = dao.cWrite(comment);

		if (result > 0) {
			commentList = dao.cList(comment.getCBNo());
		} else {
			commentList = null;
		}

		return commentList;
	}

	public List<COMMENT> cDelete(COMMENT comment) {
		List<COMMENT> commentList = null;
		int result = dao.cDelete(comment);

		if (result > 0) {
			commentList = dao.cList(comment.getCBNo());
		} else {
			commentList = null;
		}

		return commentList;
	}

}
