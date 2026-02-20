package pt.estga.ti.rmi.client;

import pt.estga.ti.rmi.interfaces.TimeRemote;

import java.rmi.Naming;
import java.util.Scanner;

public class TimeClient {

    public static void main(String[] args) {
        try{
            TimeRemote service = (TimeRemote)
                    Naming.lookup("rmi://127.0.0.1/TimeRemote");

            Scanner scan = new Scanner(System.in);

            System.out.println("Which format do you want for date?");
            System.out.println("Examples: ");
            System.out.println("dd/MM/yyyy HH:mm:ss");
            System.out.println("yyyy-MM-dd");
            System.out.println("HH:mm");

            String format = scan.nextLine();

            String response = service.sendTime(format);

            System.out.println("Server response: " + response);
        }catch (Exception e){
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
