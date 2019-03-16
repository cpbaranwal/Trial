package pack8;
import java.util.*;
import java.io.*;

/**
date: 14 june 2015
 Program to implement a LRU cache in java.
 For simplicity, my LRU cache is for finding Last Name for a given First Name.
 During initialization, user needs to give the SIZE of cache.
 
 Approach:
 1. LRU cache internally will maintain a doubly linked list and a Hashmap of a maxm size deicded by user input.
 2. If request is for a new data, it will be read from disk file and load into cache. Will discard the oldest used element from hashamap and linkedlist if size is exceeded.
 3. if request is for a data already in cache,it will return for hashMap and at the same time,will move the element in doubly linked list to the front as it is now most recently used element.

 update 15mar19: For Thread Safe Implementation, refer this: https://www.ebayinc.com/stories/blogs/tech/high-throughput-thread-safe-lru-caching/

 */

public class LRU_CacheImplementation {

	public static void main(String[] args)
	{
		System.out.println("LRU cache to fetch last name for a given first name");
		LRUCache cache = new LRUCache(5);
		System.out.println("cache result: cache.fetchData(\"chandan\") = "+cache.fetchData("chandan"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"shekhar\") = "+cache.fetchData("shekhar"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"alok\") = "+cache.fetchData("alok"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"chandan\") = "+cache.fetchData("chandan"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"shekhar\") = "+cache.fetchData("shekhar"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"himanshu\") = "+cache.fetchData("himanshu"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"bhaskar\") = "+cache.fetchData("bhaskar"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"shailesh\") = "+cache.fetchData("shailesh"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"aman\") = "+cache.fetchData("aman"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"devendra\") = "+cache.fetchData("devendra"));
		cache.printData();
		System.out.println("cache result: cache.fetchData(\"bhaskar\") = "+cache.fetchData("bhaskar"));
		cache.printData();
	}
	
	
	//for simplicity my LRU Cache is for finding Last name for a given First Name
	static class LRUCache
	{
		private final int MAX_SIZE ;
		private int count;
		private final Map<String,Dnode<String>> map ;
		private Dnode<String> head=null;
		private Dnode<String> tail=null;
		public LRUCache(int size) {
			super();
			this.MAX_SIZE = size;
			map = new HashMap<String,Dnode<String>>(MAX_SIZE);
			count=0;
		}
		
		public void printData() 
		{
			Dnode<String> tmp=head;
			System.out.println("current data in cache:  ");
			while(tmp!=null)
			{
				System.out.print("  "+tmp.data);tmp=tmp.nxt;
			}
			System.out.println();
		}

		//this is the only exposed API: getting Last Name will try to get name from cache if possible else will look into a disk file
		public String fetchData(String firstName)
		{
			Dnode<String> node = map.get(firstName);
			if(node != null)//its a hit
			{
				System.out.println("its a Hit: lastName: "+node.data+"  found for "+firstName);
				moveNodeToFront(node); // move the node to the front of DLLas its most recently used now
			}
			else  //its a miss; so read from disk file and add to cache before returning value
			{
				String lastName = getDataFromDisk(firstName);   //getting data from disk file
				node = new Dnode(lastName);
				appendNodeToFront(node);   //new node needs to appended to the front of DLL
				map.put(firstName, node);
			}
			return node.data;
		}

		private String getDataFromDisk(String firstName) 
		{
			BufferedReader br = null;
			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader("/home/priya/Desktop/chandan/workspaceChandan/Trial/src/pack8/data.txt"));
				while ((sCurrentLine = br.readLine()) != null) 
				{
					sCurrentLine = sCurrentLine.trim();
					if(sCurrentLine.startsWith(firstName))
					{
						String lastName = (sCurrentLine.split(","))[1];
						System.out.println(" its a miss: Reading last name from disk file :"+lastName+ "   for firstName="+firstName);
						return lastName;
					}	 
				}
				System.err.println(" Error: No last name found in disk for firstName="+firstName);
				throw new RuntimeException("Exception: No last name found in disk for firstName="+firstName);
	 
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			return "unknown";
		}

		//new node to be appended,so check if size of cache exceeds limit and evict last node of DLL (and from map as well) if limit is exceeded.
		private void appendNodeToFront(Dnode<String> node) 
		{
			count++;
			node.nxt = head;
			node.prev=null;
			if(head==null) //first element in cache
			{
				tail=node;
			}
			else
			{
				head.prev=node;
			}
			head=node;	
			if(count > MAX_SIZE)
			{
				Dnode<String> lNode = tail;
				tail = lNode.prev;
				tail.nxt=null;
				lNode.prev=null;
				map.remove(lNode);//remove from Map also
				System.out.println("Cache size exceeded limit, so removing from cache: "+lNode.data);
				count--;
			}
		}

		//only structural change in cache, no new element 
		private void moveNodeToFront(Dnode<String> node) 
		{
			if(node.equals(head))
				return; //no need to do anything
			Dnode<String> tmpPrev=node.prev;
			Dnode<String> tmpNxt=node.nxt;
			tmpPrev.nxt = tmpNxt;
			if(tmpNxt!=null)
				tmpNxt.prev=tmpPrev;
			else //means node was the last element,so now tmpPrev will be last element,so have to update tail
				tail=tmpPrev;
			node.nxt = head;
			node.prev = null;
			head.prev = node;
			head = node;
			
		}
		
		
		
	}
	
	private  static  class Dnode<E>
	{
		E data;
		Dnode nxt;
		Dnode prev;
		public Dnode(E data) {
			prev=null;
			this.data = data;
			nxt=null;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dnode other = (Dnode) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			return true;
		}
	}

}
