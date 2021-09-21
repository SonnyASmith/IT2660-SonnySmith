 /**
 * A class used to list the name and age of an individual. 
 * 
 * @author Sonny Smith
 * @version 09/07/21
 */
 import java.util.Scanner; 
 public class Listing
 {
    private String name;
    private int age;
  
    public Listing() //Default Constructor
    {
      name = " "; 
      age = 0;
    }

    public Listing(String newName, int newAge) //Constructor
    {
      name = newName;
      age = newAge;
    }
  
    public void input()  //Prompts users to input a name and age
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Input a name: ");
        
        setName(keyboard.nextLine());
        
        System.out.println("Input an age: ");
        
        setAge(keyboard.nextLine());
    }
    
    public void setName(String newName) //Sets the name
    {
        name = newName;
    }
    
    public void setAge(String newAge) //Sets the age
    {
       age = Integer.parseInt(newAge); 
    }
    
    public String getName()  //Gets the name
    {
      return name;   
    }
    
    public int getAge() //Gets the age
    {
      return age;
    }
     
    public String toString(int num) //Converts an integer age to a String
    {                               
        return "" + num; 
    } 
    
 }
