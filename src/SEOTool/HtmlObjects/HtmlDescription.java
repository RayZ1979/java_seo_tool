package SEOTool.HtmlObjects;

import java.awt.Font;
import java.io.IOException;
import SEOTool.Tools.TextExtensions;

public class HtmlDescription extends HtmlElement {
    
    private String _htmlText = null;

//==============================================================================   
//===========================DESCRIPTION ALS TEXT===============================    
    
    public HtmlDescription(String htmlText) {
        super(htmlText);
        _htmlText = htmlText;
    }
//PASS CONSTRUCTOR PARAMETERS DOOR AAN DE BASE CLASS WAARDOOR ALLE htmlText EN FUNCTIES HtmlElement KUNT GEBRUIKEN 
    
//==============================================================================
//=======================PIXCOUNT TEXTEXTENSIONS========================    
    
    public int GetPixCount() throws IOException 
    {
        /*GOOGLE GEBRUIKT 18PX ARIAL VOOR HET TITEL ELEMENT.*/ 
        Font fontdescription = new Font("Arial", Font.PLAIN, 13);
        return TextExtensions.GetPixCount(fontdescription, _htmlText);
    }
    
}
