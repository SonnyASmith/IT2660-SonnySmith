/**
 * A class used to test the Listing class' methods
 *
 * @author Sonny Smith
 * @version 09/07/21
 */
public class Test
{
    public static void main(String[] args)
    {
        
    Listing obj1 = new Listing(); //Creates an object of Listing using its default constructor
      
      obj1.input(); //Activates the input method to allow user input to determine the name and age. 
      
      String name1 = obj1.getName(); //Retrieves the name the user input and assigns it to a local String variable
      
      int age1 = obj1.getAge(); //Retrieves the age the user input and assigns it to a local int variable
      
      String ageString1 = obj1.toString(age1); //Uses the toString method to conver the int age to a String and assign the result to a 
                                               //local String variable
    System.out.println("Listing 1 - Their name is: " + name1 + " and Their age is: " + ageString1);  //Outputs the listing for object 1
                          
    Listing obj2 = new Listing("Zach", 16); //Creates an object of Listing using the given values for name and age
       
      String name2 = obj2.getName();   // Assigns the given name to a local String variable
      
      int age2 = obj2.getAge();          // Assigns the given age to a local int variable
    
    System.out.println("Listing 2 - Their name is: " + name2 + " and Their age is: " + age2); //Outputs the listing for object 2 
        
      obj2.setName("Zachary");   //Sets a new name for object 2
      
      obj2.setAge("17");         //Sets a new age for object 2
      
      name2 = obj2.getName();    //Gets the new name
        
      age2 = obj2.getAge();      //Gets the new age
    
    System.out.println("Listing 2 - Their new name is: " + name2 + " and Their new age is: " + age2); //Outputs the new name and age 
    
    
    
    }
    
}
