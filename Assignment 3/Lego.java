
/**
 * A class used to create Lego objects of different colors that will be stored in the stack array.
 *
 * @author Sonny Smith
 * @version 10/01/21
 */
public class Lego
{
    private String color;
    
    public Lego(String color) //Creates a Lego block with a color
    {
       this.color = color;
      
    }

    public String getColor() //Gets the color of a specific block
    {
        return this.color; 
    }

}
