package com.icia.hotel.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dto.QUESTION;
import com.icia.hotel.service.Qservice;


// board에서 문의하기 페이지 주소 고치기
@Controller
public class Qcontroller {
	
	@Autowired
	private Qservice qsvc;

	@Autowired
	private HttpSession session;
	
	@Autowired
	JavaMailSender mailsender;
	
	private ModelAndView mav = new ModelAndView();
	
	// Q_writeForm : 문의 작성 페이지 이동
		@RequestMapping(value = "/Q_writeForm", method = RequestMethod.GET)
		public String qWriteForm() {
			return "Q_Write";		
		}
	
	
	// Q_write : 문의 작성
		@RequestMapping(value = "/Q_write", method = RequestMethod.POST)
		public ModelAndView qWrite(@ModelAttribute QUESTION question) throws IllegalStateException, IOException {
		
			mav = qsvc.qWrite(question);
				
			return mav;
		}

	

}
