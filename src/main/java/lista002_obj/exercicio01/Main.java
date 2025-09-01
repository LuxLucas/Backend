package lista002_obj.exercicio01;

import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Tamanho da senha: ");
        int passwordLength = scan.nextInt();
        Hasher hasher = new Hasher(passwordLength);
        System.out.println("Sua senha é: " + hasher.newPassword()); 
        scan.close();
    }
}