package designProblems.libraryMgmntSystem.lms.model;



import java.util.HashSet;
import java.util.Set;

public class User {
  
  int id;//primary key for user
  String name;
  Subscription subscription;
  String address;
  private Set<Integer> issuedBooks;//set of isbn of books issued currently
  
  public User(int id, String name, Subscription subscription, String address) {
    this.id = id;
    this.name = name;
    this.subscription = subscription;
    this.address = address;
    issuedBooks= new HashSet<Integer>();
  }
  
  
  //TODO get issued Books list from the user
  
  public int getNumberOfIssuedBooks()
  {
    return issuedBooks.size();
  }
  
  
  public int getId() {
    return id;
  }



  public String getName() {
    return name;
  }



  public Subscription getSubscription() {
    return subscription;
  }



  public String getAddress() {
    return address;
  }




  public Set<Integer> getIssuedBooks() {
    return issuedBooks;
  }




  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    User other = (User) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", subscription=" + subscription + ", address=" + address + "   issuedBooks="+issuedBooks+"]";
  }
  
  

}
