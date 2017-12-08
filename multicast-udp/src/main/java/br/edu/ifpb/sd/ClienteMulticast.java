package br.edu.ifpb.sd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteMulticast {

    public static void main(String[] args) throws IOException {

        try (DatagramSocket socket = new DatagramSocket()) {
            int porta = 8888;
            InetAddress grupo = InetAddress.getByName("224.0.0.3");
            byte[] msg = "Oi".getBytes();
            DatagramPacket pacote = new DatagramPacket(msg, msg.length, grupo, porta);
            socket.send(pacote);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }

}
