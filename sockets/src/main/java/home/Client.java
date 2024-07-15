package home;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Client
 */
public class Client {
    JTextField outgoing;
    PrintWriter writer;

    public void go() throws IOException {

        setUpNetworking();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessgae());

        JPanel mainPanel = new JPanel();
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        JFrame frame = new JFrame("Simple Chat Client");
        frame.getContentPane().add(mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void sendMessgae() {
        System.out.println(outgoing.getText());
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    public void setUpNetworking() throws IOException {
        InetSocketAddress serverAddress = new InetSocketAddress(7213);
        try {
            SocketChannel soChannel = SocketChannel.open(serverAddress);
            writer = new PrintWriter(Channels.newWriter(soChannel, StandardCharsets.UTF_8));
            System.out.println("connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        new Client().go();
    }

}
