// 7. Faça um programa em Java que leia um vetor de 5 números inteiros, mostre a soma, a multiplicação e os números. 
import java.util.Scanner;

public class Questao07 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int[] numeros = new int[5];

        int soma = 0;
        int mult = 1;

        for(int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "° número: ");
            numeros[i] = s.nextInt();
        }

        for(int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
            mult *= numeros[i];
        }

        for(int i = 0; i < numeros.length; i++) {
            System.out.println("\nOs números são: " + numeros[i]);
        }

        System.out.println("\nA soma dos números são: " + soma); 
        System.out.println("\nA multiplicação dos números são: " + mult);  
        
        s.close();
    }
}
