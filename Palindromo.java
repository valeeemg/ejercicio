import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una palabra para verificar si es un palíndromo:");
        String palabra = sc.nextLine();
        if (esPalindromo(palabra)) {
            System.out.println(palabra + " es un palíndromo");
        } else {
            System.out.println(palabra + " no es un palíndromo");
        }
    }

    public static boolean esPalindromo(String palabra) {
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                return false;
            }
        }
        return true;
    }
}