/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEOTool.Tools;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ray
 */
public class TextExtensions {

   
    protected static String[] SplitString (String text)
    {
        return text.split("\\s+");
    }
    
    //
    protected static String CleanString (String text)
    {
        // TRIM SPACES
        text = text.trim();
        
        // SET TO LOWER CASE
        text = text.toLowerCase();
 
        // REMOVE DIACRITIC: https://stackoverflow.com/questions/3322152/is-there-a-way-to-get-rid-of-accents-and-convert-a-whole-string-to-regular-lette
        text = Normalizer.normalize(text, Normalizer.Form.NFD); 
        text = text.replaceAll("\\p{M}", ""); 

        // REMOVE APOSTROPHE(that's -> thats)
        text = text.replaceAll("\'", "");

        // REMOVE NON LETTERS AND NUMBERS: https://stackoverflow.com/questions/1805518/replacing-all-non-alphanumeric-characters-with-empty-strings
        text = text.replaceAll("[^a-zA-Z0-9]", " ");
        
        // REMOVE DOUBLE SPACES
        text = text.replaceAll("  ", " ");
        
        return text;
    }
    
    protected static String[] ArrayListToStringArray(ArrayList list)
    {
        String[] array = (String[]) list.toArray(new String[0]);
        
        return array;
    }

    public static String[] GetWords(String text)
    {
        // If there is no text return empty list
        if(text == null || text.isEmpty())
        {
            return new String[0];
        }
        
        text = CleanString(text);
        
        return SplitString(text);
    }

    public static int GetWordCount(String text)
    {
        return GetWords(text).length;
    }
    
    protected static ArrayList GetDistinctWords(String text)
    {
        ArrayList distinctWords = new ArrayList();
        
        String[] allWords = GetWords(text);
        
        for (int i = 0; i< allWords.length; i++)
        {
            String word = allWords[i];
            
            if(!distinctWords.contains(word))
            {
                distinctWords.add(word);
            }
        }
        
        return distinctWords;
    }
            
    public static int GetPixCount (Font font, String text)
    {
        FontMetrics metrics = new FontMetrics(font){};

        Rectangle2D boundsText = metrics.getStringBounds(text, null);
        int widthInPixels = (int) boundsText.getWidth();

        return widthInPixels;
    }
    
    protected static String[] GetIrrelevantWords(String text, ArrayList keywordList)
    {
        ArrayList distinctWords = GetDistinctWords(text);

        ArrayList irrelevantWords = new ArrayList();
        
        // Distinct word list iterator
        Iterator<String> dwIterator = distinctWords.iterator();
        
        // While we have string in distinctwords
        while (dwIterator.hasNext())
        {
            // Get distinctWord from list
            String distinctWord = dwIterator.next();

            // If irrelevant wordlist contains the distinct word
            if (keywordList.contains(distinctWord))
            {
                // Add word to irrelevant word list (if it's not already in the list)
                if (!irrelevantWords.contains(distinctWord))
                {
                    irrelevantWords.add(distinctWord);
                }
            }
        }
        return DutchTextExtensions.ArrayListToStringArray(irrelevantWords);
    }
    
    protected static String[] GetRelevantWords(String text, ArrayList keywordList)
    {
        ArrayList distinctWords = GetDistinctWords(text);

        ArrayList relevantWords = new ArrayList();
        
        // Distinct word list iterator
        Iterator<String> dwIterator = distinctWords.iterator();
        
        // While we have string in distinctwords
        while (dwIterator.hasNext())
        {
            // Get distinctWord from list
            String distinctWord = dwIterator.next();

            // If irrelevant wordlist doesn't contain the distinct word
            if (!keywordList.contains(distinctWord))
            {
                // Add word to relevant word list (if it's not already in the list)
                if (!relevantWords.contains(distinctWord))
                {
                    relevantWords.add(distinctWord);
                }
            }
        }
        return DutchTextExtensions.ArrayListToStringArray(relevantWords);
    }
    
    public static int CharacterCount(String text) throws IOException 
    {
        int charTeller = 0;
        for (int i = 0; i < text.length(); i++) {
            charTeller++;
        }
        return charTeller;
    }
 
      
      
}
