package pt.estga.ti.rmi.client;

import pt.estga.ti.rmi.interfaces.HealthRemote;

import java.rmi.Naming;
import java.util.Scanner;

public class HealthClient {
    public static void main(String[] args) {
        try{
            HealthRemote service = (HealthRemote)
                    Naming.lookup("rmi://127.0.0.1/HealthRemote");

            Scanner scan = new Scanner(System.in);

            while (true){
                System.out.println("\n1. IMC Classification");
                System.out.println("0. Exit");

                int option = scan.nextInt();
                scan.nextLine();

                switch (option){
                    case 1:
                        System.out.println("Weight: ");
                        double weight = scan.nextDouble();
                        System.out.println("Height: ");
                        double height = scan.nextDouble();
                        System.out.println("Result " + service.bodyMassIndex(weight, height));
                        break;
                    case 0:
                        System.exit(0);
                }
            }
        }catch (Exception e){
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
