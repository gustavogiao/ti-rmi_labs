package pt.estga.ti.rmi.interfaces;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageUsernameRemoteImpl extends UnicastRemoteObject implements MessageUsernameRemote {

    public MessageUsernameRemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public String sendUsername(String username) throws RemoteException {
        return "Server says: Hello " + username;
    }
}
