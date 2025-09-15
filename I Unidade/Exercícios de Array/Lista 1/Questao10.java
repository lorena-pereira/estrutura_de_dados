/* 10. Faça um programa em Java que leia dois vetores com 10 elementos cada. Gere um terceiro vetor de 20 elementos, cujos valores deverão 
ser compostos pelos elementos intercalados dos dois outros vetores. */
import java.util.Scanner;

public class Questao10 {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        int[] a = new int[10];
        int[] b = new int[10];
        int[] c = new int[20];
        
        System.out.println("Digite 10 números: ");
        for(int i = 0; i < a.length; i++) {
            a[i] = s.nextInt(); 
        }

        System.out.println("\nDigite 10 números novamente: ");
        for(int i = 0; i < b.length; i++) {
            b[i] = s.nextInt(); 
        }

        System.out.println();
        for(int i = 0; i < c.length; i++) {
            System.out.println(a[i]);
            System.out.println(b[i]);
        }
        
        s.close();
    }
}