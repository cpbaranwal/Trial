package designProblems.loggerDesign;

import java.util.logging.Logger;
import java.util.*;

/**
 * @author chandan on 13/03/19
 */
public class TestMain {

    public static void main (String[] args){

        Logger logger = Logger.getLogger("TestMain");
        //logger.getLevel();
        logger.info(" test msg");

        //System.out.println("result = " + oddNumbers(2,5));
        String[] cities = {"S","N","P","B"};
        System.out.println("result = " + Arrays.binarySearch(cities, "N"));
        //Arrays.binarySearch(cities, "N");

    }




    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {
        //HashMap<String , String> ma= = new HashMap<>();

        List<Integer> list = new ArrayList<Integer>();

        if(l<0 || r<0 || l>=r)
            return list;

        int num = l;
        if(l%2 == 0)
            num++;
        while(num <= r){
            list.add(num);
            num += 2;
        }

        return list;

    }

}
