package com.example;

import java.util.Random;
import java.util.Scanner;

public class SortingVisualizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        System.out.print("Enter the maximum value for elements: ");
        int maxValue = scanner.nextInt();

        int[] arr = generateArray(size, maxValue);
        System.out.println("Initial array:");
        visualize(arr);
        
        bubbleSort(arr);
        System.out.println("Sorted array:");
        visualize(arr);
        
        scanner.close();
    }

    private static int[] generateArray(int size, int maxValue) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxValue) + 1; // +1 to avoid zero
        }
        return arr;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    visualize(arr);
                }
            }
        }
    }

    private static void visualize(int[] arr) {
        clearConsole();
        for (int value : arr) {
            System.out.print("█".repeat(value)); // Using blocks to visualize
            System.out.println();
        }
        try {
            Thread.sleep(200); // Pause to make sorting visible
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Handle exceptions here
        }
    }
}
