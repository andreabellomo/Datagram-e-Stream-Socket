/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcclient;

/**
 *
 * @author bellomo
 */
import java.io.IOException;
import java.util.Scanner;
import java.net.*;

public class LCClient {

    public static void main(String[] args) throws Exception {
        String serverAddress = "localhost";
        if (args.length > 0) {
            serverAddress = args[0];
        }
        try {
            System.out.print("Inserisci una frase: ");
            Scanner input = new Scanner(System.in);
            String frase = input.nextLine();
            byte[] data = frase.getBytes();
            DatagramPacket d = new DatagramPacket(data, data.length, InetAddress.getByName(serverAddress), 1234);
            try {

                DatagramSocket socket = new DatagramSocket();
                socket.send(d);
                DatagramPacket r = new DatagramPacket(data, data.length);
                socket.receive(r);
                String s = new String(r.getData());
                System.out.print(s);
            } catch (SocketException ex) {
                System.err.println("Impossibile connettersi al soket !");
            } catch (IOException ex) {
                System.err.println("Impossibile inviare il pacchetto!");
            }
        } catch (UnknownHostException ex) {
            System.err.println("Server hostname errato!");
        }

    }
}
