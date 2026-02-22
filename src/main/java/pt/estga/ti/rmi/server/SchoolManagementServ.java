package pt.estga.ti.rmi.server;

import pt.estga.ti.rmi.interfaces.SchoolManagementRemote;
import pt.estga.ti.rmi.interfaces.SchoolManagementRemoteImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SchoolManagementServ {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            SchoolManagementRemote service = new SchoolManagementRemoteImpl();
            Naming.rebind("SchoolManagementRemote", service);
            System.out.println("Server is reading...");
        }catch (Exception e){
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
