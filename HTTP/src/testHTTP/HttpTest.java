package testHTTP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//�ٷ�����
public class HttpTest {
	 public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8080);
		while(true) {
			System.out.println("��ʼ����.........");
			Socket accept = socket.accept();
			InputStream inputStream = accept.getInputStream();
			
			byte[] b = new byte[inputStream.available()];
			inputStream.read(b);
			
			String string = new String(b);
			System.out.println(string);
		}
	}
}
