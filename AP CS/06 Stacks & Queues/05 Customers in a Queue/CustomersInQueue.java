//name:    date:

import java.util.*;
import java.io.*;
public class CustomersInQueue
{
   public static final double CHANCE_OF_CUSTOMER = 0.8; // 
  
   public static void outfileServiceAreasAndQueue(PrintWriter outfile, int min, Customer[] atServiceWindow, Queue<Customer> queue)
   { 
      outfile.print(min + ": ");
      for(Customer c : atServiceWindow)
         if( c != null )
            outfile.print(c.toString()+" ");
      outfile.println("" + queue);
   }
  
   public static double calculateAverage(int totalMinutes, int customers)
   {
      return (1.0 * totalMinutes/customers * 10)/10.0;
   }
   public static void showMe(int arg)
   {
       if(arg<10)
       {
           showMe(arg+1);
       }
       else
       {
           System.out.print(arg+" ");
       }
   }


   public static PrintWriter setUpFile()
   {
      PrintWriter outfile = null; 
      try
      {
         outfile = new PrintWriter(new FileWriter("customersSimulation.txt"));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
      return outfile;
   }
            
   public static void main(String[] args)
   {     
      PrintWriter outfile = setUpFile();
      showMe(0);
      System.out.println("Customers in a Queue Simulation! ");
      Scanner kb = new Scanner(System.in);
      System.out.print("How many service areas? ");
      int sa = kb.nextInt();
      System.out.print("How long, in minutes, should the simulation run? ");
      int time = kb.nextInt();
      
      serveTheCustomers(time, sa, outfile);  //run the simulation
   }
   
   public static void serveTheCustomers(int time, int number_of_serviceAreas, PrintWriter outfile)
   {
       System.out.println(4+6%12/4);
      /***************************************
        call outfileTimeAndQueue() to store the queue to the file.  
        **********************************/
        int min = 0;
        int waitTime = 0;
        int CustomerCount = 0;
        int Longestqueue  = 0;
        int longestWaitTime = 0;
        int minutesCounter = 0;
        
        Queue<Customer>q = new LinkedList<>();
        Customer[] atServiceWindow = new Customer[number_of_serviceAreas];
        boolean done = false;
        while(min < time || !q.isEmpty() || !done)
        {
         min++;
         int Value = (int)(Math.random() * 7 + 2);
         if(Math.random() < CHANCE_OF_CUSTOMER && min < time) 
         {
            q.add(new Customer(Value,min));
            CustomerCount++;
            minutesCounter += Value;
         }
         done = true;
         
         for(int i = 0; i < atServiceWindow.length; i++)
         {
            if(atServiceWindow[i] == null && !q.isEmpty())
            {
               atServiceWindow[i] = q.remove();
               done = false;  
            }
            
            
            else if(atServiceWindow[i] != null)
            {
               atServiceWindow[i].serve(); // write serve method
               waitTime = min - atServiceWindow[i].getAT();
               
               if(atServiceWindow[i].getST() == 0)
               {
                  minutesCounter += waitTime;
                  if(longestWaitTime < waitTime)
                     longestWaitTime = waitTime;
                  atServiceWindow[i] = null;
               }
                  
               else done = false;
            }
         }
            outfileServiceAreasAndQueue(outfile,min,atServiceWindow,q);
             if(q.size() > Longestqueue)
            {  
               Longestqueue = q.size();
            }
            
            
         }
         System.out.println("Total customers served = " + "" + CustomerCount);
            System.out.println("Average wait time = " + "" + calculateAverage(minutesCounter,CustomerCount));
            System.out.println("Longest wait time = " + "" + longestWaitTime);
            System.out.println("Longest queue = " + "" + Longestqueue);
         
         outfile.close();        
   }

   
   
   static class Customer      
   {
     int serviceTime;
     int arrivalTime;
     
     public Customer(int servicetime, int a)
     {
         serviceTime = servicetime;
         arrivalTime = a;
     }
     
     public int getST()
     {
         return serviceTime;
     }
     public int getAT()
     {
         return arrivalTime;
     }
     public void serve()
       {
        serviceTime--;
       }
     
     public String toString()
       {
           return serviceTime + "";
       }

   }
}

/******************************************************
 Customers in a Queue Simulation! 
 How many service areas? 4
 How long, in minutes, should the simulation run? 60
 Total customers served = 33
 Average wait time = 9.6
 Longest wait time = 16
 Longest queue = 11

****************************************************/
