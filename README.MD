Objective 1

Write a command-line program that returns the current time using the Human Friendly Text demonstrated in the example below.
Numeric Time Human Friendly Text

01:00 One o'clock
02:00 Two o'clock
13:00 One o'clock
13:05 Five past one
13:10 Ten past one
13:25 Twenty five past one
13:30 Half past one
13:35 Twenty five to two
13:55 Five to two
For example, if we execute this program at 16:30, it should output "Half past four"

talking-clock 16:30
Half past four
-------------------------------------------------------------
Answer : 
        Steps to execute programe in commmandline :
        1) Exceute this command in commandline to compile java and copy classes in ./commandline folder : 
            javac -d commandline/ src/main/java/com/lloyds/humanreadableformat/commandline/*
        2) Execute command to change a dir:
            cd commandline
        3)Exceute this command in commandline to run the programe :
            java com.lloyds.humanreadableformat.commandline.CurrentTimeInHumanReadableCommandline

        Expected result : current time in Human Readable format
        Example : 11:09 - Nine past four
mallikarjunareddypoli@MallikaeddysMBP commandline % java com.lloyds.humanreadableformat.commandline.CurrentTimeInHumanReadableCommandline
Curret time in Text : Eleven past twelve
mallikarjunareddypoli@MallikaeddysMBP commandline % java com.lloyds.humanreadableformat.commandline.TimeInHumanReadableFormatForGivenTimeCommandline
Please enter the Time (HH:SS) ??
23:11
Eleven past eleven
mallikarjunareddypoli@MallikaeddysMBP commandline % java com.lloyds.humanreadableformat.commandline.TimeInHumanReadableFormatForGivenTimeCommandline
Please enter the Time (HH:SS) ??
00:00
Zero o'clock
mallikarjunareddypoli@MallikaeddysMBP commandline % java com.lloyds.humanreadableformat.commandline.TimeInHumanReadableFormatForGivenTimeCommandline
Please enter the Time (HH:SS) ??
00:15
Fifteen past zero

-------------------------------------------------------------
Objective 2

Allow the command to take an arbitrary Numeric Time parameter as input and return the "Human Friendly Text" equivalent.

For example:

talking-clock 15:00
Three o'clock
-------------------------------------------------------------
Answer:
Exceute class name in commandline : TimeInHumanReadableFormatForGivenTimeCommandline
Expected Result : Please enter the Time (HH:SS) ??
Enter your time in(HH:SS) : 01:05
    result should be : Five past one
If you Enter incorrect time format like : 11:09:1 or test
result should be : Please try with valid time format(HH:SS)
--------------------------------------------------------------
Objective 3

Write a REST service to expose the talking clock and allow an optional parameter to pass the arbitrary  Numeric Time like Objective 2, returning the "Human Friendly Text" as JSON with the following format:

{value: "One o'clock"}
--------------------------------------------------------------
Anser :
http://localhost:8080/currentTime
if current time is : 11:18
result : {"value":"Eighteen past eleven"}

http://localhost:8080/11:21
result : {"value":"Twenty-one past eleven"}

If try with incorrect time format
http://localhost:8080/11
Message : Please try with valid time format(HH:SS)
