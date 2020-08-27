package cliente;

import java.io.IOException;
import java.net.UnknownHostException;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Printer printer = new Printer();
        Connection conn = new Connection("localhost", 1253);
        printer.printer("conected");
        Writer writer = new Writer(conn.getOutputStream());
        Reader clientReader = new Reader(System.in);
        Reader socketReader = new Reader(conn.getInputStream());

        String line = null;
        String menu = "----------------- Escolha uma das Opções asseguir: -----------------\n"
                + "1    --> Informar hora\n"
                + "2    --> Informar data\n"
                + "3    --> Informar data e hora\n"
                + "Sair --> Encerrar aplicação\n\n";

        printer.printer(menu);

        while (!(line = clientReader.readLine()).equals("sair")) {
            writer.writer(line);
            String valor = socketReader.readLine();
            printer.printer(valor);
            printer.printer(menu);
        }

        String out = "sair\n";
        writer.writer(out);

        writer.closeWriter();
        clientReader.closeReader();
        socketReader.closeReader();
        conn.closeConnection();
        printer.printer("Connection close");

    }

}
