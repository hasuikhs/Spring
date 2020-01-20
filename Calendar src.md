# Calendar src

## 1차시

- calendarServiceImpl

  ```java
  @Service
  public class CalendarServiceImpl implements CalendarService {
  	
  	@SuppressWarnings("deprecation")
  	@Override
  	public Map<String, Object> calendar() {
  		
  		final int WEEK_DAY =7;
  		
  		Map<String, Object> result = new HashMap<String, Object>();
  		
  		Date cal = new Date();
  		cal.setDate(1);
  		
  		Date cloneCal = new Date();
  		cloneCal.setMonth(cal.getMonth());
  		
  		// 말일 구하기
  		int lastDayOfMonth = 28;
  		for(; lastDayOfMonth <= 35; lastDayOfMonth++) {
  			cloneCal.setDate(lastDayOfMonth);
  			if (cloneCal.getMonth() != cal.getMonth()) {
  				lastDayOfMonth--;
  				break;
  			}
  		}
  		
  		DateFormat format = new SimpleDateFormat("yyyy. MM");
  		// 현재 연/월
  		String dateStr = format.format(cal.getTime());
  		result.put("calTitle", dateStr);
  		
  		ArrayList<String> arrCal = new ArrayList<String>();
  		
  		int day = 1;
  		int lengthOfMonth = cal.getDay() + lastDayOfMonth;
  		
  		int normalLength = WEEK_DAY * 5;
  		int maxLength = WEEK_DAY * 6;
  		
  		for (int i = 0; i < maxLength; i++) {
  			if ((i >= cal.getDay()) && (i <lengthOfMonth)) {
  				arrCal.add(Integer.toString(day));
  				day++;
  			} else {
  				arrCal.add(" ");
  			}
  		}
  		
  		List<String> sub = null;
  		String td = "";
  		int weekCnt = 0;
  		if (arrCal.get(35) == " ") {
  			weekCnt = normalLength / WEEK_DAY;
  		} else {
  			weekCnt = maxLength / WEEK_DAY;
  		}
  		
          // Iterator 로 변환 시도
  		for (int i = 0; i < weekCnt; i++) {
  			sub = arrCal.subList(i * WEEK_DAY, (i + 1) * WEEK_DAY);
  			td += "<tr><td>";
  			td += String.join("</td><td>", sub);
  			td += "</td></tr>";
  		}
  		
  		result.put("td", td);
  		
  		return result;
  	}
  
  }
  
  ```
  
- calendarController

  ```java
  package com.test.controller;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  
  import com.test.service.CalendarService;
  
  @Controller
  @RequestMapping("/calendar/*")
  public class CalendarController {
  	
  	@Autowired
  	private CalendarService service;
  	
  	@GetMapping("/get")
  	public void calendar(Model model) {
  		model.addAttribute("calendar", service.calendar());
  	}
  }
  
  ```

- jsp

  ```java
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
  	pageEncoding="UTF-8"%>
  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>calendar</title>
  <!-- style -->
  <style>
  th {
  	width: 100px;
  }
  
  td {
  	vertical-align: top;
  	width: 100px;
  	height: 100px;
  }
  
  th, td {
  	font-weight: bolder;
  }
  
  p {
  	font-size: 30px;
  	font-weight: bolder;
  }
  </style>
  </head>
  <body>
  
  	<center>
  		<div id="calendar-main">
  			
  				<p>${calendar.calTitle}</p>
  				
  				<table border="3">
  					<tr>
  						<th style='color: red;'>일</th>
  						<th>월</th>
  						<th>화</th>
  						<th>수</th>
  						<th>목</th>
  						<th>금</th>
  						<th>토</th>
  					</tr>
  					
  					${calendar.td}
  				
  				</table>
  		</div>
  	</center>
  </body>
  </html>
  ```


## 2차시

- CalendarServiceImpl

  ```java
  @Service
  public class CalendarServiceImpl implements CalendarService {
  
  	@SuppressWarnings({ "deprecation", "null" })
  	@Override
  	public Map<String, Object> calendar() {
  
  		...
  		
          // List 안에 List 생성
  		List<List<String>> weeks = new ArrayList<List<String>>();
  		
  
  		List<String> sub = null;
  		String td = "";
          // 삼항연산자
  		int weekCnt = (arrCal.get(35) == " ") ? normalLength / WEEK_DAY : maxLength / WEEK_DAY;
  		
          // List 안에 List를 선언하면 아래와 같이 list에 sub한 list를 넣을 수 있다.
  		for(int i = 0; i < weekCnt; i++) {
  			weeks.add(arrCal.subList(i * WEEK_DAY, (i + 1) * WEEK_DAY));
  		}
  		
  		System.out.println(weeks);
  		
  		String html= "";
  		for(List<String> week : weeks) {
  			html += "<tr>" + "\n";
  			Iterator<String> it = week.iterator();
  			while (it.hasNext()) {
  				String tgtDate = it.next();
  				html += "<td>" + tgtDate + "</td>" + "\n";
  			}
  			html += "</tr>" + "\n";
  		}
  		System.out.println(html);
  		
  		result.put("td", html);
  
  		return result;
  	}
  
  }
  ```

  