package com.icia.hotel.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dao.RVDAO;
import com.icia.hotel.dto.PAGE;
import com.icia.hotel.dto.REVIEW;

@Service
public class RVservice {

	@Autowired
	private RVDAO dao;

	@Autowired
	private HttpSession session;

	private ModelAndView mav = new ModelAndView();

	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;

	// 리뷰 목록
	public ModelAndView rvList(int page) {

		PAGE paging = new PAGE();

		// 리뷰 갯수 조회
		int listCount = dao.rvListCount();

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

		List<REVIEW> reviewList = dao.rvList(paging);

		mav.addObject("reviewList", reviewList);
		mav.addObject("paging", paging);
		mav.setViewName("RV_List");

		return mav;
	}

	// 후기 상세 보기
	public ModelAndView rvView(int RENo, int page) {

		REVIEW review = dao.rvView(RENo);

		mav.addObject("view", review);
		mav.addObject("page", page);
		mav.setViewName("RV_View");

		return mav;
	}

	// 리뷰 작성
	public ModelAndView rvWrite(REVIEW review) throws IllegalStateException, IOException {

		int result = 0;

		MultipartFile REFile = review.getREFile();
		String REFileName = REFile.getOriginalFilename();

		String savePath = "H:/spring/HOTELBT/src/main/webapp/resources/file/" + REFileName;

		// 파일이 선택됐다면
		if (!REFile.isEmpty()) {
			review.setREFileName(REFileName);
			REFile.transferTo(new File(savePath));
			result = dao.rvWrite(review);
		}

		if (result > 0) {
			mav.setViewName("redirect:/RV_list");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

}
