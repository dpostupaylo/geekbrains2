package com.gb.postupaylo.quarter.two.homework5;

import java.util.Arrays;

public class Application {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];


    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    public static void secondMethod() throws InterruptedException {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        int middle = arr.length / 2;
        float[] leftHalf = new float[middle];
        float[] rightHalf = new float[arr.length - middle];
        System.arraycopy(arr, 0, leftHalf, 0, middle);
        System.arraycopy(arr, middle, rightHalf, 0, arr.length - middle);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        float[] mergedArray = new float[arr.length];
        System.arraycopy(leftHalf, 0, mergedArray, 0, middle);
        System.arraycopy(rightHalf, 0, mergedArray, middle, arr.length - middle);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
