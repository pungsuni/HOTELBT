package com.icia.hotel.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dao.BDAO;
import com.icia.hotel.dto.BOOKDTO;
import com.icia.hotel.dto.PAGE;

@Service
public class Bservice {

	@Autowired
	private BDAO dao;

	@Autowired
	private HttpSession session;

	private ModelAndView mav = new ModelAndView();

	public ModelAndView bBook(BOOKDTO book) {
		System.out.println("[2]service : book -> " + book);
		int result = dao.bBook(book);
		
		if(result>0) {
			mav.setViewName("redirect:/B_mlist");
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

	public ModelAndView bCancle(int page, int BNo) {
			int result = dao.bCancle(BNo);
				
			if(result>0) {
				mav.setViewName("redirect:/B_mlist");
			} else {
				mav.setViewName("index");
			}
		return mav;
	}

	// 메소드 밖, Bservice클래스 안에서 지정
	private static final int PAGE_LIMIT = 5;	// 한 페이지에 보여줄 글 갯수
	private static final int BLOCK_LIMIT = 5;	// 한 페이지에 보여줄 페이지 번호 갯수
	
	public ModelAndView bMlist(int page) {
		PAGE paging = new PAGE();
		
		// 전체 게시글 갯수 조회
		int listCount = dao.bMlistCount();
		// System.out.println("[2-2]service : listCount -> " + listCount);
		
		int startRow = (page - 1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		
		int maxPage = (int) (Math.ceil((double)listCount / PAGE_LIMIT ));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) -1 ) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		paging.setPage(page);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		List<BOOKDTO> bookList = dao.bMlist(paging);
		System.out.println("[4]service : bookList -> " + bookList);

		mav.addObject("bookList", bookList);
		mav.addObject("paging", paging);
		mav.setViewName("B_Mlist");
		
		return mav;
	}

	public ModelAndView bMview(int page, int BNo) {
		BOOKDTO book = dao.bMview(BNo);
		
		mav.addObject("view", book);
		mav.addObject("page", page);
		mav.setViewName("B_Mview");
		
		return mav;
	}

	public int roomPrice(String SO2) {
		System.out.println("SO2 : " + SO2);
		int price = dao.roomPrice(SO2);
		System.out.println("price : " + price);
		return price;
	}

	
}
