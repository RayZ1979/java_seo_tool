/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEOTool.Tools;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Ray
 */
public class HtmlTools {
    // HAAL HET DOCUMENT OP MET JSOUP
    public static Document LoadDocument(String url) throws IOException{

        //HTTP FOUND, TRY NORMAL
        if (url.startsWith("http"))
        {
            
            return Jsoup.connect(url).timeout(6000).get();
        }
                
        //TRY HHTP OR HTTPS
        try
        {
            // NO PROTOCOL, TRY HTTPS
            return Jsoup.connect("https://" + url).timeout(6000).get();
        }
        catch(Exception e)
        {
            // NO HTTPS, TRY HTTP OR EXCEPTION TO CALLER
            return Jsoup.connect("http://" + url).timeout(6000).get();
        }
    }
    
    // SELECTEER BODY TEXT EN ZET IN EEN STRING       
    public static String GetBody(Document content) throws IOException {
        Elements body = content.select("body");
        String bodyText = body.text();
        return bodyText;
    }
    // SELECTEER TITLE TEXT EN ZET IN EEN STRING    
    public static String GetTitle(Document content) throws IOException {
        Elements title = content.select("title");
        String titleText = title.text();
        return titleText;        
    }
    
    // SELECTEER DESCRIPTION TEXT EN ZET IN EEN STRING    
    public static String GetDescription(Document content) throws IOException {
        return content.select("meta[name=description]").attr("content");
    }
    
    // SELECTEER KEYWORDS TEXT EN ZET IN EEN STRING
    public static String GetKeywords(Document content) throws IOException {
        return content.select("meta[name=keywords]").attr("content");
    }
}
