package web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ReportController {

	@RequestMapping(value = "/report.do", method = RequestMethod.GET)
	public String form() {
		return "reportForm";
	}
	
	@RequestMapping(value = "/report.do", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file , 
			                 HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String path = request.getRealPath("/upload/");
		
		System.out.println(path);
		if(!file.isEmpty()) {
			File f = new File(path+fileName); /*java.io.File -import*/ /*경로에 이이름으로*/
			
			boolean fileexists = f.exists(); // 파일 존재 유무 검사
			
			if(fileexists) { // 파일이 있다면
				System.out.println("중복된 파일명 존재");
				return "reportResult";
			} else { // 파일이 없다면
				/*파일 복사*/
				try {
					file.transferTo(f);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			 
		}
		
		request.setAttribute("imgname", fileName);
		return "reportResult";
	}
}







