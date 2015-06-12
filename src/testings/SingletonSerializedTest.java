package testings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
public class SingletonSerializedTest {
 
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        
        /*
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "C:/workspace/Trial/src/testings/serializedSingleton"));
        out.writeObject(instanceOne);
        out.close();
        */
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "C:/workspace/Trial/src/testings/serializedSingleton"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
         
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
         
    }
    
}
