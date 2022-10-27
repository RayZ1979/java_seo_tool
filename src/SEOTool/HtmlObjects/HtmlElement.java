/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEOTool.HtmlObjects;

import java.io.IOException;
import SEOTool.Tools.DutchTextExtensions;
import SEOTool.Tools.TextExtensions;

// ELEMENTEN ALGEMENE BEWERKING OPHALEN
public class HtmlElement {
    
    private String _htmlText = null;
    
    public HtmlElement (String htmlText)
    {
        _htmlText = htmlText;
    }
    
    public int GetWordCount()
    {
        return TextExtensions.GetWordCount(_htmlText);
    }
    
    public String[] GetWords()
    {
        return TextExtensions.GetWords(_htmlText);
    }
    
    public String[] GetSEOWords()
    {
        String[] uniqueWords = DutchTextExtensions.GetRelevantWords(_htmlText);
        
        return uniqueWords;
    }

    public String[] GetNonSEOWords()
    {
        String[] uniqueWords = DutchTextExtensions.GetIrrelevantWords(_htmlText);
        
        return uniqueWords;
    }
    
    public int GetCharacterCount() throws IOException
    {
        return TextExtensions.CharacterCount(_htmlText);
    }
               
    public String ToString(){
        return _htmlText;
    } 
}
