package countdown;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Countdown {

    private String[] Words;

    public Countdown(String[] words){
        Words = words;
    }

    public ArrayList<String> solve(String word) {
            BufferedReader br;
            boolean done = false;
            ArrayList<String> strList = new ArrayList<String>();
            try {
                for (String line : Words) {
                    if (line.length() > word.length()){

                    }else {
                        char[] ch = line.toCharArray();
                        ArrayList<Character> worda = new ArrayList<Character>();
                        String str = "";
                        for (char c : word.toCharArray()) {
                            worda.add(c);
                        }
                        boolean brea = false;
                        for (char cha : ch) {
                            if (worda.contains(cha)) {
                                worda.remove(Character.valueOf(cha));
                                str = str + cha;
                            } else {
                                brea = true;
                            }
                        }
                        if (brea) {
                        } else {
                            strList.add(str);
                        }
                    }
                }
                ArrayList<String> letterList = new ArrayList<String>();
                for (char character : word.toCharArray()) {
                    letterList.add(String.valueOf(character));
                }
                String[] strA = new String[strList.size()];
                strA = strList.toArray(strA);
                bubbleSort(strA);
                ArrayList<String> goodList = new ArrayList<String>();
                for (String nS : strA){
                    goodList.add(nS);
                }
                //for (String s1 : strList) {
                //    String s2 = s1.replace("a", "a");
                //   for (String str : letterList) {
                //        if (s1.contains(str)) {
                //            s2 = s2.replaceFirst(str, "");
                //            continue;
                //        }
                //        break;
                //    }
                //    if (s2.equalsIgnoreCase("")) {
                //        goodList.add(s1);
                //    }
                //}
                return goodList;
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        return null;
    }

    public static void bubbleSort(String[] arr) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i += 1) {
                if (arr[i].length() > arr[i + 1].length()) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Mutates the original array
    public static void swap(String[] arr, int index0, int index1) {
        String temp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = temp;
    }
}
