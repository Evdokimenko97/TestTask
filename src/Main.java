import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите строку для распаковывания: ");
        String string = scanner.nextLine();

        if (Valid.isValid(string)) {

            System.out.println("Полученная строка: ");
            Unpacking.unpackingString(string);
        }
    }
}