package br.edu.ifpb.sd.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigobento
 */
public class SocketServidor {

    public static void main(String[] args) {
        // Cria o socket utilizando o protocolo UDP
        try (DatagramSocket socket = new DatagramSocket(1234)) {
            System.out.println("Servidor ativo");
//            while (true) {
                // Informa o tamanho max de bytes que o socket poderá receber
                byte[] dados = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(dados, dados.length);

                // Aguarda o recebimento da mensagem
                socket.receive(pacote);

                // Recebendo e convertendo a mensagem recebida
                String mensagem = new String(pacote.getData(), 0, pacote.getLength());
                System.out.println("Mensagem recebida: " + mensagem);
                
                // Enviando uma resposta
                InetAddress endereco = pacote.getAddress();
                byte[] resposta = "Resposta".getBytes();
                DatagramPacket pct = new DatagramPacket(resposta, resposta.length, 
                        endereco, pacote.getPort());
                socket.send(pct);
                System.out.println("Mensagem respondida");
                System.out.println("Endereco: " + pct.getAddress());
//            }
        } catch (SocketException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
