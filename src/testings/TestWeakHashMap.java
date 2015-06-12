package testings;

import java.util.WeakHashMap;

public class TestWeakHashMap {
public static void main(String[] args) {
WeakHashMap weakHashMap = new WeakHashMap();
// Create a key for the map, but keep the strong reference
String keyStrongReference = "key";   // new String("key");
weakHashMap.put(keyStrongReference, "value");
// Run the GC and check if the key is still there.
System.gc();
System.out.println(weakHashMap.get("key"));
// Now, null-out the strong reference and try again.
keyStrongReference = null;
System.gc();
System.out.println(weakHashMap.get("key"));
}
}