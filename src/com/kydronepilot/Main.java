package com.kydronepilot;

import java.util.HashSet;
import java.util.Random;

/**
 * Simple linked list node implementation. Contains an
 * int datatype for the value and a next pointer for
 * the next node.
 *
 * @author Michael Galliers
 *
 */
class LinkedList {
    int val;
    LinkedList next;

    /**
     * Create a node with the inputted value.
     *
     * @param val The integer value at this node.
     */
    LinkedList(int val) {
        next = null;
        this.val = val;
    }
}

/**
 * <h1>Remove Duplicates from a Linked List</h1>
 * Simple piece of code to remove duplicates integer
 * values from a linked list.
 *
 * @author Michael Galliers
 * @version 1.0
 */
public class Main {
    /**
     * Method for generating a linked list using random values
     * between 1 and 10 inclusive, with a random length between
     * 1 and 25 inclusive.
     *
     * @return The head node of the linked list.
     */
    private static LinkedList generateList() {
        Random rand = new Random();
        int size = rand.nextInt(25) + 1;
        LinkedList head = new LinkedList(rand.nextInt(10) + 1);
        LinkedList walk = head;

        for (int i = 0; i < size; i ++) {
            int rand_val = rand.nextInt(10) + 1;
            LinkedList next = new LinkedList(rand_val);
            walk.next = next;
            walk = next;
        }

        return head;
    }

    /**
     * Core function for removing duplicates from a linked list.
     *
     * @param head The head node of the list.
     */
    private static void removeDuplicates(LinkedList head) {
        // Create a hash set.
        HashSet<Integer> unique = new HashSet<>();
        // Walker for linked list.
        LinkedList walk = head;
        unique.add(head.val);
        // Walk the list, side-stepping duplicates.
        while (walk != null && walk.next != null) {
            if (! unique.contains(walk.next.val)) {
                unique.add(walk.next.val);
                walk = walk.next;
            }
            else {
                walk.next = walk.next.next;
            }
        }
    }

    /**
     * Prints out a linked list.
     *
     * @param head The head node of the linked list.
     */
    private static void printList(LinkedList head) {
        // Print out a linked list.
        LinkedList walk = head;

        while (walk.next != null) {
            System.out.print(walk.val + ", ");
            walk = walk.next;
        }
        System.out.println(walk.val);
    }

    /**
     * Executes the core functionality of the program:
     * <ul>
     *     <li>Create and print a random linked list.</li>
     *     <li>Remove duplicates and print the list again.</li>
     * </ul>
     *
     * @param args Program args (unused).
     */
    public static void main(String[] args) {
        // Generate a linked list.
        LinkedList new_list = generateList();
        // Print it out.
        printList(new_list);
        // Remove any duplicates.
        removeDuplicates(new_list);
        // Print it again.
        printList(new_list);
    }
}
