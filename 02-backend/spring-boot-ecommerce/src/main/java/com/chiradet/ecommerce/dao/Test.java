package com.chiradet.ecommerce.dao;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class Test {

    public static void main(String[] args){
        /*
        Question 1 (Easy)
        Write a function that takes two arrays as input and returns the intersection of the two arrays.
        Example:
        intersectionArrays([1, 2, 3], [2, 3, 4]) // [2, 3]
        intersectionArrays([1, 2, 3], [1, 2, 5]) // [1, 2]
        intersectionArrays([1, 2, 3], [4, 5, 6]) // []
        intersectionArrays([], []) // []


        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 5};
        System.out.println(Arrays.toString(intersectionArrays( arr1, arr2)));
        */

        /*

        Write a function that takes a list of numbers as input and returns the list sorted in ascending order. [ Don’t use .sort() ]
        Example:
        sortNumbers([1, 5, 3, 2, 4]) // [1, 2, 3, 4, 5]
        sortNumbers([10, 5, 3, 2, 8, 1]) // [1, 2, 3, 5, 8, 10]
        sortNumbers( [0, -1, 10, 100, -50]) //  [-50, -1, 0, 10, 100]
        sortNumbers([5, 5, 4, 3, 2, 1]) // [1, 2, 3, 4, 5, 5]
        sortNumbers([]) // []
*/
         System.out.println(sortListNumberAscending(Arrays.asList(1, 5, 3, 2, 4)));


 /*
         Question 3 (Hard)
        Write a function that takes a list of numbers as input and returns the list of all pairs of numbers that add up to a given number.

        Example:
        findPairs([1, 2, 3, 4, 5], 6) // [[1, 5], [2, 4]]
        findPairs([1, 2, 3, 4, 5], 8) // [[3, 5]]
        findPairs([1, 1, 2, 2, 3, 3], 4) // [[1, 3], [1, 3], [2, 2]]
        findPairs([-2, -1, 0, 1, 2, 3], 1) //  [[-2, 3], [-1, 2], [0, 1]]
         */

       //System.out.println(pairsNumber(new int[]{1, 1, 2, 2, 3, 3}, 4));

    }

    public static List<List<Integer>> pairsNumber(int[] numbers, int target){
        List<List<Integer>> returnList = new ArrayList<>();
        Map<Integer, Integer> compare = new HashMap<>();
        for (int number : numbers){
            int dif = target - number;
            if(compare.containsKey(dif)){
                List<Integer> pair = new ArrayList<>();
                pair.add(number);
                pair.add(dif);
                returnList.add(pair);
            }
            compare.put(number, dif);
        }
        return returnList;
    }

    public static List<Integer> sortListNumberAscending(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return numbers;
        }
        List<Integer> sortedList = new ArrayList<>(numbers);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j) > sortedList.get(j + 1)) {
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        return sortedList;
    }

    public static int[] intersectionArrays(int[] arr1, int[] arr2){
        int[] intersectionArray ;
        String arrNum = "";
        int count = 0;
        for (int num1 : arr1){
            for (int num2 : arr2){
                if(num1 == num2){
                    System.out.println("Same value: "+ num2);
                    arrNum += Integer.toString(num2);
                    count++;
                }
            }
        }
        intersectionArray  = new int[count];
        char[] charNum = arrNum.toCharArray();
        for (int i = 0 ; i < count; i++){
            intersectionArray[i] = Integer.parseInt(charNum[i]+"");
        }
        return intersectionArray;
    }


}
