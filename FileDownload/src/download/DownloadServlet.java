package download;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.URLEncoder;
import org.apache.commons.io.IOUtils;


/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 告诉浏览器不要打开资源而是下载资源
		// 把要下载的资源的流传给浏览器
		// 1、设置响应的文件类型，文件是什么类型就设置什么类型
//		String mimeType = getServletContext().getMimeType("/earth.png");
		String mimeType = getServletContext().getMimeType("/地球.png");
		System.out.println("要下载的文件类型："+mimeType);
		response.setContentType(mimeType);
		
		// 解决中文文件名的问题
		// URLEncoder
		//String encode = new URLEncoder().encode("地球.png", "utf-8");
		// 或者
		String encode = new String("地球.png".getBytes("utf-8"),"iso8859-1");
		
		// 2、设置资源的处理方式 响应头
		//response.setHeader("Content-Disposition", "attachment;filename=earth.png");
		response.setHeader("Content-Disposition", "attachment;filename="+encode);
	
		// 3、可选的设置，设置文件大小 response.setContentLength(len);
		
//		String realPath = getServletContext().getRealPath("/earth.png");
		String realPath = getServletContext().getRealPath("/地球.png");
		FileInputStream inputStream = new FileInputStream(realPath);
		
		//浏览器输出流 输出字节流 getOutputStream() 输出字符流 getWriter()
		ServletOutputStream outputStream = response.getOutputStream();
		IOUtils.copy(inputStream, outputStream);
		//copy方法有关流，使用后，inputStream为空
		
		//System.out.println("打印input"+IOUtils.toString(inputStream, "utf-8"));
		inputStream.close();
		outputStream.close();
	}

}
