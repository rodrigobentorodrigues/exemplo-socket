package br.edu.ifpb.sd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorMulticast {

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.out.println("Servidor");
        int porta = 8888;
        try {
            MulticastSocket mSocket = new MulticastSocket(porta);
            InetAddress enderecoGrupo = InetAddress.getByName("224.0.0.3");
            mSocket.joinGroup(enderecoGrupo);
            byte[] dados = new byte[100];
            DatagramPacket pacote = new DatagramPacket(dados, dados.length);
            while (true) {
                mSocket.receive(pacote);
                String mensagem = new String(pacote.getData(), 0, pacote.getLength());
                System.out.println("Mensagem recebida: " + mensagem);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
