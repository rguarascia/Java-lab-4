/**
 * COMP10152 - Lab#4 Solution
 * 
 * Discuss the results here : see questions in Lab
 * 
 * 
 * 
*/
package Comp10152_linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Comp10152_Lab4_Start
{
  /** DO NOT MODIFY THIS CODE - It should be left as is. */
    
  public static void main(String[] args)
  {
    int NUMBER_OF_NAMES = 2000;  // Must be set to between 0 and 2000
    final String filename = "resources/names.txt";
    final String[] names = new String[NUMBER_OF_NAMES];
    
    // Read in all of the names - there are 2000 different names
    try {
      Scanner fin = new Scanner(new File(filename));
      int i=0;
      for (i=0; i<NUMBER_OF_NAMES && fin.hasNext(); i++)
          names[i] = fin.next();
      fin.close();
      NUMBER_OF_NAMES = i;
    } 
    catch (FileNotFoundException e) 
    {
      System.out.println("Exception caught: " + e.getMessage());
      System.exit(-1);
    }

    System.out.printf("Comp10152 - Lab#4 - ArrayList vs LinkedList\n\n");
    Random random = new Random();
    SortedArrayList al = new SortedArrayList();
    
    long start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES;i++)
         al.add(names[i]);    // MODIFY add method in ArrayList
    System.out.printf("The time required to add %d elements to an Array List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);
   
    // remove half of the items in the list by selecting randomly from names
    start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES/2;i++)
      al.remove(names[random.nextInt(names.length)]); // MODIFY remove method in ArrayList
    System.out.printf("The time required to remove %d elements from an Array List = %d us\n", NUMBER_OF_NAMES/2, (System.nanoTime() - start) / 1000);
    
    // Use the system build LinkedList class
    SortedLinkedList ll = new SortedLinkedList();
    start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES;i++)
        ll.add(names[i]);  // MODIFY add method in LinkedList
    
    System.out.println(ll);
    System.out.printf("The time required to add %d elements to a Linked List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);
    
    // remove half of the items in the list by selecting randomly from names
    start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES/2;i++)
    {
      ll.remove(names[random.nextInt(names.length)]); // MODIFY remove method in LinkedList
    }
    
    System.out.printf("The time required to remove %d elements from a Linked List = %d us\n", NUMBER_OF_NAMES/2, (System.nanoTime() - start) / 1000);
    
    // Use the Built-in ArrayList in Java 
    // Note that a Sort is required after each insert 
    // To acheive the alwasy sorted case 
    
    ArrayList<String> builtInArrayList = new ArrayList<String>();
    
    start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES;i++)
    {
         builtInArrayList.add(names[i]);    // MODIFY add method in ArrayList
         Collections.sort(builtInArrayList);
    }
    System.out.printf("The time required to add %d elements to a Java Array List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);
   
    // remove half of the items in the list by selecting randomly from names
    start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES/2;i++)
      builtInArrayList.remove(names[random.nextInt(names.length)]); // MODIFY remove method in ArrayList
    System.out.printf("The time required to remove %d elements from a Java Array List = %d us\n", NUMBER_OF_NAMES/2, (System.nanoTime() - start) / 1000);

    // Use the Built-in LinkedList in Java 
    // Note that a Sort is required after each insert 
    // To acheive the alwasy sorted case 
    
    LinkedList<String> builtInLinkedList = new LinkedList<String>();
    
    start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES;i++)
    {
         builtInLinkedList.add(names[i]);    // MODIFY add method in ArrayList
         Collections.sort(builtInLinkedList);
    }
    System.out.printf("The time required to add %d elements to a Java Linked List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);
   
    // remove half of the items in the list by selecting randomly from names
    start = System.nanoTime();
    for (int i=0; i<NUMBER_OF_NAMES/2;i++)
      builtInLinkedList.remove(names[random.nextInt(names.length)]); 
    System.out.printf("The time required to remove %d elements from a Java Linked List = %d us\n", NUMBER_OF_NAMES/2, (System.nanoTime() - start) / 1000);
  }   
}
