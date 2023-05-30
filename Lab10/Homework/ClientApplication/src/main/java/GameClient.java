////package org.example;
////
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.io.PrintWriter;
////import java.net.Socket;
////import java.net.SocketAddress;
////import java.sql.SQLOutput;
////
////public class GameClient {
////    private Socket socket;
////    private BufferedReader input;
////    private PrintWriter output;
////
////    public GameClient(String serverAddress, int port)
////    {
////        try{
////            socket = new Socket(serverAddress,port);
////            System.out.println("Connected to server " + serverAddress + " on port " + port);
////
////            input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
////            output=new PrintWriter(socket.getOutputStream(),true);
////
////            new Thread(new ServerResponseThread(input)).start();
////
////            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
////            String command;
////            while( (command = keyboard.readLine()) != null)
////            {
////                output.println(command);
////                if(command.equals("exit"))
////                {
////                    break;
////                }
////            }
////        }catch (IOException e)
////        {
////            System.out.println("Error connecting to server: " + e.getMessage());
////        } finally {
////            try{
////                socket.close();
////            }catch (IOException e)
////            {
////                System.out.println(e.getMessage());
////            }
////        }
////    }
////
////}
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//
//public class GameClient {
//    public static void main(String[] args) {
//        try (Socket socket = new Socket("localhost", 1234)) {
//
//            // writing to server
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//
//            // reading from server
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//            System.out.println("Available commands: create, join, move, exit");
//            // object of scanner class
//            Scanner scanner = new Scanner(System.in);
//            String line = null;
//
//            while (!"exit".equalsIgnoreCase(line)) {
//                line = scanner.nextLine();
//
//                out.println(line);
//                out.flush();
//
//                System.out.println("Server replied " + in.readLine());
//            }
//            scanner.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;


public class GameClient {
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean gameIsOver = false;

    public GameClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        GameClient gameClient = new GameClient("localhost", 3000);
        gameClient.start();
    }

    public void start() {
        try {
            socket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected to server at " + host + ":" + port);
            System.out.println("Type create, join, move, exit");

            Thread responseThread = new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                        if (response.equals("WIN") || response.equals("LOSS") || response.equals("TIME_UP")) {
                            gameIsOver = true;
                            System.out.println("Type anything to exit");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading server response: " + e.getMessage());
                } finally {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException e) {
                        System.err.println("Error closing client connection: " + e.getMessage());
                    }
                }
            });
            responseThread.start();
            Scanner scanner = new Scanner(System.in);
            while (!gameIsOver) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    gameIsOver = true;
                    break;
                }
                out.println(input);
            }

            System.exit(0); // Terminate the client application
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}