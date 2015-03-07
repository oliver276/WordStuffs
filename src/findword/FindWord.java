package findword;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindWord {

    private String[] Words;

    public FindWord(String[] words){
        Words = words;
    }

    public ArrayList<String> getWords(String str){
        BufferedReader br;
        try{
            ArrayList<String> sameLetterList = new ArrayList<String>();
            ArrayList<String> goodWords = new ArrayList<String>();

            for (String line : Words) {
                if (line.length() == str.length()){
                    sameLetterList.add(line);
                }
            }
            for (String string : sameLetterList){
                ArrayList<Character> characters = new ArrayList<Character>();
                char[] charList =  string.toCharArray();
                for (char c : charList){
                    characters.add(c);
                }
                int i = 0;
                Boolean done = true;
                for (Character c : str.toCharArray()){
                    if (characters.get(i).equals(c) || c.equals('*')){
                    } else {
                        done = false;
                    }
                    i++;
                }
                if (done) goodWords.add(string);
            }
            return goodWords;
        } catch (Exception ex){
            return null;
        }
    }

}
