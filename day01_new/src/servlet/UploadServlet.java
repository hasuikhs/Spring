package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload.do")
@MultipartConfig(location = "c:/upload",maxFileSize=1024*1024*5) // 5Mb
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); // 한글깨짐 해결 2
		
		PrintWriter out = response.getWriter();
		
		String path = "c:/upload";
		File isDir = new File(path);
		if(!isDir.isDirectory()) {
			isDir.mkdir();
		}
		
		Collection<Part> parts = request.getParts();
		
		for(Part part :parts) {
			if(part.getContentType() != null) {
				String filename = part.getSubmittedFileName();
				if(filename != null) {
					part.write(filename);
					out.print("<br>업로드한 파일 이름" + filename);
					out.print("<br>업로드한 파일 size" + part.getSize());
				}
			}else {
				out.print(part.getName());
			}
		}
	}

}
