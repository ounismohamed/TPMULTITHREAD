import java.io.IOException;
import java.net.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServeurMultithread {


    public static void main(String[] args) {

        int nbClients=0;

        try {
            ServerSocket ss = new ServerSocket(1234);
            while(true){
                System.out.println("J'attend une connexion client");
                Socket s = ss.accept();
                ++nbClients;
                ServiceServeur serveur1 = new ServiceServeur(s,nbClients);
                serveur1.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
