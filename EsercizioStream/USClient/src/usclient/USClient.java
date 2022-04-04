/*
 * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor.
 */
package usclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author nu
 */
public class USClient {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		String serverAddress = "localhost";
		int serverPort = 1234;
		if (args.length > 0) {
			serverAddress = args[0];
			if (args.length > 1) {
				serverPort = Integer.parseInt(args[1]);
			}
		}

		try (Socket socket = new Socket(serverAddress, serverPort)) {

			// Acquisisce la richiesta dell'utente
			System.out.println("Enter the text to send:");
			Scanner kb = new Scanner(System.in);
			String request = kb.nextLine().trim();

			// Invia la richiesta al server
			PrintStream tx = new PrintStream(socket.getOutputStream(), true);
			tx.println(request);

			// Acquisisce la risposta del server e chiude la comunicazione
			Scanner rx = new Scanner(socket.getInputStream());
			String answer = rx.nextLine();
			socket.close();

			// Mostra la risposta all'utente
			System.out.println(answer);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
