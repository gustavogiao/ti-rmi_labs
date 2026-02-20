package pt.estga.ti.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeRemote extends Remote {
    String sendTime(String format) throws RemoteException;
}
