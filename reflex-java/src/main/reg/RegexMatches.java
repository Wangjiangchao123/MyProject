package main.reg;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    public static void main(String args[]) {
        String str = "select 1 from dual where  '?InsuYearFlag?'='A'  and '?InsuYear?'='1000'";
        String pattern = "\\?\\w{1,}\\?";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(pattern);
        System.out.println(m.matches());
    }

}

