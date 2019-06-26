package com.mcasaje.simplejavaweather.utils.html.jsoup;

import com.mcasaje.simplejavaweather.utils.html.HTMLParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// TODO: Delete
public class JSoupHTMLParser implements HTMLParser {

    @Override
    public String getInnerHTML(String selector, String html) {
        try {
            Document document = Jsoup.parse(html);
            Element element = document.selectFirst(selector);
            return element.html();
        }
        catch (Exception e) {
            throw new RuntimeException("Could not parse '" + selector + "' on " + html, e);
        }
    }
}
