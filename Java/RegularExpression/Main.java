package com.tusharmohod.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str = "I am a string. Yes I am.";
        System.out.println(str);
        // Simplest form of regular expression is the string literal itself.

        String yourString = str.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
        System.out.println(alphanumeric.replaceAll("jkl99z$", "ZZZZZ"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee")); // matches with the entire string (returns false)
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z")); // returns true

        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "some text"));

        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        System.out.println(alphanumeric.replaceAll("[^ej]", "X"));
        // ^ when used inside square bracket will act as a negation regular expression matcher
        // outside the square bracket, the ^ will act as begin of the regular expression matcher

        System.out.println(alphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-f3-8]", "X")); // shortcut for line 34

        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X")); // ignore case
        // i is to ignore the ascii characters
        // to ignore case for unicode use (?iu)


        System.out.println(alphanumeric.replaceAll("[0-9]","X"));
        System.out.println(alphanumeric.replaceAll("\\d", "X")); // replaces all digits

        System.out.println(alphanumeric.replaceAll("\\D", "X")); // replace all non-digits

        String hasWhiteSpace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);

        System.out.println(hasWhiteSpace.replaceAll("\\s", "")); // removes all spaces
        System.out.println("->" + hasWhiteSpace.replaceAll("\\S", "")); // removes all non-spaces
        // Only tabs, spaces and newline character remains

        System.out.println(hasWhiteSpace.replaceAll("\\t", "")); // removes all tabs


        System.out.println(alphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X")); // words are replaced

        System.out.println(hasWhiteSpace.replaceAll("\\b", "X")); // each word is surrounded by X

        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));

        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY")); // + is at least one

        System.out.println(alphanumeric.replaceAll("^abcDe*","YYY")); // * means at least zero

        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY")); // e between 2 to 5 incl

        System.out.println(alphanumeric.replaceAll("h+i+j", "Y"));


        StringBuilder htmlText = new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = ".*<h2>.*";
        h2Pattern = "<h2>";

        // Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        // matcher can only be used once
        // if to be used again we need to reset the matcher
        matcher.reset();

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurence " + count + " : " + matcher.start() + " to " + matcher.end());
        }


        // Parenthesis are not part of the group matching
        String h2GroupPattern = "(<h2>.*</h2>)"; // * is greedy quantifier
        h2GroupPattern = "(<h2>.*?</h2>)"; // ? is lazy quantifier
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();


        while(groupMatcher.find()) {
            System.out.println("Occurence : " + groupMatcher.group(1));
        }


        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        System.out.println(h2TextMatcher.matches());
        h2TextMatcher.reset();

        while(h2TextMatcher.find()) {
            System.out.println("Occurence : " + h2TextMatcher.group(2)); // (1)(2)(3)
        }



        // Logical Operatos

        System.out.println("harry".replaceAll("[H|h]arry", "larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "larry"));

        System.out.println("harry".replaceAll("[^abc]", "X"));

        String tvTest = "tstvtkt";
        String tNotRegExp = "t[^v]"; // t should not be followed by v
        tNotRegExp = "t(?!v)"; // t should not be followed by v including the end. ! doesnt consumes a character.
        String tFollowedByV = "t(?=v)"; // ? means lookup. = means equal. ! means not equal.
        Pattern tNotVPattern = Pattern.compile(tNotRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence : " + count + " : " +  tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$  // 13 digits are mandatory, last 3 digits are options hence the ?
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));



        String regExp = "I want a \\w+.";
        String challenge1 = "I want a ball.";
        String challenge2 = "I want a bike.";

        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));

        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));


        String re = "I want a \\w+.";
        String c1 = "I want a ball.";
        String c2 = "I want a bike.";
        Pattern p1 = Pattern.compile(re);
        Matcher m1 = p1.matcher(c1);
        System.out.println(m1.matches());
        m1 = p1.matcher(c2);
        System.out.println(m1.matches());

        String c4 = "Replace all blanks with underscore";
        System.out.println(c4.replaceAll("\\s", "_"));

        String c5 = "aaabccccccccdddefffg";
        System.out.println(c5.matches("^a{3}b{1}c{8}d{3}e{1}f{3}g{1}"));
        System.out.println(c5.matches("[a-g]+"));

        String c7 = "abcd.135";
        String re7 = "[a-z]+.[0-9]+";
        re7 = "^[a-z]+\\.\\d+";
        System.out.println("kjisl.22".matches(re7));
        System.out.println("f5.12a".matches(re7));

    }

}
