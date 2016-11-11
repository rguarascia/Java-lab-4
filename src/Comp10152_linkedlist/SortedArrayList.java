package Comp10152_linkedlist;

/** The SimpleArrayList class is a concrete class
    for storing an ordered list of String objects.
*/

public class SortedArrayList 
{
   // Constants for the default capacity and
   // the resizing factor.
   private final int DEFAULT_CAPACITY = 10;
   private final int RESIZE_FACTOR = 2;
   
   // Private Fields
   private String[] list;  // The list
   private int elements;   // Number of elements stored
   
   /** This constructor creates an empty list of the
       default capacity.
   */
   public SortedArrayList()
   {
      list = new String[DEFAULT_CAPACITY];
      elements = 0;
   }
 
   /** Add a string to the end of the list.
       @param str The string to add. 
   */

   public void add(String str)
   {
      // MODIFY - complete code to insert item into the correct location 
      // Currently just adds to end - MUST be placed into correct location alphabetically 
      // Use the private add method to actually add the item - This does the array adjustment
      add(elements,str);  // Add to end
   }

   /** Add a string at a specific index.
       @param index The added string's position.
       @param str The string to add.
       @exception IndexOutOtBoundsException When index
                  is out of bounds.
   */   
   private void add(int index, String str)
   {
      // First make sure the index is valid.
      if (index > elements || index < 0)
         throw new IndexOutOfBoundsException();

      // If the list is full, resize it.
      if (elements == list.length)
         resize();
         
      // Shift the elements starting at index
      // to the right one position.
      for (int index2 = elements; index2 > index; index2--)
         list[index2] = list[index2 - 1];
      
      // Add the new element at index.
      list[index] = str;
      
      // Adjust the number of elements.
      elements++;
   }
   
   /** Search the list for a specified string.
       @param str The string to search for.
       @return the numeric index of the item in the list, -1 if not found 
   */
   public int indexOf(String str)
   {
      int index = 0;          // Index counter
      
      // If string is found return the psoition
      while (index < elements)
      {
         if (list[index].equals(str))
            return index;
         index++;
      }
      
      // Return -1 to indicate not found.
      return -1;
   }
   
   /** Get an element at a specific position.
       @param index The specified index.
       @return The element at index.
       @exception IndexOutOtBoundsException When index
                  is out of bounds.
   */
   public String get(int index)
   {
      if (index >= elements || index < 0)
         throw new IndexOutOfBoundsException();
      return list[index];
   }
  
   /** Determines whether the list is empty.
       @return true if the list is empty; false otherwise.
   */
   public boolean isEmpty()
   {
      return (elements == 0);
   }
   
   /** Remove a specific string from the list.
    *  @param str The string to remove.
    *  @return true if the string was found; false otherwise.
    * 
    *  MODIFY : Complete the remove - find the string and then adust contents of ArrayList
    * 
    */
   
   public boolean remove(String str)
   {
      return false; 
   }       

   /** Get the number of elements in the list.
       @return The number of elements in the list.
   */
   public int size()
   {
      return elements;
   }

   /** Resizes the list to twice its current length. */
   private void resize()
   {
      // Calculate the new length, which is the current
      // length multiplied by the resizing factor.
      int newLength = list.length * RESIZE_FACTOR;
      
      // Create a new list.
      String[] tempList = new String[newLength];
      
      // Copy the existing elements to the new list.
      for (int index = 0; index < elements; index++)
         tempList[index] = list[index];
      
      // Replace the existing list with the new one.
      list = tempList;
   }
  
   /** Convert the list to a String
       @return A String with the same elements as the list.
   */
   public String toString()
   {
    StringBuilder strBuilder = new StringBuilder();

    // Use p to walk down the linked list
      // Store the elements in the array.
      for (int index = 0; index < elements; index++)
        strBuilder.append("[" + list[index] + "]");
      
      // Return the String.
      return strBuilder.toString();
   }
}
