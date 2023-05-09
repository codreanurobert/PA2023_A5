//package org.example;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class ClientThread extends Thread {
//    private Socket clientSocket;
//    private GameServer gameServer;
//    private PrintWriter out;
//
//    public ClientThread(Socket clientSocket,GameServer gameServer) {
//        this.clientSocket = clientSocket;
//        this.gameServer = gameServer;
//        try {
//            out = new PrintWriter(clientSocket.getOutputStream(), true);
//        } catch (IOException e) {
//            System.out.println("Error creating output stream" + e.getMessage());
//        }
//
//    }
//
//    /*public void run() {
//        System.out.println("Client connected");
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                if (inputLine == "stop") {
//                    System.out.println("Server stopped");
//                    break;
//                } else {
//                    System.out.println("Received message: " + inputLine);
//                    out.println(inputLine);
//                }
//            }
//            in.close();
//            out.close();
//            clientSocket.close();
//        } catch (IOException e) {
//            System.out.println("Error handling client connection" + e.getMessage());
//        }
//
//    }*/
//    public void run() {
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                gameServer.broadcast(inputLine);
//            }
//
//            in.close();
//            out.close();
//            clientSocket.close();
//            gameServer.removeClientThread(this);
//        } catch (IOException e) {
//            System.out.println("Error handling client request: " + e.getMessage());
//        }
//    }
//    public void stopClient() {
//        try {
//            clientSocket.close();
//        } catch (IOException e) {
//            System.out.println("Error stopping client: " + e.getMessage());
//        }
//    }
//    public void sendMessage(String message) {
//        out.println(message);
//    }
//}
