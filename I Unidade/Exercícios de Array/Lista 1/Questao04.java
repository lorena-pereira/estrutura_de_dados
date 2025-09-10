// 4. Faça um programa em Java que leia um vetor de 10 caracteres, e diga quantas consoantes foram lidas. Imprima as consoantes.
public class Questao04 {
    public static void main(String[] args) {
        char[] caracteres = {'a', '2', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        int consoantes = 0;
        String consoantesEncontradas = "";

        for(int i = 0; i < caracteres.length; i++) {
            char caracter = Character.toLowerCase(caracteres[i]);
            if(caracter >= 'a' && caracter <= 'z' && caracter != 'a' && caracter != 'e' && caracter != 'i' && caracter != 'o' && caracter != 'u') {
                consoantes++;
                consoantesEncontradas += caracteres[i];
            }
        }

        if(consoantes > 0) {
                System.out.println("Foram lidas " + consoantes + " consoantes");
                System.out.println("Sendo elas: " + consoantesEncontradas);
            }
            else {    
                System.out.println("Não foi lida nenhuma consoante");
            }
    }
}    

