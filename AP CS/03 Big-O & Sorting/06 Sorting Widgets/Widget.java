// Name:
// Date: 

public class Widget implements Comparable<Widget>
{
   //fields
   private int cubits;
   private int hands;
   //constructors
   public Widget(int a, int b)
   {
       cubits = a;
       hands = b;
   }
   public Widget(Widget wid)
   {
       this.cubits = wid.getCubits();
       this.hands = wid.getHands();
   }
   public Widget()
   {
       cubits = 0;
       hands = 0;
   }
   //accessors and modifiers
   public int getCubits()
   {
       return cubits;
   }
   public int getHands()
   {
       return hands;
   }
   public void setCubits(int cubit)
   {
       this.cubits = cubit;
   }
   public void setHands(int hand)
   {
       this.hands = hand;
   }
   //compareTo(Widget) and equals(Widget)
   public int compareTo(Widget finalWid)
   {
       return(this.cubits - finalWid.cubits) + (this.hands - finalWid.hands);
   }
   public boolean equals(Widget finalWid)
   {
       return (this.cubits == finalWid.getCubits()) && (this.hands == finalWid.getHands());
   }
   //toString
   public String toString()
   {
       return this.cubits+" cubits "+this.hands+" hands";
   }
}
