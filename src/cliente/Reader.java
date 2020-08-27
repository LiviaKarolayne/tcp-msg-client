package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {

    private BufferedReader reader = null;

    public Reader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String readLine() throws IOException {
        String line = reader.readLine();
        return line;
    }

    public void closeReader() throws IOException {
        reader.close();
    }

}
