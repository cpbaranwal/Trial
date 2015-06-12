package testings;

import java.io.Serializable;


public class SerializedSingleton implements Serializable{
   	 
        private static final long serialVersionUID = -7604766932017737115L;
     
        private SerializedSingleton(){}
         
        private static class SingletonHelper{
            private static final SerializedSingleton instance = new SerializedSingleton();
        }
         
        public static SerializedSingleton getInstance(){
            return SingletonHelper.instance;
        }
        
        //if this method is commented, deserializing singleton will use newly created  instance but anyhow it wont stop new objects from being created
        //although the other objects will not be having any memory reference and will be eligible for GC
        protected Object readResolve() {
            return getInstance();
        }
 
}


