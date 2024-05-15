// Name:    
 // Date: 
 
import java.util.*;
 
interface PolynomialInterface
{
   public void makeTerm(Integer exp, Integer coef);
   public Map<Integer, Integer> getMap();
   public double evaluateAt(double x);
   
   //precondition: both polynomials are in standard form
   //postcondition: terms with zero disappear. If all terms disappear (the size is zero), 
   //               add pair (0,0).
   public Polynomial add(Polynomial other);
   
   //precondition: both polynomials are in standard form
   //postcondition: terms with zero disappear. If all terms disappear (the size is zero), 
   //               add pair (0,0)
   public Polynomial multiply(Polynomial other);
   public String toString();
}
 
class Polynomial implements PolynomialInterface
{  
   Map<Integer, Integer> map = new TreeMap<Integer,Integer>(); 
   public void makeTerm(Integer exp, Integer coef)
   {
      map.put(exp,coef);
   }
   public Map<Integer, Integer> getMap()
   {
      return map;
   }
   public Polynomial add(Polynomial other)
   {  
      int mapMax = 0;
      int otherMax = 0;
      int newCoef = 0;
      Polynomial finale = new Polynomial();
      for(Integer max1:  map.keySet())
      {  
         if(max1>mapMax)
         {
            mapMax = max1;
         }
         
      }
      for(Integer max2: other.map.keySet())
      {
         if(max2 > otherMax)
         {
            otherMax = max2;
         }  
      }
      int maxer = Math.max(mapMax,otherMax);
      for(int i = 0; i  <= maxer;  i++)
      {
         if(map.containsKey(i)&&(!other.map.containsKey(i)))
         {
            finale.map.put(i,map.get(i));
         }
         
         else  if(!map.containsKey(i)&&(other.map.containsKey(i)))
         {
            finale.map.put(i,other.map.get(i));
         }
         else if(map.containsKey(i)&&other.map.containsKey(i))
         {  
            newCoef = map.get(i) + other.map.get(i);
            if(newCoef!=0)
            {
               finale.map.put(i,newCoef);
            }
         }
         else if(map.get(i)==other.map.get(i))
         {
            continue;
         }
      }
      return finale;
   }
   public Polynomial multiply(Polynomial other)
   {  
      int exp = 0;
      int coef = 0;
      Polynomial finale = new Polynomial();
      for(Integer exp1: map.keySet())
         for(Integer exp2: other.getMap().keySet())
         {  
            exp = exp1 + exp2;
            coef = map.get(exp1) * other.map.get(exp2);
            if(!finale.map.containsKey(exp))
            {
               finale.map.put(exp,coef);
            }  
            else
            {  
               if(finale.map.get(exp)+coef==0)
               {
                  finale.map.remove(exp);
               }
               else
               {
                  finale.map.put(exp,finale.map.get(exp)+coef);
               }
            }
            
         }
      return finale;
         
   }
   public double evaluateAt(double x)
   {
      double value = 0.0;
      for(Integer key: map.keySet())
      {
         value = value + ((Math.pow(x,key) * map.get(key)));
      }
      return value;
   }  
   public String toString()
   {  
      String finale = "";
      for(Integer val: map.keySet())
      {
          if(val==0)
          {
            finale = map.get(val) + " + " + finale;
          }
          else if(val==1)
          {
             if(map.get(val)==1)
             {
               finale = "x" + " + " + finale;
             }
             else
             {
               finale = map.get(val) + "x + " + finale;
             } 
          }
          else if(map.get(val)==1)
          {
            finale = "x^"+ val + " + " + finale;
          }
          else if(map.get(val)==-1)
             {
               finale = "-x^" + val + " + " + finale;
             }
          else
          {
            finale = map.get(val)+"x^"+val + " + " + finale;
          }
      }
      if(finale.equals(""))
      {
         return "0";
      }
      else if(finale.length()<=3)
      {
         return finale;
      }
      else
      {
         return finale.substring(0,finale.length()-3);
      }
      
   }
}