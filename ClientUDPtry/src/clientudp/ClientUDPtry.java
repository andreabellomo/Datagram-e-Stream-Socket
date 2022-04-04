/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientudp;

import java.util.Scanner;
import java.net.*;
import java.io.*;

/**
 *
 * @author pc1-casa
 */
public class ClientUDPtry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
		 String ServerAddress ="localhost";
		 int ServerPort =1024;
		 if (args.length>0) {
			 String serverAddress = args [0];
			 if (args.length>1){
			 ServerPort=Integer.parseInt(args [1]);
			 } 
		 } 
			 try {
            while (true) {
                System.out.print("inserisci una frase:");
                Scanner input = new Scanner(System.in);
                String messaggio = input.nextLine();
                byte[] data = messaggio.getBytes();
                DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("ServerAddress"), 7777);

                DatagramSocket socket = new DatagramSocket();
                socket.send(dp);

            }
        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        // TODO code application logic here
    }

}
