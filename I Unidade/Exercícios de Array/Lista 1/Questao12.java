/* 12. Foram anotadas as idades e alturas de 30 alunos. Faça um programa em Java que determine quantos alunos com mais de 13 anos possuem
altura inferior à média de altura desses alunos.*/
public class Questao12 {
    public static void main(String[] args) {
        int[] idade = {9, 15, 11, 14, 10, 18, 9, 17, 16, 15, 13, 15, 12, 16, 10, 17, 10, 14, 16, 11, 14, 18, 17, 15, 14, 16, 17, 13, 16, 18};
        double[] altura = {1.35, 1.50, 1.54, 1.60, 1.33, 1.70, 1.30, 1.62, 1.60, 1.55, 1.74, 1.33, 1.49, 1.59, 1.44, 1.66, 1.38, 1.52, 1.43, 1.80, 1.76, 1.65, 1.59, 1.57, 1.62, 1.77, 1.76, 1.47, 1.53, 1.81};

        double somaAltura = 0;
        double mediaAltura = 0;
        int alunosAcimaMedia = 0;

        for(int i = 0; i < altura.length; i++) {
            somaAltura += altura[i];
        }

        mediaAltura = somaAltura / 30;

        for(int i = 0; i < 30; i++) {
            if(idade[i] > 13 && altura[i] > mediaAltura) {
                alunosAcimaMedia++;
            }
        }

        System.out.println("Possuem " + alunosAcimaMedia + " alunos com altura acima da média");
    }
    
}
