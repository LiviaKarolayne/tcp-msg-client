package cliente;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Writer {

    private BufferedWriter writer = null;

    public Writer(OutputStream outputStream) {
        writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public void writer(String line) throws IOException {
        writer.write(String.format("%s\n", line));
        writer.flush();
    }

    public void closeWriter() throws IOException {
        writer.close();
    }

}
