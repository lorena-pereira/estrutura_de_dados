// 2. Faça um programa em Java que leia um vetor de 10 números reais e mostre-os na ordem inversa.
public class Questao02 {
    public static void main(String[] args) {
        float[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i = 0; i < numeros.length; i++) {
            System.out.println("Número da posição " + i + ": " + numeros[i]);   
        }

        System.out.println("\nOrdem Inversa: ");
        for(int i = numeros.length - 1; i >= 0; i--) {
            System.out.println("Posição " + i + ": " + numeros[i]);
        }
    }
}