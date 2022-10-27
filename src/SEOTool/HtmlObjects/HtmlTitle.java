package SEOTool.HtmlObjects;

import SEOTool.Tools.TextExtensions;
import java.awt.Font;
import java.io.IOException;

public class HtmlTitle extends HtmlElement {
    
    private String _htmlText = null;
    
//==============================================================================   
//===============================TITLE ALS TEXT=================================
    
    public HtmlTitle(String htmlText) {
        super(htmlText);
        _htmlText = htmlText;
    }
//PASS CONSTRUCTOR PARAMETERS DOOR AAN DE BASE CLASS WAARDOOR ALLE htmlText EN FUNCTIES HtmlElement KUNT GEBRUIKEN
    
//==============================================================================
//=======================PIXCOUNT TEXTEXTENSIONS======================== 
    
    public int GetPixCount() throws IOException 
    {
        /*GOOGLE GEBRUIKT 18PX ARIAL VOOR HET TITEL ELEMENT.*/ 
        Font fonttitle = new Font("Arial", Font.PLAIN, 18);
        return TextExtensions.GetPixCount(fonttitle, _htmlText);
    }
              
}
