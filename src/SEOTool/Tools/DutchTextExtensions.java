/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEOTool.Tools;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ray
 */
public class DutchTextExtensions extends TextExtensions {

    // LIST OF IRRELEVANT WORDS VOORZETSEL, LIDWOORDEN
    private static ArrayList<String> _irrelevantWords = new ArrayList<>(
            Arrays.asList(
                "de", "het", "een", 
                "ik", "jij", "hij", "zij", "wij", "hen", "jullie", "uw", "het",
                "op", "onder", "boven", "over", "voor", "naast", "in", "uit",
                "al", "dfd"
            )
        );
   
    public static String[] GetIrrelevantWords(String text)
    {
        return TextExtensions.GetIrrelevantWords(text, _irrelevantWords);
    }
    
    public static String[] GetRelevantWords(String text)
    {
        return TextExtensions.GetRelevantWords(text, _irrelevantWords);
    }
}
