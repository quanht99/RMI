package server;
import HelloWorld.HelloWorld;
import student.Student;
import user.User;

import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements HelloWorld , Remote, User, Serializable {
    public static final Student[] students = new Student[5];
    public HelloServer() throws RemoteException {
        super();
    };
    @Override
    public String sayHello() {
        return "Hello, world";
    }

    public static void main(String[] args) throws RemoteException {
        //Init student
        initStudent();
        try {
            HelloServer obj = new HelloServer();
            Registry registry = LocateRegistry.createRegistry(1239);
            registry.bind("HelloWorld123", obj);
            System.out.println("RMI online");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }

    public static void initStudent(){
        students[0] = new Student("A", 17020984, "BN");
        students[1] = new Student("B", 17020985, "TB");
        students[2] = new Student("C", 17020986, "HD");
        students[3] = new Student("D", 17020987, "QN");
        students[4] = new Student("E", 17020988, "HN");
    }

    public String print(Student student){
        return "Name: " + student.name + "\n" + "Mssv: " + student.mssv + "\n" + "Address: " + student.address + "\n";
    }
    @Override
    public String getUser(Integer id) {
            for(int i =0; i<students.length; i++){
                if(students[i].mssv.equals(id)) return print(students[i]);
            }
            return "Can't not find Student.";
    }
}
