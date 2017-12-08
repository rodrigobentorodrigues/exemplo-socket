package br.edu.ifpb.sd.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigobento
 */
public class SocketCliente {

    public static void main(String[] args) {
        // Criando o socket e informando o endereço para quem vai a mensagem
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress destino = InetAddress.getByName("host-socket");
            
            // Criando a mensagem e a enviando
            byte[] mensagem = "Teste".getBytes();
            DatagramPacket pacote = new DatagramPacket(mensagem, mensagem.length,
                    destino, 1234);
            socket.send(pacote);
            System.out.println("Enviada");
            
            // Criando o pacote e aguardando a resposta
            byte[] msg = new byte[100];
            DatagramPacket pct = new DatagramPacket(msg, msg.length);
            socket.receive(pct);
            
            String msgRecebida = new String(pct.getData(), 0, pct.getLength());
            System.out.println("Mensagem retornada: " + msgRecebida);
            
        } catch (SocketException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
