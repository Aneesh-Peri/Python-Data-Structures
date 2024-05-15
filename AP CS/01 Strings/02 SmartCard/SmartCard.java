//name: Aneesh Peri  date: 9/9/2023

import java.text.DecimalFormat;
import java.lang.Math;

public class SmartCard
{
   // instantiate the constants
   public final static DecimalFormat df = new DecimalFormat("$0.00");
   public final static double MIN_FARE = 0.5;
   // declare the private fields
   private double balance;
   private boolean isBoarded;
   private Station buddy;
   // write the one-arg constructor
   public SmartCard(double balance)
   {
      this.balance = balance;
      isBoarded = false;
   }
   // write four getter methods 
   public double getBalance()
   {
      return balance;
   }
   public String getFormattedBalance()
   {
      return df.format(balance);
   }
   public boolean getIsBoarded()
   {
      return isBoarded;
   }
   public Station getBoardedAt()
   {
      return buddy;
   }
    
   // write the instance methods as described in the handout
   public void board(Station s)
   {
     if(getIsBoarded() == true)
     {
       System.out.println("Error: already boarded?!");
     } 
     else if(getBalance() < 0.50)
     {
      System.out.println("Insufficient funds to board. Please add more money");
     }
     else
     {
      isBoarded = true;
      buddy = s;
     }
   }
   public double cost(Station s)
   {
      return (Math.abs(s.getZone() - buddy.getZone())*0.75) + 0.50;
   }
   public void exit(Station s)
   {
      if(!isBoarded)
      {
         System.out.println("Error: Did not board?!");
      }
      else if((getBalance() - cost(s)) < 0.00)
      {
         System.out.println("Insufficient funds to exit. Please add more money.");
      }
      else
      {  
         balance -= cost(s);
         System.out.println("From " + buddy.getName() + " to " + s.getName() + " costs " + df.format(cost(s)) + ". Balance is now " + df.format((getBalance() - cost(s))));
         isBoarded = false;
         buddy = null;
      }
      
   }
   public void addMoney(double d) 
   {
      balance = getBalance() + d;
   }

    

} 
