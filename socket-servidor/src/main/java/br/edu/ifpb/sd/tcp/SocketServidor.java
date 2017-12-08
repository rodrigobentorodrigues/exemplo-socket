package br.edu.ifpb.sd.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rodrigobento
 */
public class SocketServidor {

    public static void main(String[] args) {
        // Criação do socket em determinada porta
        try (ServerSocket socket = new ServerSocket(10999)) {
            System.out.println("Aguardando a mensagem...");
            while (true) {
                // Aguardando uma conexão e mensagem
                Socket cliente = socket.accept();
                Runnable run = () -> {
                    try (InputStream dadosRecebidos = cliente.getInputStream()) {
                        BufferedReader bf = new BufferedReader(new InputStreamReader(dadosRecebidos));
                        bf.lines().forEach(valor -> System.out.println(valor));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                };
                new Thread(run).start();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
