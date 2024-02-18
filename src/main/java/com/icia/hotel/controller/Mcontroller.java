package com.icia.hotel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.service.Mservice;
import com.icia.hotel.dto.MEMBER;

@Controller
public class Mcontroller {

	@Autowired
	private Mservice msvc;

	@Autowired
	private HttpSession session;

	@Autowired
	JavaMailSender mailsender;

	private ModelAndView mav = new ModelAndView();

	// 초기 실행화면 : 프로젝트 실행화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	// 초기 실행화면 : 프로젝트 실행화면
	@RequestMapping(value = "/indexForm", method = RequestMethod.GET)
	public String index1() {
		return "index";
	}

	// board : 게시판 페이지로 이동
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board() {
		return "Board";
	}

	// myPage : 마이페이지로 이동
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage() {
		return "MyPage";
	}

	// M_joinForm : 회원가입 페이지로 이동
	@RequestMapping(value = "/M_joinForm", method = RequestMethod.GET)
	public String mJoinForm() {
		return "M_Join";
	}

	// M_loginForm : 로그인 페이지로 이동
	@RequestMapping(value = "/M_loginForm", method = RequestMethod.GET)
	public String mLoginForm() {
		return "M_Login";
	}

	// M_join : 회원가입
	@RequestMapping(value = "/M_join", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {
		System.out.println("[1]controller : member -> " + member);
		mav = msvc.mJoin(member);
		System.out.println("[5]controller : mav -> " + mav);
		return mav;
	}

	// M_login : 로그인
	@RequestMapping(value = "/M_login", method = RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute MEMBER member) {
		// System.out.println("[1]controller : member -> " + member);

		mav = msvc.mLogin(member);
		// System.out.println("[5]controller : mav -> " + mav);

		return mav;
	}

	// M_logout : 로그아웃
	@RequestMapping(value = "/M_logout", method = RequestMethod.GET)
	public String mLogout() {
		session.invalidate();
		return "index";
	}

	// A_idoverlap : 아이디 중복 검사
	@RequestMapping(value = "/A_idoverlap", method = RequestMethod.POST)
	public @ResponseBody String idOverlap(@RequestParam("MId") String MId) {
		String result = msvc.idOverlap(MId);
		return result;
	}

	// A_emailConfirm : 이메일 인증번호 발송
	@RequestMapping(value = "/A_emailConfirm", method = RequestMethod.GET)
	public @ResponseBody String emailConfirm(@RequestParam("MEmail") String MEmail) {
		String emailKey = emailKey(false, 7);

		MimeMessage mail = mailsender.createMimeMessage();

		String message = "<h2>안녕하세요! ICIA HOTEL 입니다.</h2>" + "<br/>인증번호는 " + emailKey + " 입니다.</p>"
				+ "<p>인증번호를 인증번호 입력란에 입력해주세요</p>" + "혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다.";

		try {
			mail.setSubject("[본인인증] ICIA HOTEL 가입 인증메일입니다.", "utf-8");
			mail.setText(message, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(MEmail));
			mailsender.send(mail);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return emailKey;
	}

	// 난수를 이용한 키 생성
	private boolean lowerCheck;
	private int size;

	public String emailKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;

		return init();
	}

	// 난수를 만드는 메소드
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();

		int num = 0;

		do {
			num = ran.nextInt() + 48;

			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);

		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}

		return sb.toString();
	}

	// M_qlist : 나의 문의목록보기
	@RequestMapping(value = "M_qlist", method = RequestMethod.GET)
	public ModelAndView qList(@RequestParam("QId") String QId) {

		mav = msvc.qList(QId);
		return mav;
	}

	// M_qview
	@RequestMapping(value = "M_qview", method = RequestMethod.GET)
	public ModelAndView qView(@RequestParam("QId") String QId, @RequestParam("QTitle") String QTitle) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Id", QId);
		map.put("Title", QTitle);
		mav = msvc.qView(map);
		return mav;
	}
}
