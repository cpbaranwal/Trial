package designProblems.libraryMgmntSystem.lms.dbmanager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import designProblems.libraryMgmntSystem.lms.model.Book;
import designProblems.libraryMgmntSystem.lms.model.Subscription;
import designProblems.libraryMgmntSystem.lms.model.User;

/**
 * 
 * @author chandan
 * Responsibilty:  Concrete Implementation of DbManager.
 * In this case, it is holding all data in-memory using data structures.
 */
public class MyCacheDbManager extends DbManager
{
  private Map<Integer,Book> booksCache;
  private Map<Integer,User> userCache;
  
  //getInstance method for singleton
  private MyCacheDbManager()
  {
    //concurrent hashmap for handling concurrent operations
    booksCache= new ConcurrentHashMap<Integer,Book>();
    userCache= new ConcurrentHashMap<Integer,User>();
  }
  
  /**
   * Singleton instance of CacheDbManager, no need of having multiple instances per JVM
   * @return
   */
  public static MyCacheDbManager getInstance()
  {
    return Holder.cacheHolder;//lazy singleton initialization
  } 
  private static class Holder
  {
    public static MyCacheDbManager cacheHolder= new MyCacheDbManager();
  }
  
  
  //Implemented Methods from parent Abstract class
  
  /**
   * adding Book to cache
   * thread safe : can handle concurrent operations 
   */ 
  @Override
   boolean addBookHelper(int isbn, int quant, String author, String title) 
  {
    //System.out.println("addBookHelper: isbn="+isbn+"  quant="+quant);
    Book book= booksCache.get(isbn);
    if(book==null)
    {
      while(booksCache.get(isbn)==null)
      {
        book= new Book(isbn, quant, author, title);
        if(booksCache.putIfAbsent(isbn, book)==null)//if put operation got successful,return else retry as multiple threads tried at same time
          return true;
      }
      
    }
    System.out.println(2222);
    book= booksCache.get(isbn);
    book.addCopiesToBook(quant);
    return true;
  }

  /**
   * adding User to cache
   * thread safe : can handle concurrent operations 
   */
  @Override
   boolean addUserHelper(int id, String name, String address, String subscription) 
  {
    User user= userCache.get(id);
    if(user==null)
    {
      while(userCache.get(id)==null)
      {
        user= new User(id, name, Subscription.getSubscription(subscription), address);
        if(userCache.putIfAbsent(id, user)!=null)//if put operation got successful,return else retry as multiple threads tried at same time
          return true;
      }
    }
    return false;
  }

  /**
   * Lending Book to User
   * thread safe : can handle concurrent operations 
   */
  @Override
   boolean lendBookHelper(int isbn, int userId) 
  {
    Book book= booksCache.get(isbn);
    User user= userCache.get(userId);
    int availCopies= book.getQuantityAvailable();
    if(availCopies==0)
      return false;
    if(book.updateBookInventory(-1)<0)//issue one book, so decrement by one, also check updated value must not be less than 0 to guarantee book existed
    {
      book.updateBookInventory(1);//attempt not succesful, restore if count less than 0
      return false;
    }
    user.getIssuedBooks().add(isbn);
    return true;
  }

  /**
   * returning Book to cache
   * no need to be thread safe as User will always contain book before returning 
   */
  @Override
   boolean returnBookHelper(int isbn, int userId) {
    Book book= booksCache.get(isbn);
    User user= userCache.get(userId);
    book.updateBookInventory(1);
    user.getIssuedBooks().remove(isbn);
    return false;
  }

  @Override
  protected boolean checkUserIfExists(int userId) {
    return userCache.containsKey(userId);
  }
  
  @Override
  protected boolean checkUserIfLimitExceeded(int userId) {
    return (userCache.get(userId).getIssuedBooks().size() >= userCache.get(userId).getSubscription().getMaxLimitBooks());
  }

  @Override
   boolean checkBookIfExists(int isbn) {
   return booksCache.containsKey(isbn);
  }

  @Override
   boolean checkBookIfExistsWithUser(int isbn, int userId) {
    return userCache.get(userId).getIssuedBooks().contains(isbn);
  }

  @Override
  public void printAllUsers() {
    System.out.println("current users in library: ");
    for(User user: userCache.values())
    {
      System.out.println(user);
    }
    
  }

  @Override
  public void printAllBooks() {
    System.out.println("current books in library: ");
    for(Book book: booksCache.values())
    {
      System.out.println(book);
    }
    
  }
  
  
  
 

}
