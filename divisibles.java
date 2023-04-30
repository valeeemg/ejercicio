import java.util.Scanner;

public class Mavenproject3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa un número entero: ");
        int num = input.nextInt();

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("El número es divisible entre 3 y 5.");
        } else if (num % 3 == 0) {
            System.out.println("El número es divisible entre 3.");
        } else if (num % 5 == 0) {
            System.out.println("El número es divisible entre 5.");
        } else {
            System.out.println("El número no es divisible entre 3 ni entre 5.");
        }
    }
}