/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Comp10152_linkedlist;

/**
 *
 * @author mark.yendt
 */
public class SortedLinkedList
{

  /**
   * The Node class stores a list element and a reference to the next node.
   */
  private class Node
  {
    String value;
    Node next;

    /**
     * Constructor.
     *
     * @param val The element to store in the node.
     * @param n The reference to the successor node.
     */
    Node(String val, Node n)
    {
      value = val;
      next = n;
    }

    /**
     * Constructor.
     *
     * @param val The element to store in the node.
     */
    Node(String val)
    {
      // Call the other (sister) constructor.
      this(val, null);
    }
  }
  private Node first;  // list head

  /**
   * Constructor.
   */
  public SortedLinkedList()
  {
    first = null;
  }

  /**
   * The isEmpty method checks to see if the list is empty.
   *
   * @return true if list is empty, false otherwise.
   */
  public boolean isEmpty()
  {
    return first == null;
  }

  /**
   * The size method returns the length of the list.
   *
   * @return The number of elements in the list.
   */
  public int size()
  {
    int count = 0;
    Node p = first;
    while (p != null) {
      // There is an element at p
      count++;
      p = p.next;
    }
    return count;
  }

  /**
   * The add method adds currently adds an item to the end of the list
   * 
   * MODIFY : Modify the code to place the item into the correct position based on alphabetical order
   * 
   * @param element The element to add to the list.
   */
  public void add(String element)
  {
    Node newNode = new Node(element);
    if (first == null)
      first = newNode;
    else
    {
      // Find the predecessor of the element to add
      Node current = first;
      Node prev = null;
      while (current != null) {
        prev = current;
        current = current.next;
      }
      // New last element 
      if (current == null) 
        prev.next = newNode;
      else if (prev == null)
      {
            newNode.next = first;
            first = newNode;
      }
    }
  }

  /**
   * The toString method computes the string representation of the list.
   *
   * @return The string form of the list.
   */
  public String toString()
  {
    StringBuilder strBuilder = new StringBuilder();

    // Use p to walk down the linked list
    Node p = first;
    while (p != null) {
      strBuilder.append("[" + p.value + "]");
      p = p.next;
    }
    return strBuilder.toString();
  }

  /**
   * The remove method removes an element.
   * 
   * MODIFY : You need to remove and shift elements here 
   * 
   * @param element The element to remove.
   * @return true if the remove succeeded, false otherwise.
   */
  public boolean remove(String element)
  {
     // See Lecture Notes to complete 
     return false;
  }
  
}