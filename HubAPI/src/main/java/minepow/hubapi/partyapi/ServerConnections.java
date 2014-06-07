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

<<<<<<< HEAD

        for(String s : Main.plugin.getConfig().getStringList("Servers")){

            String[] s1 = s.split(":");
            String IP = s1[0];
            int Port = Integer.valueOf(s1[1]);

        }


        try{
=======
        try {
>>>>>>> e614f71d84b5ed7a5fb1d2ffc12c0d279342992f

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
