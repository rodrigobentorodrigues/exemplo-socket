package br.edu.ifpb.sd.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author rodrigobento
 */
public class SocketCliente {
    
    public static void main(String[] args) {
        
        try {
            try (Socket cliente = new Socket("host-socket", 10999)) {
                String mensagem = "Teste";
                OutputStream saida = cliente.getOutputStream();
                saida.write(mensagem.getBytes());
                System.out.println("Mensagem enviada");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
