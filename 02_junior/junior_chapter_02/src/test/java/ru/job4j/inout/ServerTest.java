package ru.job4j.inout;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenSendByeThenBackNothing() throws IOException {
        this.testServer("bye", LN);
    }

    @Test
    public void whenAskHelloThenBackHelloDearFriend() throws IOException {
        this.testServer(Joiner.on(LN).join("hello", "bye"), String.format("Hello, dear friend, I'm a oracle.%s%s%s", LN, LN, LN));
    }

    @Test
    public void whenUnsupportedAskThenDontNow() throws IOException {
        this.testServer(Joiner.on(LN).join("unsupported", "bye"), String.format("I don't know.%s%s%s", LN, LN, LN));
    }
}
