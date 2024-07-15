package home;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server
 */
public class Server {
    private final int NUMBER_OF_THREAD = Runtime.getRuntime().availableProcessors();

    public void go() {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open();) {
            System.out.println("Server started");
            serverChannel.socket().bind(new InetSocketAddress(7213));
            ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
            while (serverChannel.isOpen()) {
                SocketChannel clientChannel = serverChannel.accept();
                System.out.println("Conncetion from server accepted");
                BufferedReader reader = new BufferedReader(Channels.newReader(clientChannel, StandardCharsets.UTF_8));
                executorService.execute(new ReaderJob(reader));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().go();
    }
}
