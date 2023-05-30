//package org.example;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.SocketAddress;
//import java.sql.SQLOutput;
//
//public class GameClient {
//    private Socket socket;
//    private BufferedReader input;
//    private PrintWriter output;
//
//    public GameClient(String serverAddress, int port)
//    {
//        try{
//            socket = new Socket(serverAddress,port);
//            System.out.println("Connected to server " + serverAddress + " on port " + port);
//
//            input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            output=new PrintWriter(socket.getOutputStream(),true);
//
//            new Thread(new ServerResponseThread(input)).start();
//
//            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//            String command;
//            while( (command = keyboard.readLine()) != null)
//            {
//                output.println(command);
//                if(command.equals("exit"))
//                {
//                    break;
//                }
//            }
//        }catch (IOException e)
//        {
//            System.out.println("Error connecting to server: " + e.getMessage());
//        } finally {
//            try{
//                socket.close();
//            }catch (IOException e)
//            {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//}

import java.io.*;
import java.net.*;
import java.util.*;

public class GameClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner scanner = new Scanner(System.in);
            String line = null;

            while (!"exit".equalsIgnoreCase(line)) {
                line = scanner.nextLine();

                out.println(line);
                out.flush();

                System.out.println("Server replied " + in.readLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}