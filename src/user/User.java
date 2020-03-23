package user;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {
    String getUser(Integer id) throws RemoteException;
}
