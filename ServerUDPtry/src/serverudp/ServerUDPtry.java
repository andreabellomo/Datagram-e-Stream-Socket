/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverudp;

import java.net.*;
import java.io.*;

/**
 *
 * @author pc1-casa
 */
public class ServerUDPtry {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(7777);
			while (true) {
				byte[] data = new byte[1024];
				DatagramPacket r = new DatagramPacket(data, data.length);
				socket.receive(r);
				String messaggio = new String(r.getData());
				System.out.println("la stringa ricevuta è:" + messaggio);
				messaggio = messaggio.toLowerCase();
				data = messaggio.getBytes();
				DatagramPacket s = new DatagramPacket (data, data.length, r.getAddress(), r.getPort());
				socket.send(s);
				System.out.println("Il messaggio è stato inviato");
			}
		} catch (IOException e) {
			System.out.println("Errore: " + e.getMessage());
		}
	}
}
