package pt.estga.ti.rmi.server;

import pt.estga.ti.rmi.interfaces.TimeRemote;
import pt.estga.ti.rmi.interfaces.TimeRemoteImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TimeServ {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            TimeRemote service = new TimeRemoteImpl();
            Naming.rebind("TimeRemote", service);
            System.out.println("Server is reading");
        }catch (Exception e){
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
