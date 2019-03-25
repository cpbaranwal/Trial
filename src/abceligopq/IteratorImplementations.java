package abceligopq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chandan on 20/03/19
 */
public class Test1 {

// You have an iterator of Int on input.
// Please return iterator of iterators of Int that would group positive and negative numbers
// without changing order.
// in:  Iterator[Int]
// out: Iterator[Iterator[Int]]
// MEMORY : O(1)
// Example: [1, 2, 0, -1, -2, 8, -1] => [[1, 2, 0], [-1, -2], [8], [-1]]

// Note: we think that iterator implements two methods:
// boolean hasNext()
// Int next()

    public static void main(String[] args){


        List<Integer> list = new ArrayList<Integer>();
        list.add(1); list.add(2);
        list.add(-1); list.add(-2);
        list.add(1); //list.add(-2);


        Iterator<Integer> iter = new FilterIterator(list.iterator());

        while(iter.hasNext())
        {
            System.out.println("element = " + iter.next());
        }



    }

// Example: [1, 2, 0, -1, -2, 8, -1] => [[1, 2, 0], [-1, -2], [8], [-1]]
    //static int[] arr = {1, 2, 0, -1, -2, 8, -1};
    private static class IteratorWithIterator {
        List<Integer> list;
        int indx=0;
        int size;

        public IteratorWithIterator(List<Integer> list){
            this.list=list;
            size = list.size();
        }


        public boolean hasNext(){
            return (indx<list.size());

        }

        public Iterator<Integer> next(){
            if(indx >= size)
                throw new IllegalStateException("no elements remaining");
            int tmpEnd = indx+1;
            boolean isPositive = list.get(indx) >= 0;
            if(isPositive && tmpEnd<size){
                while(list.get(tmpEnd) >= 0)
                    tmpEnd++;
            }
            else if(!isPositive && tmpEnd<size){
                while(list.get(tmpEnd) < 0)
                    tmpEnd++;
            }

            Iterator<Integer> iter = new EmbeddedIterator(indx, tmpEnd, list);
            return iter;
        }

    }


    private static class EmbeddedIterator<Integer> implements Iterator<Integer> {

         int indx, end;// end is exclusive
        //boolean isPositive ;
         List<Integer> list;
        //private Integer prev = null;

        public EmbeddedIterator(int start, int end, List<Integer> list){
            this.list=list;
            this.indx=start;
            this.end=end;
        }

        @Override
        public boolean hasNext() {
            return (indx<end);
        }

        @Override
        public Integer next() {
            if(indx >= end)
                throw new IllegalStateException("no elements remaining");
            Integer elem = list.get(indx++);
            return elem;
        }
    }





    // RandomInfiniteIterator {
//   hasNext -> true
//   next -> new random number
//  }

// 1 : Iterator[Int]
// 2 : Iterator[Int]
// 1 ++ 2
// [1, 2, 3] ++ [4, 5] =>  [1, 2, 3, 4, 5]

/*

    private static class MyIterator implements Iterator{
        Iterator<Integer> iter1;
        Iterator<Integer> iter2;
        public MyIterator(Iterator<Integer> iter1, Iterator<Integer> iter2){
            this.iter1=iter1;
            this.iter2= iter2;
        }


        public boolean hasNext(){
            return(iter1.hasNext() || iter2.hasNext());
        }

        public Integer next(){
            if(iter1.hasNext())
                return iter1.next();
            if(iter2.hasNext())
                return iter2.next();
            // throw exception

        }



    }

*/



// 1, -1, -2, 2, 3
    private static class FilterIterator implements Iterator{
        Iterator<Integer> iter1;
        public FilterIterator(Iterator<Integer> iter1){
            this.iter1=iter1;
        }

        int nextElement = -1;
        public boolean hasNext(){
            if(nextElement > 0 )
                return true;

            Integer tmp = -1;
            while(iter1.hasNext() && tmp<0){
                tmp = iter1.next();
            }
            if(tmp>0){
                nextElement = tmp;
                return true;
            }
            else
                return false;
        }

        public Integer next(){
            Integer tmp = nextElement;
            nextElement = -1;
            return tmp;
        }



    }


    /*

    public static Iterator<Iterator<Integer>> getIterator(Iterator<Integer> iter){

        Iterator<Iterator<Integer>> newIter = new Iterator<Iterator<Integer>>{


            public boolean hasNext(){

            }

            public Iterator<Integer> next(){
                while(iter.hasNext() && )
            }
            return newIter;

        }



    }
*/



}
