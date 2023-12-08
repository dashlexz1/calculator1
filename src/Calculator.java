import java.util.Scanner;

public class Calculator {

    public String calc(String input) throws ActionException, FormatException, Exception{
        Map map = new Map();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i]))
                actionIndex = i;
        }
        if (actionIndex == -1) {
            throw new ActionException("Недопустимый знак для выражения");
        }
        String[] expression1 = input.replaceAll(" ", "").split(regexActions[actionIndex]);
        if(expression1.length != 2){
            throw new realException("Должно быть 2 числа");
        }
        int a;
        int b;
        if (map.isRoman(expression1[0]) != map.isRoman(expression1[1])) {
            throw new FormatException("Неверный формат записи");
        }
        boolean isRoman = map.isRoman(expression1[0]);
        if(isRoman){
            a = map.romanToInt(expression1[0]);
            b = map.romanToInt(expression1[1]);

        }else {
            a = Integer.parseInt(expression1[0]);
            b = Integer.parseInt(expression1[1]);
        }

        int result = 0;
        if ((a>10 || a<0) || (b>10 || b<0)){
            throw new Exception("Целые числа до 10 должны быть");
        }
        switch (actions[actionIndex]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
        }
        if (isRoman) {
            if(result<=0){
                throw new Exception("В римской системе нет таких чисел");
            }else {
                System.out.println(map.intToRoman(result));
            }

        }else{
            System.out.println(result);
        }
        return String.valueOf(result);
    }
}


