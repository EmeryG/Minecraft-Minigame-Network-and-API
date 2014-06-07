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
=======
        for (String s : Main.plugin.getConfig().getStringList("Servers")) {
>>>>>>> d5675efc75772950937b04f9c292ec65ff243051

            String[] s1 = s.split(":");
            String IP = s1[0];
            int Port = Integer.valueOf(s1[1]);

        }
<<<<<<< HEAD
        try {
=======

        try {
<<<<<<< HEAD
            try {
>>>>>>> d5675efc75772950937b04f9c292ec65ff243051

                ServerSock = new ServerSocket(Main.plugin.getConfig().getInt("Port"));
                Socket Sock;

                while (true) {

                    do {
=======
>>>>>>> ff5b8676bbbe93f936ef7508572fb2a25cc48bff

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
