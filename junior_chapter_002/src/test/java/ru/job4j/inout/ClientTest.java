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

public class ClientTest {
    private static final String LN = System.getProperty("line.separator");

    private void testClient(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ByteArrayInputStream inConsole = new ByteArrayInputStream(input.getBytes());
        System.setIn(inConsole);
        Client client = new Client(socket);
        client.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenConsoleInputByeThenOutputStreamBye() throws IOException {
        this.testClient("bye", String.format("bye%s", LN));
    }

    @Test
    public void whenConsoleInputHelloAndByeThenOutputStreamHelloAndBye() throws IOException {
        this.testClient(Joiner.on(LN).join("hello", "bye"), String.format("hello%sbye%s", LN, LN));
    }
}
