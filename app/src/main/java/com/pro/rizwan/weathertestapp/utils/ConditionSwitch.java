package com.pro.rizwan.weathertestapp.utils;



class ConditionSwitch {

    static String conditionSwitch(String condition){
        String regex = "\\s*\\b-\\b\\s*";
        condition = condition.replaceAll(regex, " ");
        condition=Character.toUpperCase(condition.charAt(0)) + condition.substring(1);

return condition;
        }
}
