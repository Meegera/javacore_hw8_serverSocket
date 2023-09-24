package org.example_hw_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try (Socket client = new Socket("netology.homework", Server.PORT);
             PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            boolean flag = true;
            while (flag) {
                String s = br.readLine();
                System.out.println(s);
                switch (s) {
                    case ("Hello! What is your name?"):
                        pw.println("Гретикс");
                        break;
                    case ("Are you children?"):
                        System.out.println("Write no/yes");
                        String isChildren = new Scanner(System.in).nextLine();
                        pw.println(isChildren);
                        break;
                    default:
                        flag = false;
                        break;
                }
            }
//            InetAddress inetAddress = InetAddress.getByName("netology.homework");
//            System.out.println("netology.homework" + ", ip address: " + inetAddress.getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
