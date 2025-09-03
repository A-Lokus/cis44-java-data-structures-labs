import java.util.Scanner;

public class SimpleCalculatorTester {
    public static void main(String[] args) {
        SimpleCalculator c = new SimpleCalculator();
        Scanner input = new Scanner(System.in);
        System.out.println("Use the calculator or type 'exit' to stop");
        String s;
        do {
            s = input.nextLine();
            System.out.println("Calculator Screen: "+c.input(s));
        } while (s.toLowerCase().equals("exit") == false);
        input.close();
    }
}
