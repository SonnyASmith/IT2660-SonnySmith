
/**
 * A class that will recursively sort sublists into a single sorted list using the Top-Down approach. 
 *
 * @author Sonny Smith
 * @version 10/24/21
 */
public class MergeSort
{
    private int[] numBank;  //The main list that will store the unsorted numbers and then the numbers after they are sorted
    private int[] temp;    //The temporary list that will be used to sort the numbers
    private int left;     //The left index of the list
    private int right;   //The right index of the list
    private int size;   //The size of the list
  
    public MergeSort(int[] list)
    {
      numBank = list;
      size = list.length;
      left = 0;
      right = size - 1;
      temp = new int[size];
      
    }
  
    public void sort() //Method that initiates the sorting algorithm using initiated variables from the constructor
    {
      sort(this.numBank, this.temp, this.left, this.right);
    }
    
       //Method that takes the sorted lists of numbers and merges them into a single merged list
    public static void sort(int[] list, int[] temp, int leftIndex, int rightIndex)
    {
        int midIndex, total;
        
        total = rightIndex - leftIndex + 1;
        if(total == 1) //Base Case: A list of no elements or a single element is already sorted
         { 
           return; 
         } 
  
       midIndex = (rightIndex + leftIndex) / 2;

       sort(list, temp, leftIndex, midIndex); //Reduced problem 1: Sorts the left half of the list
       sort(list, temp, midIndex + 1, rightIndex);//Reduced Problem 2: Sorts the right half of the list

        merge(list, temp, leftIndex,  midIndex + 1, rightIndex);//General Solution: sorted lists can be merged into a single sorted list
        return;
        
    }
    
    public static void merge(int[] list, int[] temp, int leftIndex, int midIndex, int rightIndex)
    { int leftEnd, total, tempIndex;
      leftEnd = midIndex - 1; //The end of the left sublist
      tempIndex = leftIndex;  //Synchronizes the indicies of list and temp
      total = rightIndex - leftIndex + 1; 

      while( (leftIndex <= leftEnd) && (midIndex <= rightIndex) ) //Sorts the list 
      {
          if(list[leftIndex] <= list[midIndex]) //If the element is less than the rightmost element then it is kept at the same index
          {                                     //in the left sublist
              temp[tempIndex] = list[leftIndex];

              tempIndex++;
              leftIndex++;                
          }
          else //If the element is greater than the the rightmost item then it takes the items place in the right sublist
          {    // and shifts the middle index
              temp[tempIndex] = list[midIndex];

              tempIndex++;
              midIndex++;
          }
            
        }
              
      if(leftIndex <= leftEnd)  //Copies the remainder of the left sublist into the temp list if there are still elements present
        {
        while(leftIndex <= leftEnd) 
          {
              temp[tempIndex] = list[leftIndex];
              leftIndex++;
              tempIndex++;
          }
        }
        else 
        {
          while(midIndex <= rightIndex) //Copies the remainder of the right sublist into the temp list
           {
             temp[tempIndex] = list[midIndex];
                
             midIndex++;
             tempIndex++;
           }
         }
     
         for (int i = 0; i < total; i++) //Copies the changes that were made from temp into the list
         {
              list[rightIndex] = temp[rightIndex];
              rightIndex--;
         }
    }

    public void printList() //Prints the contents of the list
    {
      
      if(numBank.length == 0)
      {
        return;
      }
      else
      {
      System.out.println("\nThe contents of numBank are: ");
        for(int i = 0; i < numBank.length; i++)
      {
        System.out.println(numBank[i]);
      }
      System.out.println("~~~~~End of list~~~~~");
      }
      
    }
    
    public void printLength() //Prints the length of the list
    {
        System.out.println("The length of numBank is: " + numBank.length); 
    }
    
}
