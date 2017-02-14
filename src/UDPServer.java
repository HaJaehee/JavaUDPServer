import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class UDPServer {
	public static void main(String[] args) {
		
		
		try {
			ServerSocket Sock = new ServerSocket(10000);
			while(true){
				Socket ReplySocket = Sock.accept();
				BufferedReader inFromMNS = new BufferedReader(
						new InputStreamReader(ReplySocket.getInputStream(),Charset.forName("UTF-8")));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = inFromMNS.readLine()) != null) {
					response.append(inputLine.trim());
				}
				
				String result = response.toString();
				System.out.println("FROM Client: " + result);
				
				inFromMNS.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}
}
