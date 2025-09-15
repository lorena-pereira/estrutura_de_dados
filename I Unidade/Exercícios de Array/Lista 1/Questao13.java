/* 13. Faça um programa em Java que receba a temperatura média de cada mês do ano e armazene-as em um array. Após isto, calcule a média anual
das temperaturas e mostre todas as temperaturas acima da média anual, e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 
2 – Fevereiro, ...).*/
import java.util.Scanner;

public class Questao13 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] temperatura = new int[12];
        int[] meses = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; 

        int somaTemperatura = 0;
        double mediaTemperatura = 0;
         
        for(int i = 0; i < temperatura.length; i++) {
            System.out.println("Digite a temperatura média do mês " + (i + 1) + " em °C:" );
            temperatura[i] = s.nextInt();
            somaTemperatura += temperatura[i];
        }

        mediaTemperatura = somaTemperatura / 12;
        System.out.println("\nA média anual de temperatura foi " + mediaTemperatura + "°C\n");

        for(int i = 0; i < meses.length; i++) {
            if(temperatura[i] > mediaTemperatura) {
                System.out.println("O mês " + (i + 1) + " teve a média de temperatura acima da média anual, sendo ela " + temperatura[i] + "°C");
            }
        }

        s.close();
    }
}
