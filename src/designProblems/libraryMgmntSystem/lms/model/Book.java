package designProblems.libraryMgmntSystem.lms.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
  
  private int isbn;//primary key for book
  //there can be multiple copies for same book
  private AtomicInteger quantityAvailable;//available copies to be allocated
  private AtomicInteger quantityTotal;//total copies of the same book
  private String title;
  private String author;
  
  public Book(int isbn, int quantity , String author, String title) {
    super();
    this.isbn = isbn;
    this.quantityAvailable = new AtomicInteger(quantity);
    this.quantityTotal = new AtomicInteger(quantity);
    this.title = title;
    this.author = author;
  }

  public int getIsbn() {
    return isbn;
  }

  public int getQuantityAvailable() {
    return quantityAvailable.get();
  }
  public int getQuantityTotal() {
    return quantityTotal.get();
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
  
  public int updateBookInventory(int quant)
  {
    //System.out.println("updateBookInventory: quant="+quant);
    return quantityAvailable.addAndGet(quant);
  }
  
  public void addCopiesToBook(int quant)
  {
    //System.out.println("addCopiesToBook: quant="+quant);
    quantityAvailable.addAndGet(quant);
    quantityTotal.addAndGet(quant);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + isbn;
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
    Book other = (Book) obj;
    if (isbn != other.isbn)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Book [isbn=" + isbn + ", quantityAvailable=" + quantityAvailable.get() + ", quantityTotal=" + quantityTotal.get() + ", title=" + title + ", author=" + author + "]";
  }
  
 
  
  
  

}
