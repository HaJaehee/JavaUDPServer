import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class UDPServer {
	public static void main(String[] args) {	
		
		int port = 10000;
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			while(true){
				Socket sock = server.accept();
				
				System.out.println("Client : " + sock.getInetAddress());
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(sock.getInputStream(),Charset.forName("UTF-8")));
				
				String inputLine = in.readLine();
				System.out.println("Data : " + inputLine);
				
				in.close();
				sock.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}
}
