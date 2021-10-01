
/**
 * A class that will be used to create stack arrays of Lego objects and will dynamically resize the arrays as Legos are added or removed.
 *
 * @author Sonny Smith
 * @version 10/01/21
 */
public class Stack
{
    
    private Lego[] stack; //The stack array that will be storing Lego blocks
    private int size;     //The size of the stack
    private int top;      //The top block of the stack that is the most recent entry
    
     public Stack() //Default constructor that creates an empty stack
    {
      top = - 1;
      size = 0;
      this.stack = new Lego[0];
    }
    
    public Stack(Lego lego1) //Constructor for a stack that contains a single Lego object
    {
      size = 1;
      top = 0; 
      this.stack = new Lego[size];
      this.stack[0] = lego1;
    }

    public boolean push(Lego block) // Adds a new Lego block to the stack but does not test for overflow
    {                               // because the array will expand to accommodate the new block
     
      top += 1; //Increments the top variable to match the latest index
      
      Lego[] newStack = new Lego[size + 1]; //Creates a larger array to store the legos 
            
      for(int i = 0; i < size + 1; i++)
         { 
             
         if(i < top)   //Keeps all blocks below the top the same
           {
             newStack[i] = this.stack[i]; 
           }
           else //Pushes the new block the top 
           {
             newStack[top] = block;
           }
           
         }
            stack = newStack; //Saves the changes that were made to the stack
            size += 1; //Increments the size variable to match the new size
            return true;
    }
     
    public String pop() //Outputs the top block of the stack and then removes it from the stack
    {
      if(top == -1) //Tests for empty stack to prevent the underflow error
      {
         System.out.println("\nCannot Pop An Empty Stack!");
         return null;
      }
      else
      {
        int topLocation = top; //Saves the location of the top block
        Lego poppedStack = stack[top]; //Saves the popped block 
        top -= 1;   //Decrements the top value
        
        Lego[] newStack = new Lego[size - 1]; //Creates a smaller array to store the blocks 
        
          for(int i = 0; i < size - 1; i++) //Places the non-popped blocks in the new array 
             {
           
             if(i < topLocation) //Keeps all blocks before the popped block the same
              {
                newStack[i] = this.stack[i]; 
              }
             else if(i >= topLocation) //Replaces the popped block with the succeeding block and then shifts all other blocks up 1          
             {
               newStack[i] = this.stack[i + 1]; 
             }
             
             }
           stack = newStack; //Saves the changes that were made to the stack
           size -= 1;       //Decrements the size value to represent the smaller array     
           return poppedStack.getColor(); //Outputs the color of the popped block that was saved
      }

    }
  
    public int getHeight() // Retrieves the height of the stack array
    {
        
        int height = this.stack.length;
        return height;
    }
    
    public void printHeight() // Prints the height of the stack array
    {
        System.out.println("\nThe height of the stack is : " + getHeight() );
    }
    
    public int getTop()  //Gets the value of the top variable
    {
        
        int topOut = this.top;
        return topOut; 
    }
   
    public void printTop() // Prints the top value of the stack array
    {
        System.out.println("\nThe top of the stack is : " + getTop() );
    }
    
    public void printStack() //Ouputs the colors of all the blocks on the stack without popping them. 
    {
        
        System.out.println("\nThe blocks on the stack are: "); 
        for(int i = 0; i < getHeight(); i++)
        {
            System.out.println(stack[i].getColor() );
        }    
    }
    
    
}
