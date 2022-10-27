/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEOTool.HtmlObjects;

import SEOTool.Tools.HtmlTools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.nodes.Document;

/**
 *
 * @author Ray
 */
public class HtmlDocument {
        
    protected Document Document = null;

    public HtmlBody Body = null;
    public HtmlTitle Title = null;
    public HtmlDescription Description = null;
    public HtmlKeywords Keywords = null;
    public String Url = "";
    
    private String _url = null;
    private String _bodyString = null;
    private String _titleString = null;
    private String _descriptionString = null;
    private String _keywordsString = null;
    
    // CONSTRUCTOR
    public HtmlDocument(String url) throws IOException
    {
        _url = url;
    }
    
    // LOAD DOCUMENT
    public void Load() throws IOException
    {
        Document = HtmlTools.LoadDocument(_url);

        Url = Document.location();
        
        Body = new HtmlBody(GetBody());
        Title = new HtmlTitle(GetTitle());
        Description = new HtmlDescription(GetDescription());
        Keywords = new HtmlKeywords(GetKeywords());
    }

    public ArrayList GetKeywordsNotInBody()
    {
        List<String> seoBodyWords = Arrays.asList(Body.GetSEOWords());
        String[] seoKeywords = Keywords.GetSEOWords();

        List<String> nonBodyKeywords = new ArrayList<>();
        
        for (String keyword : seoKeywords) {
            if (!seoBodyWords.contains(keyword))
            {
                nonBodyKeywords.add(keyword);
            }
        }
        return (ArrayList) nonBodyKeywords;
    }

    //---------------------------- private
    
    // GET BODY TEXT 
    private String GetBody() throws IOException
    {
        if(_bodyString == null)
        {
            _bodyString = HtmlTools.GetBody(Document);
        }
        return _bodyString;
    }
    
       // GET TITLE TEXT
    private String GetTitle() throws IOException
    {
        if(_titleString == null)
        {
            _titleString = HtmlTools.GetTitle(Document);
        }
        return _titleString;
    }

    // GET DESCRIPTION TEXT
    private String GetDescription() throws IOException
    {
        if(_descriptionString == null)
        {
            _descriptionString = HtmlTools.GetDescription(Document);
        }
        return _descriptionString;
    }
 
    // GET KEYWORDS TEXT
    private String GetKeywords() throws IOException
    {
        if(_keywordsString == null)
        {
            _keywordsString = HtmlTools.GetKeywords(Document);
        }
        return _keywordsString;
    }
}
