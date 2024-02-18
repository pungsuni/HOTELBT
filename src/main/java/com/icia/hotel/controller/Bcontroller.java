package com.icia.hotel.controller;

import java.io.IOException;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.hotel.dto.BOOKDTO;
import com.icia.hotel.service.Bservice;

@Controller
public class Bcontroller {

	@Autowired
	private Bservice bsvc;

	private ModelAndView mav = new ModelAndView();

	@Autowired
	HttpSession session;

	// B_bookform : 객실 예약 페이지로 이동
	@RequestMapping(value = "B_bookform", method = RequestMethod.GET)
	public String bBookForm() {
		return "B_Book"; // WEB-INF/views/B_Book.jsp
	}

	// B_book : 객실 예약
	@RequestMapping(value = "B_book", method = RequestMethod.POST)
	public ModelAndView bBook(@ModelAttribute BOOKDTO book) throws IllegalStateException, IOException {
		
		System.out.println("[1]controller : book -> " + book);
		mav = bsvc.bBook(book);
		System.out.println("[5]controller : mav -> " + mav);
		return mav;
	}

	// B_cancle : 객실 예약 취소
	@RequestMapping(value = "B_cancle", method = RequestMethod.GET)
	public ModelAndView bCancle(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam("BNo") int BNo) {
		mav = bsvc.bCancle(page, BNo);
		return mav;
	}

	// B_mlist : 객실 예약 목록
	@RequestMapping(value = "/B_mlist", method = RequestMethod.GET)
	public ModelAndView bMlist(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		if (page <= 0) {
			page = 1;
		}
		// System.out.println("[1]controller : page -> " + page);
		mav = bsvc.bMlist(page);
		// System.out.println("[5]controller : mav -> " + mav);
		return mav;
	}

	// B_mview : 객실 예약 상세보기
	@RequestMapping(value = "B_mview", method = RequestMethod.GET)
	public ModelAndView bMview(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam("BNo") int BNo) {
		mav = bsvc.bMview(page, BNo);
		return mav;
	}
	
	// roomPrice : 가격
	@RequestMapping(value = "roomPrice", method = RequestMethod.GET)
	public @ResponseBody int roomPrice(@RequestParam String SO2) {
		System.out.println("SO2 : " + SO2);
		int price = bsvc.roomPrice(SO2);
		System.out.println("price : " + price);
		return price;
	}
	
	// B_modiForm : 객실 예약 수정하기 (보류)
	
	
	// 날짜 계산
	/*
	 * @RequestMapping(value = "", method = RequestMethod.GET) public void
	 * calDateBetweenAandB() { String date1 = "2016-09-21"; String date2 =
	 * "2016-09-10";
	 * 
	 * try{ // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서
	 * 에러가 발생해서 컴파일을 할 수 없다. SimpleDateFormat format = new
	 * SimpleDateFormat("yyyy-mm-dd"); // date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
	 * Date date1 = format.parse(date1); Date date2 = format.parse(date2);
	 * 
	 * // Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다. // 연산결과 -950400000.
	 * long type 으로 return 된다. long calDate = date1.getTime() - date2.getTime();
	 * 
	 * // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. // 이제
	 * 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다. long calDateDays = calDate / (
	 * 24*60*60*1000);
	 * 
	 * calDateDays = Math.abs(calDateDays);
	 * 
	 * System.out.println("두 날짜의 날짜 차이: "+calDateDays); } catch(ParseException e) {
	 * // 예외 처리 } }
	 */
	
	/*
	 * public Object countTwoDate(Object startDate, Object endDate) {
	 * 
	 * Date start = (Date)startDate; Date end = (Date)endDate; Calendar cal =
	 * Calendar.getInstance(); cal.setTime(start); long time1 =
	 * cal.getTimeInMillis(); cal.setTime(end); long time2 = cal.getTimeInMillis();
	 * long between_days = (time2-time1)/(1000*3600*24); return
	 * Integer.parseInt(String.valueOf(between_days));
	 * 
	 * 
	 * }
	 */
	

}
