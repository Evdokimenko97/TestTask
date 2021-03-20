
public class Valid {
    public static boolean isValid(String string) {
        int countSymbol1 = 0; //Счётчик символа '['
        int countSymbol2 = 0; //Счётчик символа ']'

        char[] symbols = string.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == '[') {
                countSymbol1++;
            }
            if (symbols[i] == ']') {
                countSymbol2++;
            }
        }

        if (symbols.length == 0) {
            System.out.println("Пустая строка.");
            return false;
        }

        String validationString = "abcdefghijklmnopqrstuvwxyz123456789[]";

        for (int i = 0; i < symbols.length; i++) {
            if (validationString.indexOf(symbols[i]) == -1) {
                System.out.println("В строке не валидные символы.");
                return false;
            } else if (symbols[0] == ']') {
                System.out.println("В начале строки стоит ']'");
                return false;
            } else if (symbols[0] == '[')  {
                System.out.println("В начале строки стоит '['");
                return false;
            } else if (countSymbol1 > countSymbol2) {
                System.out.println("Символов '[' больше, чем ']'");
                return false;
            } else if (countSymbol1 < countSymbol2) {
                System.out.println("Символов '[' меньше, чем ']'");
                return false;
            }
        }
        return true;
    }
}
