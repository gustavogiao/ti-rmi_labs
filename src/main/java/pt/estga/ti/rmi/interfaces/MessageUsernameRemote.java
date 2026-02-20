package pt.estga.ti.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageUsernameRemote extends Remote {
    String sendUsername(String username) throws RemoteException;
}
