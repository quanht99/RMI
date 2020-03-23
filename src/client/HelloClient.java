package client;

import HelloWorld.HelloWorld;
import user.User;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient implements Serializable {
    private HelloClient(){};
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1239);
        User stub1 = (User) registry.lookup("HelloWorld123");
        HelloWorld stub2 = (HelloWorld) registry.lookup("HelloWorld123");
        System.out.println("Response sayHello: " + stub2.sayHello());
        String response = stub1.getUser(17020984);
        System.out.println("Response getUser:\n" + response);
    }
}
