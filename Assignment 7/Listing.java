
/**
 * A class that will keep track of student information including their name, gpa, and unique ID. This class also includes methods that
 * will be used to store, access, modify, and output the information.
 * 
 *
 * @author Sonny Smith
 * @version 11/07/21
 */
public class Listing
{
    private String name;
    private double gpa;
    private int id;

    
    private Listing(String n, double g ,int i)//A constructor that is used for Deep Copies
    {
        name = n;
        gpa = g;
        id = i;
    }

    public Listing(String n, double g)//Have preprocess generate and set the id
    {
      name = n;
      gpa = g;
      id = preprocess(name); //ID is generated using the preprocess algorithm
    }
    
    
    public String getKey() //Returns the keyfield which is the student's name
    {
     return this.name; 
    }
    
    public void setKey(String newKey)
    {
      this.name = newKey;
    }
    
    public void setID(int i) //Sets the id of a listing
    {
     id = i; 
    }
    
    public String toString()
    {
     return ("Name: " + this.name + " GPA: " + this.gpa + " ID: " + id);  
    }
    
    public Listing deepCopy()
    {
      return new Listing(this.name, this.gpa, this.id);
    }
    
    public int compareToIgnoreCase(String target) 
    {
        return (name.compareToIgnoreCase(target) );
    }

    public static int preprocess(String key) //A fold-shifting string conversion method that will convert string keys into integers
    {                                        // that will represent a student's unique ID
       int pseudoKey = 0;
       int n =1;
       int cn = 0;
       char c[] = key.toCharArray();
       int group = 0;
       while(cn < key.length() )
       {
        group = group << 8; 
        group = group + c[cn];
        cn++;
        if(n == 4 || cn == key.length() )
        {
        pseudoKey = pseudoKey + group;
        n = 0;
        group = 0;
        }
        n++;
        
       }
       
       return Math.abs(pseudoKey); 
    }
    
}
