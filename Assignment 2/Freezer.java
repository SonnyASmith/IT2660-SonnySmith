
/**
 * A class that will store objects of the Food class in Freezer arrays and perform insertion, deletion, update, and fetch functions
 * on them. Print tools are also included to display information about the arryas including their contents. 
 * @author Sonny Smith
 * @version 09/28/21
 */
public class Freezer
{

    private Food[] myFreezer;

    public Freezer(Food food1) // Creates a new feezer array and stores the first food item
    {
        this.myFreezer = new Food[1];
        this.myFreezer[0] = food1;
    }
    
    public int getLength() // Retrieves the length of the freezer array
    {
        int length = this.myFreezer.length;
        return length;
    }
    
    public void printLength() // Prints the length of the freezer array
    {
        System.out.println("The Length of the array is : " + getLength() );
    }
    
    public void printItem(int index) // Prints a specific food item in the freezer array
    {
        if(index > this.myFreezer.length || index < 0)
        {
            System.out.println("Invalid Index");
            return;
        }
        else
        { 
        System.out.println(fetch(index).getName() );
        }
    }
    
    public void printArray() // Prints all of the food items in the freezer array
    {
        for(int i = 0; i < getLength(); i++)
        {
            System.out.println(fetch(i).getName() );
        }    
    }
    
    public Food fetch(int num) // Retrieves a food item from the freezer array
    {
        return myFreezer[num]; 
    }

    public void insert(Food newFood, int index) // Adds a new food item to the array at the specified index and expands the array
    {
       
       //Tests if the desired index is invalid 
       if(index < 0 || index > this.myFreezer.length) 
       {
            System.out.println("Invalid Index");
           return; 
       }
       
       //Adds food to an empty myFreezer array
        if(index == 0 && this.myFreezer.length ==0)
       {
         this.myFreezer = new Food[1]; //Creates a new array for the calling object to use 
         this.myFreezer[0] = newFood;  // Places the food item in the new array 
         return;
       }
       
       //Creates a larger array that previous elements are deep copied into and the new entry is added
       Food[] newFreezer = new Food[this.myFreezer.length + 1];
       
       //Finds the correct index to insert the new food into
       for(int i = 0 ; i < this.myFreezer.length + 1; i++)
       {
           
        if(i < index) //Keeps all elements that precede the target the same
        {
            newFreezer[i] = this.myFreezer[i];
        }
        else if (i > index) //Shifts all subsequent elements after the changed element down 1
        {
          newFreezer[i] = this.myFreezer[i - 1]; 
        }
        else  //Changes the target element at the speified index
        {
          newFreezer[i] = newFood; 
        }
        
          
       }
       this.myFreezer = newFreezer;//Saves the changes that were made by the insert
   
    }
    
    public void delete(int index) // Removes a food item at the specified index and shrinks the array
    {
          if(index < 0 ||  index > this.myFreezer.length || this.myFreezer.length == 0)  //Tests if the index is valid or if the target
       {                                                                                 // array is empty
           return; 
       }
       
       if(this.myFreezer.length == 1)    //Detects if the array only has one element and then sets it to be empty. 
       {
           Food[] newFreezer = new Food[this.myFreezer.length - 1];
        
         this.myFreezer = newFreezer;
           return;
       }
        //Creates a smaller array that previous elements are deep copied into after the target entry is removed
       Food[] newFreezer = new Food[this.myFreezer.length - 1];
       
       //Finds the correct food item to delete using the specified index
       for(int i = 0 ; i < this.myFreezer.length - 1; i++)
       {
       
        if(i < index) //Keeps all elements that precede the target index the same
        {
          newFreezer[i] = this.myFreezer[i];
        }
        else if (i >= index) //Replaces the target item with the one that succeeds it and then shifts all subsequent items up 1
        {
            newFreezer[i] = this.myFreezer[i + 1]; 
        }
   
       
       }
        this.myFreezer = newFreezer; //Saves the changes that were made by the deletion
    }
    
   public void update(Food newFood, int index) // Removes a food item at the specified index and then replaces it with a new item 
   {                                           
        delete(index);
        insert(newFood, index); 
   }

}
