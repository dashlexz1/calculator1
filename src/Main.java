import java.util.Scanner;
class Main {
    public static void main(String[] args) throws ActionException, FormatException, Exception {
        Calculator calculator = new Calculator();
        System.out.println("Введите выражение");
        Scanner calculator1 = new Scanner(System.in);
        String input = calculator1.nextLine();
        calculator.calc(input);
    }
}



