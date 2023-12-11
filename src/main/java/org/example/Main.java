package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numElements = 100000;
        int numInsertions = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Кількість елементів у списку: " + numElements);
        System.out.println("Число введених елементів: " + numInsertions);

        fill(linkedList, numElements, "LinkedList");
        fill(arrayList, numElements, "ArrayList");

        randomAccess(linkedList, "LinkedList");
        randomAccess(arrayList, "ArrayList");

        sequentialAccess(linkedList, "LinkedList");
        sequentialAccess(arrayList, "ArrayList");

        insertAtBeginning(linkedList, numInsertions, "LinkedList");
        insertAtBeginning(arrayList, numInsertions, "ArrayList");

        insertAtEnd(linkedList, numInsertions, "LinkedList");
        insertAtEnd(arrayList, numInsertions, "ArrayList");

        insertInMiddle(linkedList, numElements, numInsertions, "LinkedList");
        insertInMiddle(arrayList, numElements, numInsertions, "ArrayList");
    }

    private static void fill(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Fill %s: %d ms%n", listType, endTime - startTime);
    }

    private static void randomAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Random access in %s: %d ms%n", listType, endTime - startTime);
    }

    private static void sequentialAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();

        for (Integer element : list) {
            int value = element;
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Sequential access in %s: %d ms%n", listType, endTime - startTime);
    }

    private static void insertAtBeginning(List<Integer> list, int numInsertions, String listType) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numInsertions; i++) {
            list.add(0, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Insert at the beginning of %s: %d ms%n", listType, endTime - startTime);
    }

    private static void insertAtEnd(List<Integer> list, int numInsertions, String listType) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numInsertions; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Insert at the end of %s: %d ms%n", listType, endTime - startTime);
    }

    private static void insertInMiddle(List<Integer> list, int numElements, int numInsertions, String listType) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numInsertions; i++) {
            int index = numElements / 2;
            list.add(index, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Insert in the middle of %s: %d ms%n", listType, endTime - startTime);
    }
}