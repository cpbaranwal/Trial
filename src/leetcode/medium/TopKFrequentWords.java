package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-words/description/
 * @author chandan
 *Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
 */
public class TopKFrequentWords {

  public static void main(String[] args) 
  {
    String[] words= {"i", "love", "leetcode", "i", "love", "coding"};
    int k=2;
    System.out.println("result= "+topKFrequent(words,k));

  }

  //approach: maintain min heap of k elements
  // hashmap for frequency
  public static List<String> topKFrequent(String[] words, int k) 
  {
    List<String> list= new ArrayList<String>();
    int len= words.length;
    if(len<k)//not possble
      return list;
    Map<String,Integer> map= new HashMap<String,Integer>();
    //prepare hashmap containing all words and frequency
    for(String word: words)
    {
      Integer cnt=1;
      if(map.containsKey(word))
        cnt= cnt+map.get(word);
      map.put(word, cnt);
    }
    
    ///min heap using priority queue
    PriorityQueue<Pair> queue= new PriorityQueue<Pair>(new Comparator<Pair>()
        {
          public int compare(Pair p1, Pair p2)
          {
            return (p1.freq-p2.freq);
          }
        });
    
    //add entry as per order
    for(Map.Entry<String,Integer> entry: map.entrySet())
    {
      Pair p= new Pair(entry.getKey(), entry.getValue());
      queue.offer(p);
      if(queue.size()>k)
        queue.poll();
    }
    
    while(!queue.isEmpty())
    {
      list.add(queue.poll().word);
    }
    System.out.println("before list="+list);
    Collections.reverse(list);
    return list;
  }
  
  
  private static class Pair
  {
    String word;
    int freq;
    
    public Pair(String wrd, int freq)
    {
      this.word=wrd;
      this.freq=freq;
    }
  }
}
