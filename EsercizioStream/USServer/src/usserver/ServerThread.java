/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class ServerThread extends Thread {

	private final Socket socket;

	ServerThread(Socket s) {
		socket = s;
		System.out.println("Client connected: " + socket);
	}

	@Override
	public void run() {
		try (Scanner rx = new Scanner(socket.getInputStream())) {
			String request = rx.nextLine().trim();
			String answer = request.toUpperCase();
			PrintStream tx = new PrintStream(socket.getOutputStream(), true);
			tx.println(answer);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
