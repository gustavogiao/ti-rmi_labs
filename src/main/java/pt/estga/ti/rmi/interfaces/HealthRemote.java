package pt.estga.ti.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HealthRemote extends Remote {

    String bodyMassIndex(double w, double h) throws RemoteException;

}
