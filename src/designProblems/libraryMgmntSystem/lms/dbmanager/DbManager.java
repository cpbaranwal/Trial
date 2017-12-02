package designProblems.libraryMgmntSystem.lms.dbmanager;

import designProblems.libraryMgmntSystem.lms.model.Subscription;

/**
 * @author chandan
 * Responsibilty:  Generic DbManager exposing common abstract/implemented methods to interact with data store.
 * Data store can be anything like in-memory hashmap or some persistence layer like Mysql,etc, depends on concerete classes.
 * 
 */
public abstract class DbManager 
{
  //add new book to lms or else increase quantity of existing Book
  public boolean addBook(int isbn, int quant, String author, String title)
  {
    if(quant<1)
    {
      System.out.println("can not add quantity less than 1, invalid quantity: "+quant);
      return false;
    }
    return addBookHelper( isbn,  quant,  author,  title)  ;
  }
  
  //add new user to lms if not exists already
  public boolean addUser(int id, String name, String address, String subscription)
  {
    if(subscription==null || Subscription.getSubscription(subscription)==null)
    {
      System.out.println("can not add User:"+id+" with invalid subscription: "+subscription);
      return false;
    }
    if(checkUserIfExists(id))
    {
      System.out.println("can not add User, already exists with id="+id);
      return false;
    }
    return addUserHelper(id, name, address, subscription);
  }
  
  //lend book to user
  public boolean lendBook(int isbn, int userId)
  {
    if(!checkUserIfExists(userId))// user should be valid
    {
      System.out.println("can not lend book as invalid User with id="+userId);
      return false;
    }
    if(checkUserIfLimitExceeded(userId))//issue book only if limit not exceeded as per subscription plan
    {
      System.out.println("can not lend book as User has exceeded book limit as per subscription plan");
      return false;
    }
    if(!checkBookIfExists(isbn))//book should exist
    {
      System.out.println("can not lend book as invalid Book with isbn="+isbn);
      return false;
    }
    if(checkBookIfExistsWithUser(isbn,userId))//book should not be with user already
    {
      System.out.println("can not lend book as  Book with isbn="+isbn+"  is already with User: "+userId);
      return false;
    }
    return lendBookHelper(isbn, userId);
  }
  
  //return book to lms
  public boolean returnBook(int isbn, int userId)
  {
    if(!checkUserIfExists(userId))//user should be valid
    {
      System.out.println("can not return book as invalid User with id="+userId);
      return false;
    }
    if(!checkBookIfExists(isbn))//book should be valid
    {
      System.out.println("can not return book as invalid Book with isbn="+isbn);
      return false;
    }
    if(!checkBookIfExistsWithUser(isbn,userId))//book should be in possession with User
    {
      System.out.println("can not return book as  Book with isbn="+isbn+"   does not exist with User: "+userId);
      return false;
    }
    return returnBookHelper(isbn,userId);
  }
  
  
  

  //Abstract methods: To be implemented in concrete classes
   abstract boolean addBookHelper(int isbn, int quant, String author, String title);
   abstract boolean addUserHelper(int id, String name, String address, String subscription);
   abstract boolean lendBookHelper(int isbn, int userId);
   abstract boolean returnBookHelper(int isbn, int userId);
   abstract boolean checkUserIfExists(int userId);
   abstract boolean checkUserIfLimitExceeded(int userId);
   abstract boolean checkBookIfExists(int isbn);
   abstract boolean checkBookIfExistsWithUser(int isbn, int userId);
   public abstract void printAllUsers();
   public abstract void printAllBooks();
  
}
