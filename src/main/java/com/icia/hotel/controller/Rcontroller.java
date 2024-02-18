package com.icia.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.service.Rservice;

@Controller
public class Rcontroller {

	@Autowired
	private Rservice rsvc;
	private ModelAndView mav = new ModelAndView();

	// R_list : 객실 목록보기
	@RequestMapping(value = "R_list", method = RequestMethod.GET)
	public ModelAndView rList() {

		mav = rsvc.rList();
		return mav;
	}

	// R_view : 객실 상세보기
	@RequestMapping(value = "/R_view", method = RequestMethod.GET)
	public ModelAndView rView(@RequestParam("RFileName") String RFileName) {

		mav = rsvc.rView(RFileName);
		return mav;
	}

	// R_around : 주변 시설보기
	@RequestMapping(value = "R_around", method = RequestMethod.GET)
	public ModelAndView rAround() {
		mav = rsvc.rAround();
		return mav;
	}

	// R_notice : 객실 공지사항 목록
	@RequestMapping(value = "/R_notice", method = RequestMethod.GET)
	public ModelAndView rNotice(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		if (page <= 0) {
			page = 1;
		}

		mav = rsvc.rNotice(page);

		return mav;
	}

	// R_nview : 공지 사항 조회
	@RequestMapping(value = "/R_nview", method = RequestMethod.GET)
	public ModelAndView rNview(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam("NNo") int NNo) {
		mav = rsvc.rNview(page, NNo);
		return mav;
	}
}
