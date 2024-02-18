package com.icia.hotel.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dto.REVIEW;
import com.icia.hotel.service.RVservice;

@Controller
public class RVcontroller {

	@Autowired
	private RVservice rvsvc;

	@Autowired
	private HttpSession session;

	@Autowired
	JavaMailSender mailsender;

	private ModelAndView mav = new ModelAndView();

	// RV_list : 리뷰 목록 보기
	@RequestMapping(value = "/RV_list", method = RequestMethod.GET)
	public ModelAndView rvList(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		// 오류방지용
		if (page <= 0) {
			page = 1;
		}

		mav = rvsvc.rvList(page);

		return mav;
	}

	// RV_view : 후기상세보기
	@RequestMapping(value = "/RV_view", method = RequestMethod.GET)
	public ModelAndView rvView(@RequestParam("RENo") int RENo,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		mav = rvsvc.rvView(RENo, page);
		return mav;
	}

	// RV_writeForm : 리뷰 작성 페이지 이동
	@RequestMapping(value = "/RV_writeForm", method = RequestMethod.GET)
	public ModelAndView rvWriteForm() {
		mav.setViewName("RV_Write");
		System.out.println(mav);
		return mav;
	}

	// RV_write : 리뷰 작성
	@RequestMapping(value = "/RV_write", method = RequestMethod.POST)
	public ModelAndView rvWrite(@ModelAttribute REVIEW review) throws IllegalStateException, IOException {

		mav = rvsvc.rvWrite(review);

		return mav;
	}

}
