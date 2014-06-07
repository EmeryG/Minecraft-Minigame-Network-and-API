package minepow.hubapi.partyapi.sockets;

import minepow.hubapi.Main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Connor Peticca on 6/6/2014.
 */
abstract public class ServerConnections extends Thread {

    public static ServerSocket ServerSock;
    public static ArrayList<Socket> Connections = new ArrayList<Socket>();

    // Maintains connections
    @Override
    public void run() {

        for(String s : Main.plugin.getConfig().getStringList("Servers")){

        }
        for (String s : Main.plugin.getConfig().getStringList("Servers")) {

            String[] s1 = s.split(":");
            String IP = s1[0];
            int Port = Integer.valueOf(s1[1]);

        }
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
