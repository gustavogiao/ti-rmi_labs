package pt.estga.ti.rmi.client;

import pt.estga.ti.rmi.interfaces.MathServiceRemote;

import java.rmi.Naming;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) {
        try{
            MathServiceRemote service = (MathServiceRemote)
                    Naming.lookup("rmi://127.0.0.1/MathRemote");

            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("\n1 - Fatorial");
                System.out.println("2 - Max prime between 2 values");
                System.out.println("3 - Min prime between 2 values");
                System.out.println("4 - Sum of values");
                System.out.println("0 - Exit");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Number");
                        int n = scanner.nextInt();
                        System.out.println("Result: " + service.factorial(n));
                        break;

                    case 2:
                        System.out.println("Number 1: ");
                        int n1 = scanner.nextInt();
                        System.out.println("Number 2: ");
                        int n2 = scanner.nextInt();
                        System.out.println("Result: " + service.maxPrimeBetween(n1, n2));
                        break;

                    case 3:
                        System.out.println("Number 1: ");
                        n1 = scanner.nextInt();
                        System.out.println("Number 2: ");
                        n2 = scanner.nextInt();
                        System.out.println("Result: " + service.minPrimeBetween(n1, n2));
                        break;

                    case 4:
                        scanner.nextLine();
                        System.out.println("Values separated by space: ");
                        String line = scanner.nextLine();

                        List<Double> values = Arrays.stream(line.split(" "))
                            .map(Double::parseDouble)
                            .toList();

                        System.out.println("Result: " + service.sum(values));
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
