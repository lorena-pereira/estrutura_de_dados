/* 6. Faça um programa em Java que peça as quatro notas de 10 alunos, calcule e armazene num vetor a média de cada aluno, imprima 
o número de alunos com média maior ou igual a 7.0. */
import java.util.Scanner;

public class Questao06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int notas = 4;
        int alunos = 10;
        int alunosAprovados = 0;

        double[] media = new double[alunos];
    
        // Digitar as notas, calcular e armazenar as médias
        for(int i = 0; i < alunos; i++) {
            double soma = 0;

            for(int n = 0; n < notas; n++) {
                System.out.println("Digite a " + (n + 1) + "° nota do aluno " + (i + 1) + ": ");
                double nota = s.nextDouble();
                soma += nota;
        }

        media[i] = soma / notas;
        }

        // Imprimir as médias
        for(int i = 0; i < alunos; i ++) {
            System.out.println("\nMédia do aluno " + (i + 1) + " é " + media[i]);
        }

        // Verificar a quantidade de alunos com média >= 7
        for(int i = 0; i <= 7; i++) {
            if(media[i] >= 7) {
                alunosAprovados++;
            }
        }

        System.out.println("\nNúmero de alunos aprovados: " + alunosAprovados);

        s.close();
    }

  
}
