package pt.estga.ti.rmi.interfaces;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeRemoteImpl extends UnicastRemoteObject implements TimeRemote {

    public TimeRemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public String sendTime(String format) throws RemoteException {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return now.format(formatter);
        } catch (Exception e) {
            return "Invalid format";
        }
    }
}
