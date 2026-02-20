package pt.estga.ti.rmi.server;

import pt.estga.ti.rmi.interfaces.MathServiceRemote;
import pt.estga.ti.rmi.interfaces.MathServiceRemoteImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MathServer {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            MathServiceRemote service = new MathServiceRemoteImpl();
            Naming.rebind("MathRemote", service);
            System.out.println("Server is reading...");
        }catch (Exception e){
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
