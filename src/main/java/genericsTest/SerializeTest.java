package genericsTest;

import java.io.*;

public class SerializeTest {
    public static void main(String[] args) throws Exception{
        Employee e = new Employee();
        e.name = "Martin";
        e.address = "Shanghai";
        e.SSN = 234231421;
        e.number = 12;
        System.out.println(e);
        String filePath = "temp/employee.ser";
        File f = new File(filePath);
        if(f.isDirectory()){
            f.delete();
        }
        if(!f.exists()){
            f.createNewFile();
        }
        FileOutputStream fileOut = new FileOutputStream(f);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(e);
        fileOut.close();
        out.close();
        System.out.println("Serialized data is saved in /temp/empolyee.ser");
    }
}

class Employee implements Serializable{
    String name;
    String address;
    transient int SSN;
    int number;
    void mailCheck(){
        System.out.println("Mailing a check to " + name + " " + address);
    }
}

class DeserializeTest{
    public static void main(String[] args) throws Exception{
        Employee e = null;
        String filePath = "temp/employee.ser";
        File f = new File(filePath);
        FileInputStream fileIn = new FileInputStream(f);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        e = (Employee) in.readObject();
        in.close();
        fileIn.close();
        System.out.println(e.name);
    }
}