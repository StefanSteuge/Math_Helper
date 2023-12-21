package org.example.util;

public class Constants {
    public static final String EQUATION_REGEX = "^[-+]?[0-9]*\\.?[0-9]*[xX][^0-9]*=[^0-9]*[-+]?[0-9]*\\.?[0-9]*$";
    public static final String EQUATION_REGEX_2 = ".*[+\\-*/]{2,}.*";
    public static final String FINALE_MESSAGE = "Goodbye!";
    public static final String MESSAGE_TO_THE_READERS = """
            HELLO TO THE MATH HELPER!!!
            
            PLEASE, SELECT ONE OF THE FOLLOWING ACTIONS BY TYPING
            THE OPTION'S NUMBER AND PRESSING ENTER KEY:
            
            [1] SAVE EQUATION
            [2] SAVE ROOT
            [3] FIND EQUATION BY ROOT
            [4] EVALUATE EQUATION
            
            TYPE "EXIT" TO STOP THE PROGRAM AND EXIT!""";
}
