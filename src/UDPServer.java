import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPServer {
	static byte[] buffer = new byte[65507];

	public static void main(String[] args){
		int port = 10000;

		try{
			DatagramSocket ds = new DatagramSocket(port);
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			while(true){
				try{
					ds.receive(dp);
					String s = new String(dp.getData(), 0, 0, dp.getLength());
					System.out.println("client: "+dp.getAddress()+" at port: "+dp.getPort()+" says: "+s);
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}catch(SocketException se){
			se.printStackTrace();
		}
	}
}

