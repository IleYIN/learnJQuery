package testHTTP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//假客户端---视频11 不管用 https://www.bilibili.com/video/BV1q4411u7mM?p=76
public class HttpClient {
	 public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("localhost", 8080);
			/* 创建HTTP请求 */
			//请求首行
			StringBuffer sb = new StringBuffer("GET "+"/FirstWEB/index.html "
					+"HTTP/1.1\r\n");
			
			//模拟HTTP请求头
			sb.append("Host: localhost:8080\r\n");
			sb.append("Connection: keep-alive\r\n");
			sb.append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n");
			sb.append("Accept-Language: zh,en-US;q=0.9,en;q=0.8,fr;q=0.7,zh-TW;q=0.6,zh-CN;q=0.5\r\n");
			sb.append("Accept-Encoding: gzip, deflate, br\r\n");
			sb.append("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36\r\n");
			
			//发送请求
			OutputStream outputStream = ((Socket) socket).getOutputStream();
			outputStream.write(sb.toString().getBytes());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//接收响应
			InputStream inputStream = socket.getInputStream();
			int size = inputStream.available();
			byte[] buffer = new byte[size];
			inputStream.read(buffer);
			String response = new String(buffer);
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
}
