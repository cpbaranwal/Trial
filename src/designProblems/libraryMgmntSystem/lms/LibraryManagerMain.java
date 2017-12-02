package designProblems.libraryMgmntSystem.lms;



import designProblems.libraryMgmntSystem.lms.dbmanager.DbManager;
import designProblems.libraryMgmntSystem.lms.dbmanager.MyCacheDbManager;

/**
 * 
 * @author chandan
 * PROBLEM STATEMENT:
 * 1. Ability to add books to the system.
2. Ability to add users to the system.
3. Ability to lend books to users.
4. Ability to return books to the library.
5. Users can have either Monthly Subscription (Borrow Limit = 5 books) or Annual
Subscription (Borrow Limit = 10 books).
Guidelines
1. You do not need to implement any persistence mechanism - a database or files or in-
memory database. Please use the Java’s basic data structures like List, Map etc.
2. Please write a production quality code. Ex: Even though the current requirement is to
store everything in-memory, we should have the ability to replace it with a persistence
layer, say, MySQL.
3. DRY - Wherever applicable follow DRY - Don’t Repeat Yourself.
4. It is sufficient to have the ability to interact with your program using main() method. It is
optional to build a user interface or command line app.
 *
 */

public class LibraryManagerMain {

  
  
  /* 
   * TODO Some Thoughts:
   * 1. Track book issuance date to any user ,send him reminders near expiry date
   * 2. fine users with penalty charges who have delayed returning book as per subscription plan
   * 3. Use Logger instead of sysout
   */
  
  public static void main(String[] args) {
    
    LibraryManagerMain lm= new LibraryManagerMain();
    lm.addBookToLibrary(100, 1, "author100", "title100");
    lm.addBookToLibrary(101, 2, "author101", "title101");
    /* lm.addBookToLibrary(102, 1, "author102", "title102");
    lm.addBookToLibrary(103, 2, "author103", "title103");
    lm.addBookToLibrary(104, 1, "author104", "title104");
    lm.addBookToLibrary(104, 1, "author104", "title104");
    lm.addBookToLibrary(104, 1, "author104", "title104");
    lm.addBookToLibrary(104, 1, "author104", "title104");
    */
    lm.addUserToLibrary(1, "aaaa", "address1", "monthly");
    lm.addUserToLibrary(2, "bbbbb", "address1", "annual");
    lm.addUserToLibrary(1, "aaaa", "address3", "weekly");//should not be allowed
    lm.addUserToLibrary(3, "aaaa", "address3", "biweekly");//should not be allowed
    lm.addUserToLibrary(4, "ddddd", "address4", "weekly");
    lm.addUserToLibrary(5, "eeeee", "address5", "monthly");
    
    System.out.println("\n Initial: \n");
    lm.showBooks();
    lm.showUsers();
    
    lm.lendBookToUser(101, 1);
    lm.lendBookToUser(101, 1);
    lm.lendBookToUser(101, 2);;
    //lm.returnBookToLibrary(101, 1);
    
    System.out.println("\n After: \n");
    lm.showBooks();
    lm.showUsers();
    
  }
  
  DbManager dbmngr;//DbManager as composition, to delegate any calls related to persistence
  
  public LibraryManagerMain()
  {
    dbmngr= MyCacheDbManager.getInstance();//just change instantiation if persistence layer is changed in future
  }
  
  //add book to lms
  public void addBookToLibrary(int isbn, int quant, String author, String title)
  {
    
     if(dbmngr.addBook(isbn, quant, author, title))
       System.out.println("Book with isbn:"+isbn+" succesfully added to Library");
     else
       System.out.println("Book with isbn:"+isbn+" could not be added to Library");
  }
  
  // add user to lms
  public void addUserToLibrary( int id, String name, String address, String subscription)
  {
     if(dbmngr.addUser(id, name, address, subscription))
       System.out.println("User with id:"+id+" succesfully added to Library");
     else
       System.out.println("User with id:"+id+" could not be added to Library");
  }
  
  // lend book to user
  public void lendBookToUser(int isbn, int userId)
  {
    if(dbmngr.lendBook(isbn, userId))
      System.out.println("Book with isbn:"+isbn+" succesfully lended to user with id: "+userId);
    else
      System.out.println("Book with isbn:"+isbn+" could not be lended to user with id: "+userId);
  }
  
  // return book to library
  public void returnBookToLibrary(int isbn, int userId)
  {
    if(dbmngr.returnBook(isbn, userId))
      System.out.println("Book with isbn:"+isbn+" succesfully returned to Library from user: "+userId);
    else
      System.out.println("Book with isbn:"+isbn+" could not be returned to Library from user: "+userId);
  }
  
  //print current users
  public void showUsers()
  {
    dbmngr.printAllUsers();
  }
  
  //print current books
  public void showBooks()
  {
    dbmngr.printAllBooks();
  }
  

}
