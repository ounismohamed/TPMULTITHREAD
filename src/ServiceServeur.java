import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

    public class ServiceServeur extends Thread {

        private Socket socket;
        private int nbClient = 0;

        public ServiceServeur(Socket s, int nbClients) {
            socket = s;
            nbClient = nbClients;
        }

        public Socket getS() {
            return socket;
        }

        public void setS(Socket s) {
            this.socket = s;
        }

        public int getNbClient() {
            return nbClient;
        }

        public void setNbClient(int nbClient) {
            this.nbClient = nbClient;
        }

        public void start() {
            try {
                System.out.println("ServiceServeur - Client Num " + nbClient);
                OutputStream os;
                os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);

                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String s = br.readLine();
                System.out.println("ServiceServeur - Client Num " + nbClient + " message reçu: " + s);
                pw.println("- Client Num " + nbClient + " message reçu: " + s);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }