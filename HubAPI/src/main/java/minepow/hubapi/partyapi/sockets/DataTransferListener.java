package minepow.hubapi.partyapi.sockets;

import minepow.hubapi.partyapi.PartyReciever;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Connor Peticca on 6/6/2014.
 */
abstract public class DataTransferListener extends Thread {

    // Listens for server data
    @Override
    public void run() {

        while (true) {

            try {

                for (Socket Sock : ServerConnections.Connections) {

                    BufferedReader br = new BufferedReader(new InputStreamReader(Sock.getInputStream()));
                    String message;

                    if ((message = br.readLine()) != null) {

                        PartyReciever.RecieveMessage(message);

                    }
                }
            } catch (Exception e) {
            }
        }
    }

    // Sends data to all servers
    public static void sendData(String message) {

        try {

            for (Socket Sock : ServerConnections.Connections) {

                PrintWriter pw;

                pw = new PrintWriter(Sock.getOutputStream());
                pw.println(message);

            }
        } catch (Exception e) {
        }
    }
}
