package cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

    private Socket socket = null;

    public Connection(String ip, int port) throws UnknownHostException, IOException {
        socket = new Socket(InetAddress.getByName(ip), port);
    }

    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }

    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    public void closeConnection() throws IOException {
        socket.close();
    }

}
