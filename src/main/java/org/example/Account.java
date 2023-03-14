package org.example;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        var patternString ="^\\pL+\\s\\pL+$";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(name).results().count()==1 && name.length()<=19;
    }
}