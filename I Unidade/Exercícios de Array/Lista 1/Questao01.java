// 1. Faça um programa em Java que leia um vetor de 5 números inteiros e mostre-os.
public class Questao01 {
    public static void main(String [] args) {
        int[] numeros = new int[5];
        
        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;
        numeros[3] = 4;
        numeros[4] = 5;

        for(int i = 0; i < numeros.length; i++) {
            System.out.println("Elemento do índice " + i + " é " + numeros[i]);
        }
    }
}