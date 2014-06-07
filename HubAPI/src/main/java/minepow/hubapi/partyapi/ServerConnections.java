package minepow.hubapi.partyapi;

import minepow.hubapi.Main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Connor Peticca on 6/6/2014.
 */
public class ServerConnections extends Thread {

    public static ServerSocket ServerSock;
    public static ArrayList<Socket> Connections = new ArrayList<Socket>();

    @Override
    public void run() {

        try {

            ServerSock = new ServerSocket(Main.plugin.getConfig().getInt("Port"));
            Socket Sock;

            while (true) {

                do {

                    Sock = ServerSock.accept();
                    if (!Connections.contains(Sock)) {
                        Connections.add(Sock);
                    }

                } while (Sock == null);


            }

        } catch (Exception e) {
        }
    }
}
