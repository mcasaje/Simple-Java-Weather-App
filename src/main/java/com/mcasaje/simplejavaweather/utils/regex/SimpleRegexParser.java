package com.mcasaje.simplejavaweather.utils.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegexParser implements RegexParser {

    private static final Logger logger = LoggerFactory.getLogger(SimpleRegexParser.class);

    @Override
    public String parse(String source, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(source);
        boolean foundMatch = matcher.find();
        if (foundMatch) {
            String foundGroup = matcher.group(1);
            logger.debug("Found regex group: " + foundGroup);
            return foundGroup;
        }
        else {
            logger.debug("Regex group not found");
            throw new RuntimeException("Regex group not found");
        }
    }

}
