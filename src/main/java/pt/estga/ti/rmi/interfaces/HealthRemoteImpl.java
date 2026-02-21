package pt.estga.ti.rmi.interfaces;

import pt.estga.ti.rmi.utils.HealthUtils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HealthRemoteImpl extends UnicastRemoteObject implements HealthRemote {

    public HealthRemoteImpl() throws RemoteException {}

    @Override
    public String bodyMassIndex(double w, double h) throws RemoteException {
        return HealthUtils.bodyMassIndex(w,h);
    }
}
