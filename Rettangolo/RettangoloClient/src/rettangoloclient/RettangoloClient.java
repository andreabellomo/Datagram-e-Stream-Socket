/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rettangoloclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user2
 */
public class RettangoloClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try  {
            // TODO code application logic here
            
            Scanner input = new Scanner(System.in);
            System.out.print("Inserisci base : ");
            String dati = input.nextLine();
            System.out.print("Inserisci altezza : ");
            dati = dati + " " + input.nextLine();
            byte[] data = dati.getBytes();
            DatagramPacket d = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 1234);
            try {
                
                DatagramSocket socket = new DatagramSocket();
                socket.send(d);
                DatagramPacket r = new DatagramPacket(data, data.length);
                socket.receive(r);
                System.out.println("ricevuto ");
                String s = new String(r.getData());
                System.out.print("La risposta è: " + s);
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
