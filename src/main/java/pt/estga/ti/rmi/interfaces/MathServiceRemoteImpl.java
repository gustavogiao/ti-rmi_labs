package pt.estga.ti.rmi.interfaces;

import pt.estga.ti.rmi.utils.MathUtils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MathServiceRemoteImpl extends UnicastRemoteObject implements MathServiceRemote {

    public MathServiceRemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public long factorial(int n) throws RemoteException {
        return MathUtils.factorial(n);
    }

    @Override
    public long maxPrimeBetween(int a, int b) throws RemoteException {
        return MathUtils.maxPrimeBoolean(a, b);
    }

    @Override
    public int minPrimeBetween(int a, int b) throws RemoteException {
        return MathUtils.minPrimeBoolean(a,b);
    }

    @Override
    public double sum(List<Double> values) throws RemoteException {
        return values.stream().mapToDouble(Double::doubleValue).sum();
    }
}
