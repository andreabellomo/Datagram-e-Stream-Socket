/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcserver;

/**
 *
 * @author bellommo
 */
import java.io.IOException;
import java.net.*;

public class LCServer {

    public static void main(String[] args) throws SocketException, IOException {

        try (DatagramSocket socket = new DatagramSocket(1234);) {
            System.out.println("Il server è stato inviato");
            boolean go = true;
            do {
                byte[] data = new byte[2048];
                DatagramPacket r = new DatagramPacket(data, data.length);
                socket.receive(r);
                String s = (new String(r.getData()).toLowerCase()).trim();

                if (s.equals("quit!")) {
                    go = false;
                    String mex = "server chiuso";
                    DatagramPacket b = new DatagramPacket(mex.getBytes(), mex.getBytes().length, r.getAddress(), r.getPort());
                    socket.send(b);
                } else {
                    DatagramPacket a = new DatagramPacket(s.getBytes(), s.getBytes().length, r.getAddress(), r.getPort());
                    socket.send(a);
                    System.out.print("Il pacchetto è stato inviato");
                }

            } while (go);
        } catch (SocketException ex) {
            System.out.println(ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println("il pacchetto non puo essere inviato");

        }
    }
}
