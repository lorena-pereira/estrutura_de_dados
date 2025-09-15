// 9. Faça um programa em Java que leia um vetor A com 10 números inteiros, calcule e mostre a soma dos quadrados dos elementos do vetor.
import java.util.Scanner;

public class Questao09 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] A = new int[10];

        int somaQuadrados = 0;
        
        for(int i = 0; i < A.length; i++) {
            System.out.println("Digite o " + (i + 1) + "° número: ");
            A[i] = s.nextInt();
        }

        for(int i = 0; i < A.length; i++) {
            somaQuadrados += A[i] * A[i]; 
        }

        System.out.println("\nA soma dos quadrados dos elementos desse vetor é igual a " + somaQuadrados);

        s.close();
    }
}
