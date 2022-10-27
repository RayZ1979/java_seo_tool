/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEOTool;

import SEOTool.HtmlObjects.HtmlDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ray
 */
public class SEOTool {
    private HtmlDocument _seoDocument; 
    
    public String LoadedUrl;
    
    //============================================================================================ 
    //=====================================TRY DOCUMENT LOAD==========================================
    public void Load(String url) throws IOException            
    {
        //CREATE NEW HTML DOCUMENT
        _seoDocument = new HtmlDocument(url);        

        try {    
        //LOAD WEBSITE   
            _seoDocument.Load();
            
        //SET LOADED URL    
            LoadedUrl = _seoDocument.Url;    
        } catch (IOException e) {
            throw new IOException("Site kon niet geladen worden");
            
            
          } catch (IllegalArgumentException i) {
            throw new IOException("U heeft geen geldige url opgegeven");
            
            
        }
    }
    
    // GET ALL OUTPUT 
    public String GetSeoOutput() throws IOException
    {
        //CHECK IF DOCUMENT IS LOADED
        if (_seoDocument == null)
        {
            return "";
        }
        
        //STRINGBUILDER
        StringBuilder output = new StringBuilder();
        
        output.append(GetTitleOutput());
        output.append(GetDescriptionOutput());
        output.append(GetKeywordsOutput());
        output.append(GetKeywordsBodyOutput());
        
        return output.toString();
    }
    
    //=======================================TITLE==========================================  
    private String GetTitleOutput() throws IOException
    {
        StringBuilder output = new StringBuilder();
        
        String[] titleArray = _seoDocument.Title.GetWords();
        int titleCharCounter = _seoDocument.Title.GetCharacterCount(); 
        int titleWordCounter = _seoDocument.Title.GetWordCount();
        int titleWidthInPixels = _seoDocument.Title.GetPixCount();         

        /*PRINT TITLE*/
        output.append("De titel is: ").append(_seoDocument.Title.ToString()).append("\n");
        output.append("De gebruikte woorden in de titel zijn:").append("\n");

        /*PRINT META TITLE ARRAY ZONDER LEESTEKENS*/
        output.append(Arrays.toString(titleArray)).append("\n");               

        /*PRINT HET AANTAL TEKENS IN DE TITLE INCLUSIEF SPATIES EN LEESTEKENS*/
        output.append("Het totaal aantal tekens in de titel is: ").append(titleCharCounter).append("\n");

        /*PRINT HET AANTAL WOORDEN IN DE TITLE*/
        output.append("Het aantal gebruikte woorden in de titel is: ").append(titleWordCounter).append("\n");

        /*PRINT DE TOTALE LENGTE VAN DE TITLE INCLUSIEF SPATIES EN LEESTEKENS IN PIXELS VOLGENS DE STANDAARD VAN GOOGLE*/ 
        output.append("De totale lengte in pixels van de titel is: ").append(titleWidthInPixels).append(" pixels.\n");
        
        /*PRINT PIXEL WIDTH OK*/
        if (titleWidthInPixels <= 200) {     
            output.append("Meta Title te kort." + "\n");
        } else if (titleWidthInPixels > 200 && titleWidthInPixels < (571)) {
            output.append("Meta Title is ok." + "\n");     
        }
        else  {                    
            output.append("Meta Title is te lang" + "\n");
        } 

        output.append("\n");
           
        return output.toString();
    }
    
    //=======================================DESCRIPTION==========================================  
    private String GetDescriptionOutput() throws IOException
    {
        StringBuilder output = new StringBuilder();
    
        String[] descriptionArray = _seoDocument.Description.GetWords(); 
        int desCharCounter = _seoDocument.Description.GetCharacterCount();
        int descriptionWordCounter = _seoDocument.Description.GetWordCount();
        int descriptionWidthInPixels = _seoDocument.Description.GetPixCount(); 

        /*PRINT DESCRIPTION*/
        output.append("De titel omschrijving is: ").append(_seoDocument.Description.ToString()).append("\n");
        output.append("De gebruikte woorden in de titel omschrijving zijn:").append("\n");             

        /*PRINT META DESCRIPTION ARRAY ZONDER LEESTEKENS*/
        output.append(Arrays.toString(descriptionArray)).append("\n");

        /*PRINT HET AANTAL TEKENS IN DESCRIPTION INCLUSIEF SPATIES EN LEESTEKENS*/
        output.append("Het totaal aantal tekens in de titel opmschrijving is: ").append(desCharCounter).append("\n");

        /*PRINT HET AANTAL WOORDEN IN DESCRIPTION*/
        output.append("Het aantal gebruikte woorden in de titel omschrijving is: ").append(descriptionWordCounter).append("\n");

        /*PRINT DE TOTALE LENGTE VAN DE DESCRIPTION INCLUSIEF SPATIES EN LEESTEKENS IN PIXELS VOLGENS DE STANDAARD VAN GOOGLE*/
        output.append("De totale lengte in pixels van de titel omschrijving is: ").append(descriptionWidthInPixels).append(" pixels.").append("\n");
        
        /*PRINT PIXEL WIDTH OK*/
        if (descriptionWidthInPixels <= 429) {     
            output.append("Meta Description te kort.\n");
        } else if (descriptionWidthInPixels > 429 && descriptionWidthInPixels < (924)) {
            output.append("Meta Description is ok\n");
        }
        else  {                    
            output.append("Meta Description is te lang\n");
        } 
        
        output.append("\n");
        
        return output.toString();
    }

    private String GetKeywordsOutput() throws IOException
    {
        StringBuilder output = new StringBuilder();
    
        String[] keywordsArray = _seoDocument.Keywords.GetSEOWords(); 
        int keyCharCounter = _seoDocument.Keywords.GetCharacterCount(); 
        int keywordWordCounter = _seoDocument.Keywords.GetWordCount();   
        int keywordWidthInPixels = _seoDocument.Keywords.GetPixCount(); 

        //=======================================KEYWORDS=============================================  
        output.append("De Keyword omschrijving is : ").append(_seoDocument.Keywords.ToString()).append("\n");
        output.append("De losse woorden zijn:").append("\n");
        /*PRINT META KEYWORDS*/
        output.append(Arrays.toString(keywordsArray)).append("\n");
        /*PRINT META KEYWORDS ARRAY ZONDER LEESTEKENS*/
        output.append("Het totaal aantal tekens in de Keywords meta tag: ").append(keyCharCounter).append("\n");
        /*PRINT HET AANTAL TEKENS IN KEYWORDS INCLUSIEF SPATIES EN LEESTEKENS*/
        output.append("Het aantal gebruikte Keywords is: ").append(keywordWordCounter).append("\n");
        /*PRINT HET AANTAL KEYWORDS*/
        output.append("De totale lengte in pixels van de gebruikte Keywords is: ").append(keywordWidthInPixels).append(" pixels.").append("\n");
        /*PRINT DE TOTALE LENGTE VAN DE KEYWORDS INCLUSIEF SPATIES EN LEESTEKENS IN PIXELS VOLGENS DE STANDAARD VAN GOOGLE*/ 
        
        output.append("\n");

        return output.toString();
    }

    //======================================BODY==============================================       
    private String GetKeywordsBodyOutput() throws IOException
    {
        StringBuilder output = new StringBuilder();

        ArrayList<String> checkedKeywords = _seoDocument.GetKeywordsNotInBody();
        
        /*PRINT DE TOTALE LENGTE VAN DE KEYWORDS INCLUSIEF SPATIES EN LEESTEKENS IN PIXELS VOLGENS DE STANDAARD VAN GOOGLE*/
        output.append("Alle woorden in alle body elementen zijn: ").append("\n");

        /*PRINT ALLE CONTENT VAN ALLE BODY ELEMENTS*/
        output.append(Arrays.toString(_seoDocument.Body.GetWords())).append("\n");

        output.append("\n");

        //=============================KEYWORDS NIET IN BODY=========================================        
        output.append("Dit zijn de keywords die niet in de body tekst voorkomen:").append("\n");
        output.append(checkedKeywords);
        
        return output.toString();
    }
}
