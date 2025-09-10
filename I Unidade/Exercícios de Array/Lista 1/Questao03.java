// 3. Faça um programa em Java que leia 4 notas, mostre as notas e a média na tela.
public class Questao03 {
    public static void main(String[] args) {
        double[] notas = {7, 5, 9, 8};
        double media = 0;

        for(int i = 0; i < notas.length; i++) {
            System.out.println((i+1) + "° nota: " + notas[i]);
            media += notas[i];
        }

        System.out.println("\nMédia é igual a " + media / notas.length);
    }
}