import java.util.Random;
import java.util.Scanner;

/**
 * Recursion class provides size recursive methods for lab 13.
 * 
 * @author Jonathan Ward
 * 
 */
public class Recursion
{

    private Random rand;
    private Scanner scan;

    /**
     * Constructor initializes the fields.
     */
    public Recursion()
    {
        rand = new Random();
        scan = new Scanner(System.in);

    }

    /**
     * Given a reference to an int Node (the same kind of Node class we have
     * studied this semester with getData() and getLink() methods, prints the
     * list in reverse.
     * 
     * @param front
     *            : a reference to the Node in a list
     * 
     * @postcondition the list, from this Node to the end, is printed in reverse
     *                order with one space between each pairs of integers.
     * 
     */
    public void printInReverse(Node front)
    {
        if (front == null)
        {
            return;
        }
        if (front.getLink() != null)
        {
            printInReverse(front.getLink());
        }



        System.out.print(front.getData() + " ");
    }

    /**
     * Given a positive integer, finds and returns the largest digit in the
     * integer.
     * 
     * @param num
     *            : the integer to examine
     * 
     * @return the largest digit in the integer num
     * 
     */
    public int findLargestDigit(int num)
    {
        /**
         * Base case, if value is 0 then return 0
         */
        if (num == 0)
        {
            return 0;
        }
        /**
         * modding a number by 10 will return the value we need
         * while dividing a number by 10 will give us the next spot
         * of the number to recursively go through.
         */
        return Math.max(num % 10,  findLargestDigit(num / 10));

    }

    /**
     * Given a nonnegative integer, returns the number of ones in the binary
     * representation of the number.
     * 
     * @param num
     *            : the integer
     * 
     * @return the number of ones in the binary representation of num
     * 
     */
    public int countOnesInBinary(int num)
    {
        if (num == 0)
        {
            return 0;
        }
        else if (num == 1)
        {
            return 1;
        }
        else
        {
            return countOnesInBinary(num / 2) + countOnesInBinary(num % 2);
        }

    }

    /**
     * Prints instructions on how to solve a Towers of Hanoi problem.
     * 
     * @param numDisks
     *            number of discs to move
     * @param fromTower
     *            char name of starting tower
     * @param toTower
     *            char name of finishing tower
     * @param tempTower
     *            char name of intermediate tower
     * @postcondition - prints instructions for how to play with one command per
     *                line in the following format: �[A|B|C] to [A|B|C]\n�
     */
    public void towersOfHanoi(int numDisks, char fromTower,
        char toTower, char tempTower)
    {

        if (numDisks == 1)
        {
            System.out.println(fromTower + " to " + toTower);
        }
        else 
        {
            towersOfHanoi(numDisks - 1, fromTower, tempTower, toTower);
            System.out.println(fromTower + " to " + toTower);
            towersOfHanoi(numDisks - 1, tempTower, toTower, fromTower);
        }

    }

    /**
     * Given positive integer a, and non-negative integer b, computes a to the
     * power of b.
     * 
     * 
     * @param a
     *            positive base
     * @param b
     *            the exponent
     * 
     * @return a to the power of b
     * 
     */
    public int pow(int a, int b)
    {

        if (a < 0)
        {
            throw new IllegalArgumentException("Only positive bases");
        }
        if (b == 0)
        {
            return 1;
        }
        else
        {
            return a * pow(a, b - 1);
        }


    }

    /**
     * Given two positive integers, n and k, n >= k, computes C(n,k).
     * 
     * @param n
     *            size of the set
     * @param k
     *            size of the subsets
     * 
     * @return the number of subsets of size 'k' within a set of size 'n'
     * 
     */
    public int pascalsTriangle(int n, int k)
    {
        if (k == 0)
        {
            return 1;
        }
        else if (k == n)
        {
            return 1;
        }
        else
        {
            return pascalsTriangle(n - 1, k - 1) + pascalsTriangle(n - 1, k);
        }


    }

    /**
     * A method to help you test the findLargestDigit method.
     */
    public void testFindLargestDigit()
    {
        System.out.println("FIND THE LARGEST DIGIT TEST:");
        System.out.print("Enter an integer of your choice: ");
        int choice = scan.nextInt();
        int yourAnswer = findLargestDigit(choice);
        System.out.println("Your method says the largest digit in "
            + choice + " is " + yourAnswer);
        System.out.println("\nENDING FINDING THE LARGEST DIGIT TEST.\n\n");
    }

    /**
     * A method to help you test the countOnesInBinary method.
     */
    public void testBinaryOnes()
    {
        System.out.println("\n\nTESTING COUNT ONES IN BINARY NUMBER\n");
        System.out.print("Enter an integer in decimal: ");
        int choice = scan.nextInt();
        System.out.printf("In hexadecimal, that is %x\n", choice);
        System.out.println("Your method says " + choice
            + " in binary has " + countOnesInBinary(choice) + " ones.");
        System.out.println("\nENDING TEST COUNTING THE ONES IN BINARY\n\n");

    }

    /**
     * A method to help you test the towersOfHanoi method.
     */
    public void testTowersOfHanoi()
    {
        System.out.println("\n\nTESTING TOWERS OF HANOI\n");
        System.out.print("How many discs: ");
        int numDisks = scan.nextInt();
        if (numDisks > 20)
        {
            System.out.println("Hope you are a patient person.");
        }
        towersOfHanoi(numDisks, 'A', 'B', 'C');
        System.out.println("\n\nEND TESTING TOWERS OF HANOI\n");
    }

    /**
     * A method to help you test the pow method.
     */
    public void testPow()
    {
        System.out.println("\n\nTESTING POWER METHOD\n");
        System.out.print("Enter two small positive integers, separated by a "
            + "space: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int answer = pow(num1, num2);
        System.out.println("Your method says that " + num1
            + " raised to the " + num2 + " power is " + answer);

        System.out.println("\n\nEND TESTING  OF POW\n");

    }

    /**
     * A method to help test the pascalsTriangle method.
     */
    public void testPascalsTriangle()
    {
        System.out.println("\n\nTESTING PASCAL'S TRIANGLE\n");
        System.out.print("Enter two positive integers x and y, x >= y : ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int answer = pascalsTriangle(num1, num2);
        System.out.println("Your method says  " + num1 + " choose "
            + num2 + " is " + answer);
        System.out.println("\n\nEND TESTING OF PASCAL'S TRIANGLE\n");
    }

    /**
     * A method to help you test the printInReverse method.
     */
    public void testLinkedListReversal()
    {
        int howMany;
        Node list;
        System.out.println("LINKED LIST REVERSAL TEST:");
        System.out.print("How many random values do you want: ");
        howMany = scan.nextInt();
        list = makeAList(howMany);
        System.out.println("Here is the list: ");
        printInOrder(list);
        System.out.println("\nList in reverse, according to your method: ");
        printInReverse(list);
        System.out.println("\nENDING LINKED LIST REVERSAL TEST.\n\n");
    }

    /**
     * A helper method for the testLinkedListReversal method to create a linked
     * list.
     * 
     * @param howManyNodes
     *            the number of nodes to generate in the list.
     * @return the head of the list of nodes.
     */
    public Node makeAList(int howManyNodes)
    {
        Node front = null;
        for (int i = 0; i < howManyNodes; i++)
        {
            front = new Node(rand.nextInt(100) + 1, front);
        }
        return front;
    }

    /**
     * A helper method for the testLinkedListReversal method to print the list
     * in order.
     * 
     * @param front
     *            the head of the list of nodes.
     */
    public void printInOrder(Node front)
    {
        if (front != null)
        {
            System.out.print(front.getData() + " ");
            printInOrder(front.getLink());
        }
    }

    /**
     * A helper method for the test program to read user input and perform test.
     */
    public void test()
    {
        int choice = menu();
        while (choice != 7)
        {
            switch (choice)
            {
                case 1:
                    testLinkedListReversal();
                    break;
                case 2:
                    testFindLargestDigit();
                    break;
                case 3:
                    testBinaryOnes();
                    break;
                case 4:
                    testTowersOfHanoi();
                    break;
                case 5:
                    testPow();
                    break;
                case 6:
                    testPascalsTriangle();
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
            choice = menu();
        }
    }

    /**
     * A helper method for the test program to print the menu and query the
     * user.
     * 
     * @return The menu selection by the user.
     */
    public int menu()
    {
        int choice;

        System.out
        .println("**************************************************");
        System.out.println("           Recursion Methods  ");
        System.out
        .println("**************************************************");
        System.out.println("       1.  Print a Linked List in Reverse Order ");
        System.out.println("       2.  Find the Largest Digit");
        System.out.println("       3.  Count ones in a binary number");
        System.out.println("       4.  Towers of Hanoi");
        System.out.println("       5.  a to the b Power");
        System.out.println("       6.  Pascal's Triangle");
        System.out.println("       7.  Quit ");
        System.out
        .println("**************************************************");

        System.out.print("\n\nEnter your choice: ");
        choice = scan.nextInt();

        return choice;
    }

    /**
     * A simple Node class for creating the the linked lists.
     * 
     * @author ???
     * @version ???
     */
    public static class Node
    {
        int data;
        Node link;

        /**
         * Constructor takes in data and a link.
         * 
         * @param theData
         *            the data for the node.
         * @param theLink
         *            the next node in the list.
         */
        Node(int theData, Node theLink)
        {
            data = theData;
            link = theLink;
        }

        /**
         * @return the data.
         */
        public int getData()
        {
            return data;
        }

        /**
         * @return the link.
         */
        public Node getLink()
        {
            return link;
        }

    }

    /**
     * A program to help test the recursive methods.
     * 
     * @param args
     *            no used.
     */
    public static void main(String[] args)
    {
        Recursion recursionTest = new Recursion();
        recursionTest.test();
    }

}
