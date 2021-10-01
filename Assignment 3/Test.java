
/**
 * A class used to test the methods in the Stack class to create stack arrays of Lego objects that will be pushed and popped with  
 * dynamic memory expanding the array as blocks are added and shrinking the array as blocks are removed.  
 * 
 * @author Sonny Smith
 * @version 10/01/21
 */
public class Test
{
   public static void main(String[] args)
   {
    Stack obj1 = new Stack(new Lego("Red") );
        obj1.printHeight();
       
    System.out.println(obj1.push(new Lego("Green")) ); //Adds a green block to the stack
    System.out.println(obj1.push(new Lego("Blue")) );  //Adds a blue block to the stack
        obj1.printHeight(); //Prints the height of the stack before popping
        obj1.printTop();    //Prints the value of the top variable before popping
        obj1.printStack();  //Prints the contents of the stack before popping 
   
    System.out.println("\nTime to pop the stack!");
  
    System.out.println(obj1.pop() );
    System.out.println(obj1.pop() );
    System.out.println(obj1.pop() );
        obj1.printHeight(); //Prints the height of the stack after popping
        obj1.printTop();    //Prints the value of the top variable after popping
        obj1.printStack();  //Prints the contents of the stack after popping
    
    Stack obj2 = new Stack(); //Creates an empty stack to test for the underflow error
    System.out.println("\nTime to pop the new empty stack!");
    System.out.println(obj2.pop() );
   
   
   }
}
