package ru.job4j.inout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.function.Supplier;

public class Server {
    private final Socket socket;
    private static final String LN = System.getProperty("line.separator");
    private Map<String, Supplier<String>> dispatch;

    Server(Socket socket) {
        this.socket = socket;
        this.mapInit();
    }

    public static void main(String[] args) {
        try (final Socket socket = new ServerSocket(5000).accept()) {
            Server server = new Server(socket);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mapInit() {
        Supplier<String> hello = () -> String.format("Hello, dear friend, I'm a oracle.%s", LN);
        Supplier<String> howAreYou = () -> String.format("I'm fine.%s", LN);
        Supplier<String> toBeOrNotToBe = () -> String.format(
                "To be, or not to be, that is the question:%s"
                        + "Whether 'tis nobler in the mind to suffer%s"
                        + "The slings and arrows of outrageous fortune,%s"
                        + "Or to take arms against a sea of troubles%s"
                        + "And by opposing end them.%s", LN, LN, LN, LN, LN);
        Supplier<String> bye = () -> "";
        Supplier<String> unknown = () -> String.format("I don't know.%s", LN);
        dispatch = new DefaultHashMap<>(unknown);
        dispatch.put("hello", hello);
        dispatch.put("how are you", howAreYou);
        dispatch.put("to be or not to be", toBeOrNotToBe);
        dispatch.put("bye", bye);
    }

    void start() {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            String ask;
            String answer;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                answer = this.dispatch.get(ask).get();
                out.println(answer);
            } while (!"bye".equals(ask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
