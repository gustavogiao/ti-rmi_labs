package pt.estga.ti.rmi.client;

import pt.estga.ti.rmi.interfaces.MessageUsernameRemote;

import java.rmi.Naming;
import java.util.Scanner;

public class MessageUsernameClient {
    public static void main(String[] args) {
        try{
            MessageUsernameRemote service = (MessageUsernameRemote)
                Naming.lookup("rmi://127.0.0.1/UsernameRemote");

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your username please: ");
            String username = scan.nextLine();

            String response = service.sendUsername(username);

            System.out.println("Server response: " + response);

        }catch (Exception e){
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
