package pt.estga.ti.rmi.server;

import pt.estga.ti.rmi.interfaces.HealthRemote;
import pt.estga.ti.rmi.interfaces.HealthRemoteImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HealthServer {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            HealthRemote service = new HealthRemoteImpl();
            Naming.rebind("HealthRemote", service);
            System.out.println("Service is reading...");
        }catch (Exception e){
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
