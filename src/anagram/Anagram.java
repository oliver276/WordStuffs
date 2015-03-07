package anagram;

import java.util.ArrayList;
import java.util.Random;

public class Anagram {

    public Anagram(){}

    public String randomiseString(String str){
        char[] strArray = str.toCharArray();
        ArrayList<Character> charList = new ArrayList<Character>();
        for (char ch : strArray){
            charList.add(ch);
        }
        ArrayList<String> newList = new ArrayList<String>();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (char ch : charList){
            int i = randInt(0, charList.size() - 1);
            while (intList.contains(i)){
                i = randInt(0,charList.size() - 1);
            }
            newList.add(String.valueOf(charList.get(i)));
            intList.add(i);
        }
        StringBuilder strB = new StringBuilder();
        for (String ch : newList){
            strB.append(ch);
        }
        return strB.toString();
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
