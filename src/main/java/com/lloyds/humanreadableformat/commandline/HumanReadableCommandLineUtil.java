package com.lloyds.humanreadableformat.commandline;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lloyds.humanreadableformat.commandline.HumanReadableConstants.*;

public class HumanReadableCommandLineUtil {

    /**
     * @return
     */
    public static String timeHumanReadableFormat(){
        int hours = java.time.LocalTime.now().getHour();
        int minutes = java.time.LocalTime.now().getMinute();
        return timeHumanReadableFormat(hours, minutes);
    }

    /**
     * @param time
     * @return
     */
    public static String timeHumanReadableFormat(final String time){
        String inWords=null;
        if(isValidTime(time)) {
            int hours = Integer.parseInt(time.split(COLON)[0]);
            int minutes = Integer.parseInt(time.split(COLON)[1]);
            inWords = timeHumanReadableFormat(hours, minutes);
        }else {
            inWords = HumanReadableConstants.TIME_FORMAT_ERROR;
        }
        return inWords;
    }

    /**
     * @param hours
     * @param minutes
     * @return
     */
    private static String timeHumanReadableFormat(final int hours, final int minutes) {
        String inWords=null;
        if (minutes == 0)
            inWords = CLOCK_MAP[hours]+ BLANK_SPACE + O_CLOCK.toLowerCase();
        else if(minutes>30)
            inWords = getMinutesInWords(60-minutes) + BLANK_SPACE + TO + BLANK_SPACE + CLOCK_MAP[hours+1].toLowerCase();
        else if(minutes<30)
            inWords = getMinutesInWords(minutes) + BLANK_SPACE+ PAST + BLANK_SPACE + CLOCK_MAP[hours].toLowerCase();
        else
            inWords = HALF + BLANK_SPACE + PAST + BLANK_SPACE + CLOCK_MAP[hours].toLowerCase();
        return inWords;
    }

    /**
     * @param _minutes
     * @return
     */
    private static String getMinutesInWords(final int _minutes) {
        String inWords=null;
        Scanner sc=new Scanner(String.valueOf(_minutes));
        int inputValue = sc.nextInt();
        int b=inputValue%10,a=inputValue/10;
        //inWords = a==1 ? TWO_DIGITS[b+1] : (b==0 ? TENS_MULTIPLE[a] : (a>0 ? TENS_MULTIPLE[a] + HYPHEN + SINGLE_DIGITS[b] : SINGLE_DIGITS[b]));
        if(a==1)
            inWords = TWO_DIGITS[b+1];
        else if(b==0)
            inWords = TENS_MULTIPLE[a];
        else if(a>0)
            inWords = TENS_MULTIPLE[a] + HYPHEN + SINGLE_DIGITS[b];
        else
            inWords = SINGLE_DIGITS[b];
        return inWords;
    }

    /**
     * @param time
     * @return
     */
    private static boolean isValidTime(final String time){
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(regex);
        if (time == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

}
