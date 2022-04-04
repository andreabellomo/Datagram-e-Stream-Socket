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
public class ClientUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        while (true) {            
            System.out.print("inserisci una frase:");
            Scanner input = new Scanner(System.in);
            String messaggio = input.nextLine();
            byte[] data = messaggio.getBytes();
            DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 7777);
                        
            DatagramSocket socket = new DatagramSocket();
            socket.send(dp);
            
            
        }
        // TODO code application logic here
    }

}
