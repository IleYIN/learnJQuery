package upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String headerImg = request.getParameter("headerImg");
//		System.out.println("用户名："+username);
//		System.out.println("头像："+headerImg);
		
		//获取整个请求的流（表单的所有部件）
		//ServletInputStream stream = request.getInputStream();
		//System.out.println("流："+IOUtils.toString(stream));
		
		//1、创建一个工厂实例
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2、创建一个专门用来处理Servlet文件上传的对象
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		//3、解析文件上传请求
		try {
			//返回的list封装了FileItem
			//FileItem就是封装了请求的流中的每个部件，每个部件就对应了一个FileItem
			List<FileItem> list = fileUpload.parseRequest(request);
//			System.out.println(list.size());
			for(FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					//true代表是简单的key-value
					//getFieldName是获取的表单项的name值
					String fieldName = fileItem.getFieldName();
					//getName是获取的文件名(获取不到）
					String name = fileItem.getName();
					System.out.println("普通表单项：filedName-"+fieldName+", name-"+name);
				} else {
					//false代表是一个文件
					//getFieldName是获取的表单项的name值
					String fieldName = fileItem.getFieldName();
					//getName是获取的文件名
					//w3c标准的浏览器获取的是文件名
					//部分ie版本获取的是文件路径，需要处理
					String name = fileItem.getName();
					System.out.println("name:"+name);
					int lastIndexOf = name.lastIndexOf("\\");
					name = name.substring(lastIndexOf+1);
					System.out.println("name处理后:"+name);
					System.out.println("文件表单项：filedName-"+fieldName+", name-"+name);
					//如果是文件项，保存流
					InputStream inputStream = fileItem.getInputStream();
					//System.out.println(IOUtils.toString(inputStream));
					//保存流
//					FileOutputStream outputStream = new FileOutputStream("D:/informatique/img"+"/upload_"+name);
//					//将输入流的内容写进输出流里
//					IOUtils.copy(inputStream, outputStream);
//					//关闭输出流
//					outputStream.close();
					
					//将文件写到项目里。动态获取文件夹路径
					String realPath = getServletContext().getRealPath("/uploads");
					System.out.println("realPath:"+realPath);
					//文件名前缀
					String prefix = UUID.randomUUID().toString().replaceAll("-", "");
					name = prefix + "_" + name;
					FileOutputStream outputStream = new FileOutputStream(realPath+"/upload_"+name);
					//将输入流的内容写进输出流里
					IOUtils.copy(inputStream, outputStream);
//					//关闭输出流
					outputStream.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
