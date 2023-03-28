package com.epam.rd.autotasks.validations;

import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null ){ return false;}
        String regex = "^#([0-9a-fA-F]{3}){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(color).matches();
    }
}





