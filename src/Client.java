import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws Exception , IOException {
        Scanner clavier = new Scanner(System.in);
        int nb = 1;
        String message = "";


        System.out.println("Creer une connexion au serveur:");
        Socket clientSocket = new Socket("localhost", 1234);
        OutputStream os = clientSocket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);

        InputStream is = clientSocket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);


        do{
            System.out.println("Saisir une chaine de caracteres");
            message =clavier.nextLine();
            pw.println(message);
            System.out.println("Attendre la réponse du serveur: ");
            String s = br.readLine();
            System.out.println(s);

        }
        while(!message.equals(""));
        clientSocket.close();



    }

}
