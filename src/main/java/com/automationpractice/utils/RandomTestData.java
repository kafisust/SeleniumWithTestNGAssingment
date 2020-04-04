package com.automationpractice.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Random;

public class RandomTestData extends WebElementUtils {

    enum domain {
        COM,NET
    }

    public Random rnd = new Random();

    final private static Integer EMAIL_LIMIT = 5;

    public String randomEmail(){
        return RandomStringUtils.randomAlphabetic(EMAIL_LIMIT) + "." + domain.COM;
    }
    public RandomTestData(){
       ArrayList<String> CompanyNames = new ArrayList<String>();
           CompanyNames.add("company a");
           CompanyNames.add("company b");
    }

    public String GetRandomDomain(){
      String[] domains = new String[]{".com",".net",".org",".gov",".tv"};
      return domains[rnd.nextInt(0)];
    }

    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return  rnd.nextInt((max - min) + 1) + min;
    }

    /*public String GetRandomDigits(int min, int max){
        IntStream numberOfDigits = rnd.ints(min,max);
        return GetRandomDomain(numberOfDigits);
    }*/
}

