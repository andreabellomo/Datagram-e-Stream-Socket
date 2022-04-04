/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rettangoloserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author user2
 */
public class RettangoloServer {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)  {

        // TODO code application logic here
        try (DatagramSocket socket = new DatagramSocket(1234);)
        {
        System.out.println("Il server è stato avviato!");
        boolean go = false;
        do {
            byte[] data = new byte[1024];
            DatagramPacket r = new DatagramPacket(data, data.length);
            socket.receive(r);
             System.out.println("Il pacchetto è stato ricevuto!");
            String s = new String(r.getData()).trim();
            if (s.equals("quit!")) {
                go = false;
            } else {
                String[] parts = s.split(" ");
                if (parts.length > 1) {
                   try{
                    double b = Double.parseDouble(parts[0]);
                    double h = Double.parseDouble(parts[1]);
                    double risultato = b * h;
                    String ris = Double.toString(risultato);
                    DatagramPacket send = new DatagramPacket(ris.getBytes(), ris.getBytes().length, r.getAddress(), r.getPort());
                    socket.send(send);
                    System.out.println("Il pacchetto è stato inviato!");
                   }catch (IOException | NumberFormatException ex){
                   System.out.println(ex.getLocalizedMessage());
                   
                   }
                } else {
                    System.out.println(" errore solo 1 numero inserito ");
                }

            }
        } while (go == true);
         }catch (SocketException ex ) {
          System.out.println(ex.getLocalizedMessage());
          
      }catch (IOException ex ){
       System.out.println("il pacchetto non puo essere inviato");
      
    }

    }
}
