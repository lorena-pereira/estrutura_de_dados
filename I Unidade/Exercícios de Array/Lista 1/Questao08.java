/* 8. Faça um programa em Java que peça a idade e a altura de 5 pessoas, armazene cada informação no seu respectivo vetor. 
Imprima a idade e a altura na ordem inversa da ordem lida.*/
import java.util.Scanner;

public class Questao08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int pessoas = 5;

        int[] idade = new int[pessoas];
        double[] altura = new double[pessoas];

        for(int i = 0; i < pessoas; i++) {
            System.out.println("Digite a idade da " + (i + 1) + "° pessoa: ");
            idade[i] = s.nextInt();
            System.out.println("Digite a altura da " + (i + 1) + "° pessoa: ");
            altura[i] = s.nextDouble();
        }

        System.out.println("\nOrdem Inversa: ");
        for(int i = pessoas - 1; i >= 0; i--) {
            System.out.println("\nIdade da " + (i + 1) + "° pessoa: " + idade[i]);
            System.out.println("Altura da " + (i + 1) + "° pessoa: " + altura[i]);
        }
        
        s.close();
    }
    
}
