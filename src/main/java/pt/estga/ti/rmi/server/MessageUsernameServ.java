package pt.estga.ti.rmi.server;

import pt.estga.ti.rmi.interfaces.MessageUsernameRemote;
import pt.estga.ti.rmi.interfaces.MessageUsernameRemoteImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MessageUsernameServ {

    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            MessageUsernameRemote service = new MessageUsernameRemoteImpl();
            Naming.rebind("UsernameRemote", service);
            System.out.println("Server is reading...");
        }catch (Exception e){
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
