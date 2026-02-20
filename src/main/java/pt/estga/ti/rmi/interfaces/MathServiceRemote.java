package pt.estga.ti.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MathServiceRemote extends Remote {

    long factorial(int n) throws RemoteException;

    long maxPrimeBetween(int a, int b) throws RemoteException;

    int minPrimeBetween(int a, int b) throws RemoteException;

    double sum(List<Double> values) throws RemoteException;


}
