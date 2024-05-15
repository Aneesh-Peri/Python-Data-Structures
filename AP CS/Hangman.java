public class Hangman
{   public static void main(String[] args)
    {
       String HangmanString = "bit";
       String InputString = "c a i k s b t s";
       int IncorrectCounter = 0;
       
       InputString = InputString.toLowerCase();
       InputString = InputString.replace(" ", "");

       for(int i = 0; i < InputString.length(); i++)
       {
        if(HangmanString.contains(Character.toString(InputString.charAt(i))))
        {
            continue;
        }
        else
        {
            IncorrectCounter += 1;
        }
       }
    if(IncorrectCounter == 0)
    {
        System.out.println("WOW");
    }
    else if(IncorrectCounter == 1)
    {
        System.out.println("()");
    }
    else if(IncorrectCounter == 2)
    {
       System.out.println("()");
       System.out.println("[]"); 
    }
    else if(IncorrectCounter == 3)
    {
        System.out.println(" ()");
        System.out.println("=[]"); 
    }
    else if(IncorrectCounter == 4)
    {
        System.out.println(" ()");
        System.out.println("=[]="); 
    }
    else if(IncorrectCounter == 5)
    {
        System.out.println("  ()");
        System.out.println("+=[]="); 
    }
    else if(IncorrectCounter == 6)
    {
        System.out.println("  ()");
        System.out.println("+=[]=+"); 
    }
    else if(IncorrectCounter == 7)
    {
        System.out.println("  ()");
        System.out.println("+=[]=+");
        System.out.println("  []"); 
    }
    else if(IncorrectCounter == 8)
    {
        System.out.println("  ()");
        System.out.println("+=[]=+");
        System.out.println("  []"); 
        System.out.println("  /");
    }
    else
    {
        System.out.println("  ()");
        System.out.println("+=[]=+");
        System.out.println("  []"); 
        System.out.println("  /\\");   
    }
    }
}