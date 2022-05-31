package com.gb.postupaylo.quarter.two.homework2;

import com.gb.postupaylo.quarter.two.homework2.custom.exception.MyArrayDataException;
import com.gb.postupaylo.quarter.two.homework2.custom.exception.MyArraySizeException;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        String[][] correctArray = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] smallArray = new String[][]{{"1", "2", "3"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] bigArray = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4", "1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] noIntArray = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "s", "4"}, {"1", "2", "r", "4"}, {"1", "2", "3", "4"}};

        try {
            System.out.println(application.summarizeArrayElements(correctArray));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println(application.summarizeArrayElements(smallArray));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println(application.summarizeArrayElements(bigArray));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println(application.summarizeArrayElements(noIntArray));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }


    public int summarizeArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;

        if (array.length != 4)
            throw new MyArraySizeException(String.format("Wrong size of array. Required 4 current is %d", array.length));

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException(String.format("Wrong size of array. Required 4 current is %d", array[i].length));
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(String.format("Incorrect data in row %d column %d", i + 1, j + 1));
                }
            }
        }

        return summ;
    }
}
