package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //System.out.println(new Random().nextInt(5));
        //uniqeNum(3,6);
       // System.out.println(new SimpleDateFormat("yyyy-MM-dd || h:m:ss a").format(new Date()));
    }

    public static int randNum(int upper)
    {
        return new Random().nextInt(upper);
    }

    public static Set<Integer> uniqeNum(int need  , int total)
    {
        Set<Integer> nums = new HashSet<>();
        while (nums.size()<need)
        {
            int rand =randNum(total);
            nums.add(rand);
        }
        System.out.println(nums);
        return nums;
    }
}