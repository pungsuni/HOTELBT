package com.icia.hotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dto.COMMENT;
import com.icia.hotel.dto.NOTICE;
import com.icia.hotel.service.Aservice;

@Controller
public class Acontroller {

	@Autowired
	private Aservice asvc;

	@Autowired
	JavaMailSender mailsender;

	private ModelAndView mav = new ModelAndView();
	
	
	// A_mlist : 회원 목록 조회
	@RequestMapping(value = "/A_mlist", method = RequestMethod.GET)
	public ModelAndView aMlist(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		if (page <= 0) {
			page = 1;
		}
		// System.out.println("[1]controller : page -> " + page);
		mav = asvc.aMlist(page);
		// System.out.println("[5]controller : mav -> " + mav);
		return mav;
	}
	
	// /A_mview : 회원상세보기
	@RequestMapping(value = "/A_mview", method = RequestMethod.GET)
	public ModelAndView aMview(@RequestParam("MId") String MId,
		@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
	// System.out.println("[1]controller : MId -> " + MId);
		mav = asvc.aMview(MId, page);
		// System.out.println("[5]controller : mav -> " + mav);
		return mav;
	}

	// A_nwriteForm : 공지사항 작성 페이지 이동
	@RequestMapping(value = "/A_nwriteForm", method = RequestMethod.GET)
	public String AnwriteForm() {
		return "A_Nwrite"; // WEB-INF/views/B_Write.jsp
	}

	// A_nwrite : 공지사항 작성
	@RequestMapping(value = "/A_nwrite", method = RequestMethod.POST)
	public ModelAndView aNwrite(@ModelAttribute NOTICE notice) throws IllegalStateException, IOException {
		System.out.println("[1]controller : notice -> " + notice);

		mav = asvc.aNwrite(notice);
		System.out.println("[5]controller : mav -> " + mav);

		return mav;
	}
	
	// A_qlist : 문의 목록 보기 
	@RequestMapping(value = "/A_qlist", method = RequestMethod.GET)
	public ModelAndView aQlist(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		
		// 오류방지용
		if (page <= 0) {
			page = 1;
		}

		// System.out.println("[1]controll : page -> " + page);

		mav = asvc.aQlist(page);
		
		// System.out.println("[5]controll : mav -> " + mav);
		return mav;
	}

	// A_qview : 문의 내역 조회
	@RequestMapping(value = "/A_qview", method = RequestMethod.GET)
	public ModelAndView aQview(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam("QNo") int QNo) {
		mav = asvc.aQview(page, QNo);
		return mav;
	}
	
	List<COMMENT> commentList = new ArrayList<COMMENT>();

	// C_list : 댓글 리스트 불러오기
	@RequestMapping(value = "C_list", method = RequestMethod.POST)
	public @ResponseBody List<COMMENT> cList(@RequestParam("CBNo") int CBNo) {

		List<COMMENT> commentList = asvc.cList(CBNo);
		return commentList;

	}

	// C_write : 댓글 입력
	@RequestMapping(value = "C_write", method = RequestMethod.POST)
	public @ResponseBody List<COMMENT> cWrite(@ModelAttribute COMMENT comment) {
		List<COMMENT> commentList = asvc.cWrite(comment);
		return commentList;
	}

	// C_delete : 댓글 삭제
	@RequestMapping(value = "C_delete", method = RequestMethod.GET)
	public @ResponseBody List<COMMENT> cDelete(@ModelAttribute COMMENT comment) {
		List<COMMENT> commentList = asvc.cDelete(comment);
		return commentList;
	}
	
	
}
