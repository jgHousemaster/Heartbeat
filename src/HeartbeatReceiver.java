import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HeartbeatReceiver {
    public static void main(String[] args) throws IOException, InterruptedException {
        // The monitor using the heartbeat tactic, start this program first.
        int checkingInterval = 1;
        int expireTime = 5;
        long lastUpdatedTime;
        long timer;

        // Network setup
        ServerSocket server = new ServerSocket(33075);
        System.out.println("Waiting for clients...");
        Socket client = server.accept();
        System.out.println("Client connected!");
        InputStream in = client.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inr);
        String line;

        // Update time
        lastUpdatedTime = System.currentTimeMillis();

        // Heartbeat Monitor
        while(true){

            timer = System.currentTimeMillis() - lastUpdatedTime;
            // RECEIVE
            line = reader.readLine();

            if(line != null){
                // Heartbeat is alive
                System.out.println(line);
                lastUpdatedTime = System.currentTimeMillis();
            }

            // MONITOR
            if(timer > expireTime*1000){
                // Time expired
                System.out.println("Warning: The sender is down, action needed.");
                JOptionPane.showMessageDialog(null, "Warning: The sender is down, action needed.");
                break;
            }
            Thread.sleep(checkingInterval*1000);
        }

        server.close();
    }
}
