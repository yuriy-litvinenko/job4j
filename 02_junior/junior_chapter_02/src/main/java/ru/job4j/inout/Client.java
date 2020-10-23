package ru.job4j.inout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 5000;
    private final Socket socket;

    Client(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        try (final Socket socket = new Socket(InetAddress.getByName(IP), PORT)) {
            Client client = new Client(socket);
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void start() {
        Scanner console = new Scanner(System.in);
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            String message;
            do {
                System.out.println("enter your message:");
                message = console.nextLine();
                out.println(message);
                for (String answer = in.readLine(); answer != null && !answer.isEmpty(); answer = in.readLine()) {
                    System.out.println(answer);
                }
            } while (!"bye".equals(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
