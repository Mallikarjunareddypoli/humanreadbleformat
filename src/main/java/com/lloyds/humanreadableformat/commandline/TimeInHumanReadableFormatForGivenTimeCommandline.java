package com.lloyds.humanreadableformat.commandline;

import java.util.Scanner;

import static com.lloyds.humanreadableformat.commandline.HumanReadableCommandLineUtil.timeHumanReadableFormat;

public class TimeInHumanReadableFormatForGivenTimeCommandline {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the Time (HH:SS) ??");
        System.out.println(timeHumanReadableFormat(sc.nextLine()));
    }
}
