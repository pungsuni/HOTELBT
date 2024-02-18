package com.icia.hotel.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dao.MDAO;
import com.icia.hotel.dto.MEMBER;
import com.icia.hotel.dto.QUESTION;

@Service
public class Mservice {

	@Autowired
	private MDAO dao;

	@Autowired
	private HttpSession session;

	@Autowired
	BCryptPasswordEncoder pwEnc;

	private ModelAndView mav = new ModelAndView();

	// 회원가입
	public ModelAndView mJoin(MEMBER member) throws IllegalStateException, IOException {
		System.out.println("[2]service : member -> " + member);

		// 입력받은 패스워드 -> 암호화 -> db로 전달
		member.setMPw(pwEnc.encode(member.getMPw()));

		int result = dao.mJoin(member);
		System.out.println("[4]service : result -> " + result);

		if (result > 0) {
			mav.setViewName("M_Login");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	public ModelAndView mLogin(MEMBER member) {
		System.out.println("[2]service : member -> " + member);

		// [1] 입력한 ID로 암호화 된 pw를 검색
		MEMBER encPw = dao.mView(member.getMId());
		System.out.println("[4]service : encPw -> " + encPw);

		// [2] 입력한 pw와 DB에 저장된 pw와 비교
		if (pwEnc.matches(member.getMPw(), encPw.getMPw())) {
			session.setAttribute("loginId", encPw.getMId());
			mav.setViewName("index");
		} else {
			mav.setViewName("M_Login");
		}

		return mav;
	}

	public String idOverlap(String MId) {
		System.out.println("222222222");
		String idCheck = dao.idOverlap(MId);
		String result = null;

		System.out.println("4444444 " + idCheck);
		if (idCheck == null) {
			result = "OK"; // 중복X
		} else {
			result = "NO"; // 중복O
		}

		return result;
	}

	public ModelAndView qList(String QId) {
		List<QUESTION> questionList = dao.qList(QId);
		mav.addObject("questionList", questionList);
		mav.setViewName("M_Qlist");

		return mav;
	}

	public ModelAndView qView(HashMap<String, String> map) {
		System.out.println("service : "+map);
		QUESTION question = dao.qView(map);
		System.out.println("123");
		System.out.println(question);
		mav.addObject("view", question);
		mav.setViewName("M_Qview");

		return mav;
	}
}
