package com.icia.hotel.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dao.QDAO;
import com.icia.hotel.dao.RVDAO;
import com.icia.hotel.dto.QUESTION;

@Service
public class Qservice {
	
	@Autowired
	private QDAO dao;

	@Autowired
	private HttpSession session;

	private ModelAndView mav = new ModelAndView();

	public ModelAndView qWrite(QUESTION question) {
	
		
		
		int result = dao.qWrite(question);
		
		if(result>0) {
			mav.setViewName("redirect:/indexForm");
		} else {
			mav.setViewName("indexForm");
		}
		
		return mav;
	}

}
