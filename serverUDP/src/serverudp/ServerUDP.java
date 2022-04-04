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
public class ServerUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7777);
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket r = new DatagramPacket(data, data.length);
            socket.receive(r);
            String messaggio= (new String(r.getData()).trim());
            System.out.println("la risposta è:" + messaggio);
            // TODO code application logic here
        }
    }
}
