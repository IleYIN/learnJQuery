package upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;


/**
 * Servlet implementation class FileUpload
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文件上传
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			User user = new User();
			for (FileItem fileItem : items) {
				if(fileItem.isFormField()) {
					//普通表单项
					String name = fileItem.getFieldName();
					if("username".equals(name)) {
						user.setUsername(fileItem.getString("utf-8"));
					}
				} else {
					//文件项 文件名
					String name = fileItem.getName();
					//解决不同浏览器的路径问题
					int lastIndexOf = name.lastIndexOf("\\");
					name = name.substring(lastIndexOf+1);
					name = UUID.randomUUID().toString().replaceAll("-", "")+"_"+name;
					//获取路径
					String location = getServletContext().getRealPath("/imgs");
					FileOutputStream outputStream = new FileOutputStream(location+"/"+name);
					IOUtils.copy(fileItem.getInputStream(), outputStream);
					outputStream.close();
					//用户头像是一个当前项目下的虚拟地址
					String virtualPath = "imgs/"+name;
					user.setImgPath(virtualPath);
					//实际地址
					//user.setImgPath(location+"/"+name);
				}
				//保存到数据库
				UserDB.save(user);
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
