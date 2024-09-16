package arrays;

import java.util.ArrayList;

// Arrays: Stores fixed-size sequential elements of the same type
// Advantages: Fast access with O(1) time complexity.
// Disadvantages: Fixed size once declared, Inserting or deleting requires shifting elements (O(n) for worst-case).



public class arrays {

    public static void main(String[] args) {

        System.out.println("Arrays Demo");

        // ******************************* Simple array with primitive datatypes *******************************
        int[] myIntArr = new int[5]; // size declaration
        myIntArr[0] = 12;
        myIntArr[1] = 24;
        printArr(myIntArr);

        int[] myIntArr2 = {45, 47, 89, 66}; // Declaration with initialization
        printArr(myIntArr2);

        System.out.println("Length: " + myIntArr2.length + "\n");

        // ******************************* Simple array with Wrapper Class datatypes *******************************
        Integer[] intArr = {1, 2, 3, 4, 5};
        printArr(intArr);

        String[] strArr = {"apple", "bananna", "carrot"};
        printArr(strArr);


        // ArrayList provides flexibility by resizing automatically as elements are added/removed
        // Only holds objects (use wrappers for primitives like Integer for int).
        // Provides powerful methods like add(), remove(), get(), size(), and more.
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        myArr.add(99);
        myArr.addFirst(100);
        System.out.println("Size: " + myArr.size());
        System.out.println(myArr);
        // System.out.println(myArr.get(20)); // index out of bounds


    }

    // ******************************* Print array for Wrapper class array *******************************
    static <T> void printArr(T[] arr) {
        for (T x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // ******************************* Print array for primitive type array *******************************
    static void printArr(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
