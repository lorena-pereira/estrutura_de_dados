/* 14. Utilizando arrays, faça um programa em Java que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
"Telefonou para a vítima?"
"Esteve no local do crime?"
"Mora perto da vítima?"
"Devia para a vítima?"
"Já trabalhou com a vítima?" 
 O programa deve no final emitir uma classificação sobre a participação da pessoa no crime. Se a pessoa responder positivamente a 2 questões
ela deve ser classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como "Assassino". Caso contrário, ele será classificado como "Inocente".*/
import java.util.Scanner;

public class Questao14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        String[] perguntas = {"Telefonou para a vítima?", "Esteve no local do crime?", "Mora perto da vítima?", "Devia para a vítima?", 
        "Já trabalhou com a vítima?"};

        int contadorRespostas = 0;

        System.out.println("Responda com 'S' para sim ou 'N' para não");
        for(int i = 0; i < perguntas.length; i++){
            System.out.println(perguntas[i]);
            char resposta = s.nextLine().charAt(0);

            if(Character.toUpperCase(resposta) == 'S') {
                contadorRespostas++;
            }
        }

        if(contadorRespostas == 2) {
            System.out.println("A pessoa é considerada Suspeita!");
        }
        else if(contadorRespostas >= 3 && contadorRespostas <= 4) {
            System.out.println("A pessoa é considerada Cúmplice!");
        }
        else if(contadorRespostas == 5) {
            System.out.println("A pessoa é considerada Assassina!");
        }
        else {
            System.out.println("A pessoa é considerada Inocente!");
        }

        s.close();
    }
    
}
