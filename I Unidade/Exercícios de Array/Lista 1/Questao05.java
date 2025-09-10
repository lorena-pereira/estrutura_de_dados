/* 5. Faça um programa em Java que leia 20 números inteiros e armazene-os num vetor. Armazene os números pares no vetor PAR e os números IMPARES 
no vetor impar. Imprima os três vetores.*/
import java.util.ArrayList;

public class Questao05 {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList <Integer> par = new ArrayList<>();
        ArrayList <Integer> impar = new ArrayList<>();

        for(int i = 0; i < numeros.length; i++) {
            System.out.println("Os números são: " + numeros[i]);
        }

        for(int i = 0; i < numeros.length; i++) {
            if(i % 2 != 0) {
                impar.add(i);
            }
        }

        System.out.println("\nOs números ímpares são: " + impar);

        for(int p = 0; p < numeros.length; p++) {
            if(p % 2 == 0) {
                par.add(p);
            } 
        }

        System.out.println("\nOs números pares são: " + par);
    
    }
}
