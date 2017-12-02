package designProblems.libraryMgmntSystem.lms.model;

import java.util.HashMap;
import java.util.Map;

import designProblems.libraryMgmntSystem.lms.util.Constants;



/*
 * Any new subscription has to be added here as new Enum
 */
public enum Subscription {
  
  Monthly(Constants.MONTH_SUBSCRIPTION_DAYS,Constants.MONTH_SUBSCRIPTION_PRICE,Constants.MONTH_BOOKS_MAXLIMIT,Constants.MONTH_SUBSCRIPTION_NAME),
  Annual(Constants.ANNUAL_SUBSCRIPTION_DAYS,Constants.ANNUAL_SUBSCRIPTION_PRICE,Constants.ANNUAL_BOOKS_MAXLIMIT,Constants.ANNUAL_SUBSCRIPTION_NAME),
  Weekly(Constants.WEEK_SUBSCRIPTION_DAYS,Constants.WEEK_SUBSCRIPTION_PRICE,Constants.WEEK_BOOKS_MAXLIMIT,Constants.WEEK_SUBSCRIPTION_NAME),;


  private int days;
  private int price;
  private int maxLimitBooks;
  private String name;
  private static Map<String,Subscription> nameLookUpMap= new HashMap<String,Subscription>();//will contain mapping of subscription name -> Subscription Enum
  
  static
  {
    for(Subscription sub: Subscription.values())
    {
      nameLookUpMap.put(sub.getName(), sub);
    }
  }
  
  private Subscription(int days, int price, int maxLimit, String name)
  {
    this.days=days;
    this.price=price;
    this.maxLimitBooks=maxLimit;
    this.name= name;
  }

  public String getName() {
    return name;
  } 
  
  public int getDays() {
    return days;
  }

  public int getPrice() {
    return price;
  }

  public int getMaxLimitBooks() {
    return maxLimitBooks;
  }
  
  public static Subscription getSubscription(String name)
  {
    return nameLookUpMap.get(name.toUpperCase());
  }
  
  

}
