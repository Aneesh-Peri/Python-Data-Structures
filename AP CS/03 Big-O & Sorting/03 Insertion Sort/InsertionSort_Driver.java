import java.util.*;
import java.io.*;

public class InsertionSort_Driver {
    public static void main(String[] args) throws Exception {
        // Part 1, for doubles
        int n = (int)(Math.random() * 100) + 20;
        double[] array = new double[n];
        for(int k = 0; k < array.length; k++)
            array[k] = Math.random() * 100;

        Insertion.sort(array);
        print(array);

        if(isAscending(array))
            System.out.println("In order!");
        else
            System.out.println("Out of order  :-( ");
        System.out.println();

        // Part 2, for Strings
        int size = 100;
        Scanner sc = new Scanner(new File("declaration.txt"));
        Comparable[] arrayStr = new String[size];
        for(int k = 0; k < arrayStr.length; k++)
            arrayStr[k] = sc.next();
        Insertion.sort(arrayStr);
        print(arrayStr);
        System.out.println();

        if(isAscending(arrayStr))
            System.out.println("In order!");
        else
            System.out.println("Out of order  :-( ");
    }

    public static void print(double[] a) {
        for(double temp: a)
            System.out.print(temp + " ");
        System.out.println();
    }

    public static void print(Object[] papaya) {
        for(Object temp : papaya)
            System.out.print(temp + " ");
    }

    public static boolean isAscending(double[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static boolean isAscending(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}

class Insertion
{
    public static void sort(double[] array)
    {

        for(int i = 1; i < array.length; i++)
        {
            double temp = array[i];
            int insert_index = shift(array, i-1, array[i]);
            array[insert_index] = temp;
        }
    }

    private static int shift(double[] array, int index, double value)
    {
        int t = index;
        while(t>=0 && array[t] > value)
        {
            array[t+1] = array[t];
            t = t - 1;
        }

        return t+1;
    }

    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] array)
    {
        for(int i = 1; i < array.length; i++)
        {
            Comparable temp = array[i];
            int insert_index = shift(array, i, array[i]);
            array[insert_index] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    private static int shift(Comparable[] array, int index, Comparable value)
    {
        int t = index-1;
        while(t>=0 && array[t].compareTo(value)>0)
        {
            array[t+1] = array[t];
            t = t - 1;
        }

        return t+1;

    }
}