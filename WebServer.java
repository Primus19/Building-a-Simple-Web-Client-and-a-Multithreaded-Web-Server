/*Name:- Samruddhi Kapileshwar*/
/*UTA ID:- 1001052575*/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public final class WebServer {

	
	static int portNumber=6789;
	static ServerSocket serverSocket=null;
	static Socket clientSocket=null;
	
	public static void main(String args[]){
		
		
		try {
		      serverSocket = new ServerSocket(portNumber);
		    } catch (IOException e) {
		      System.out.println(e);
		    }
		
		while (true) {
			try {
				clientSocket=serverSocket.accept();	// Listen for a TCP connection request.
				System.out.println("Client Connection accepted");
				
				// Construct an object to process the HTTP request message.
				HttpRequest request = new HttpRequest( clientSocket );
				
				// Create a new thread to process the request.
				Thread thread = new Thread(request);

				// Start the thread.
				thread.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			

		}
		
	}
}
