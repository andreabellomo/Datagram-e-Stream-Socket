/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author nu
 */
public class USServer {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		int serverPort = 1234;
		if (args.length > 0) {
			serverPort = Integer.parseInt(args[1]);

		}

		try (ServerSocket socket = new ServerSocket(serverPort)) {
			while (true) {
				ServerThread thread = new ServerThread(socket.accept());
				thread.start();
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
