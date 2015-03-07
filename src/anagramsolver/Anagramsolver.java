package anagramsolver;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Anagramsolver {

    public Anagramsolver(){}

    public ArrayList<String> solve(String word) {
            BufferedReader br;
            boolean done = false;
            ArrayList<String> strList = new ArrayList<String>();
            try {
                br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/resources/wordsEn.txt")));
                String line = br.readLine();
                while (line != null && !done) {
                    if (line.length() == word.length()) {
                        char[] ch = line.toCharArray();
                        ArrayList<Character> worda = new ArrayList<Character>();
                        for (char c : word.toCharArray()) {
                            worda.add(c);
                        }
                        int score = 0;
                        int maxscore = word.length();
                        for (char cha : ch) {
                            if (worda.contains(cha)) {
                                score++;

                            }
                        }

                        if (score == maxscore) {
                            strList.add(line);
                        }
                    }
                    line = br.readLine();
                }
                ArrayList<String> letterList = new ArrayList<String>();
                for (char character : word.toCharArray()) {
                    letterList.add(String.valueOf(character));
                }
                ArrayList<String> goodList = new ArrayList<String>();
                for (String s1 : strList) {
                    String s2 = s1.replace("a", "a");
                    for (String str : letterList) {
                        if (s1.contains(str)) {
                            s2 = s2.replaceFirst(str, "");
                            continue;
                        }
                        break;
                    }
                    if (s2.equalsIgnoreCase("")) {
                        goodList.add(s1);
                    }
                }
                return goodList;
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        return null;

    }

}
