package SEOTool.HtmlObjects;

import java.awt.Font;
import java.io.IOException;
import SEOTool.Tools.TextExtensions;

public class HtmlKeywords extends HtmlElement {
    
    private String _htmlText = null;
    
//==============================================================================   
//=============================KEYWORDS ALS TEXT================================
    
    public HtmlKeywords(String htmlText) {
        super(htmlText);
        _htmlText = htmlText;
    }
 //PASS CONSTRUCTOR PARAMETERS DOOR AAN DE BASE CLASS WAARDOOR ALLE htmlText EN FUNCTIES HtmlElement KUNT GEBRUIKEN
    
//==============================================================================
//=======================PIXCOUNT TEXTEXTENSIONS======================== 
    
    public int GetPixCount() throws IOException
    {
        /*GOOGLE GEBRUIKT 16PX ARIAL VOOR META KEYWORDS TEXT.*/
        Font fontkeywords = new Font("Arial", Font.PLAIN, 16);
        return TextExtensions.GetPixCount(fontkeywords, _htmlText);
    }
    
}
