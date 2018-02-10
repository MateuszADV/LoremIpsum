package pl.mateusz.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    private static Random random = new Random();
    private static String sentence="";
    private static List<String> listParagraph = new ArrayList<>();

    private static int lengthWord(){
        return random.nextInt(7)+3;
    }


    public static String newWord(){
        int numberAscii;
        String word="";

        for (int i =0; i<lengthWord(); i++){
            numberAscii = random.nextInt(24)+97;
            word += (char)numberAscii;
        }
        return word;
    }

    public static List<String > sentence(String quantutyWord, String quantityParagraph){
        listParagraph.clear();

        try{
            if (Integer.parseInt(quantityParagraph)<Integer.parseInt(quantutyWord)){
                return paragraph(Integer.parseInt(quantutyWord), Integer.parseInt(quantityParagraph));

            }else {
                listParagraph.add("Ilośc akapitów nie może być większa od ilości wyrazów");
                return listParagraph;
            }
        }catch (Exception e){
            listParagraph.add("Jedna z pdanych warości nie jest liczbą");
            return listParagraph;
        }


    }

    public static List<String> paragraph(int word, int paragraph){

        for (int i = 1; i < word+1; i++) {
            sentence += newWord() + " ";
            if(i%(word/paragraph)==0){
                listParagraph.add(sentence.substring(0,1).toUpperCase()+sentence.substring(1,sentence.length()-1)+".");
                sentence="";
            }
            if(i==word){
                listParagraph.add(sentence);
            }
        }
        return listParagraph;
    }
}
