package org.example_hw_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            try (Socket client = server.accept();
                 PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                System.out.println("Подключение установлено!");
                pw.println("Hello! What is your name?");
                String name = "";
                boolean flag = true;
                while (flag) {
                    String s = br.readLine();
                    System.out.println(s);
                    switch (s) {
                        case ("no"):
                            pw.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                            flag = false;
                            break;
                        case ("yes"):
                            pw.println("Welcome to the kids area, " + name + "! Let's play!");
                            flag = false;
                            break;
                        default:
                            name = s;
                            pw.println("Are you children?");
                            break;
                    }
                }

//                    final String name = br.readLine();
//                    pw.println(String.format("Hi %s, your port is %d", name, client.getPort()));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}