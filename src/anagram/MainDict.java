package anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainDict{ //implements Runnable{
/*
    static Thread thread = new Thread(new MainDict());

    public static void main(String[] args) {
       thread.run();
    }

    public void run(){
        String str = null;
        Scanner s = new Scanner(System.in);
        boolean xxp = true;
        while (xxp) {
            URL is = anagram.class.getResource("resources/wordsEn.txt");
            File file;
            BufferedReader br;
            try {
                file = new File(is.toURI());
                br = new BufferedReader(new FileReader(file));
                int toRead = randInt(0, 109583);
                String line = null;
                for (int i = 0; i <= toRead; i++) {
                    br.readLine();
                    if (i == toRead) {
                        line = br.readLine();
                    }
                }
                str = line;
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(1);
            }
            System.out.println("Scrambling...");
            String string = randomiseString(str);
            System.out.println("Your scrambled word is: " + string);
            System.out.println("Again?");
            String in = s.next();
            if (in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("true") || in.equalsIgnoreCase("yep")
                    || in.equalsIgnoreCase("yup") || in.equalsIgnoreCase("yeah")){
                xxp = true;
            }else xxp = false;
        }
    }

    public String randomiseString(String str) {
        char[] strArray = str.toCharArray();
        ArrayList<Character> charList = new ArrayList<Character>();
        for (char ch : strArray) {
            charList.add(ch);
        }
        ArrayList<String> newList = new ArrayList<String>();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (char ch : charList) {
            int i = randInt(0, charList.size() - 1);
            while (intList.contains(i)) {
                i = randInt(0, charList.size() - 1);
            }
            newList.add(String.valueOf(charList.get(i)));
            intList.add(i);
        }
        StringBuilder strB = new StringBuilder();
        for (String ch : newList) {
            strB.append(ch);
        }
        return strB.toString();

    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
*/
}
