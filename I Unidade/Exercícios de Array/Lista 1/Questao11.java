// 11. Altere o programa anterior, intercalando 3 vetores de 10 elementos cada.
import java.util.Scanner;

public class Questao11 {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        int[] a = new int[10];
        int[] b = new int[10];
        int[] c = new int[10];
        int[] d = new int[30];
        
        System.out.println("Digite 10 números: ");
        for(int i = 0; i < a.length; i++) {
            a[i] = s.nextInt(); 
        }
        
        System.out.println("\nDigite 10 números novamente: ");
        for(int i = 0; i < b.length; i++) {
            b[i] = s.nextInt(); 
        }

        System.out.println("\nDigite 10 números novamente: ");
        for(int i = 0; i < b.length; i++) {
            c[i] = s.nextInt(); 
        }

        System.out.println();
        for(int i = 0; i < d.length; i++) {
            System.out.println(a[i]);
            System.out.println(b[i]);
            System.out.println(c[i]);
        }
        
        s.close();
    }
}
