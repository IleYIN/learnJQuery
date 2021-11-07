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
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//要下载的资源的虚拟路径 相对路径
		String res = request.getParameter("res");
		//1、找到要下载的资源的真实地址
		System.out.println("资源虚拟路径："+res);
		String realPath = getServletContext().getRealPath("/"+res);
		System.out.println("资源真实路径："+realPath);
		
		//2、设置content-type
		String mimeType = getServletContext().getMimeType(res);
		response.setContentType(mimeType);
		//3、设置content-Disposition
		int indexOf = res.lastIndexOf("/");
		String filename = res.substring(indexOf+1);
		filename = filename.substring(filename.lastIndexOf("_")+1);
		System.out.println("资源名："+filename);
		//解决中文乱码
		String string = new String(filename.getBytes("utf-8"),"iso8859-1");
		response.setHeader("Content-Disposition", "attachment;filename="+string);
		
		//4、将文件的流写出去
		FileInputStream is = new FileInputStream(realPath);
		ServletOutputStream os = response.getOutputStream();
		IOUtils.copy(is,os);
		is.close(); os.close();
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
