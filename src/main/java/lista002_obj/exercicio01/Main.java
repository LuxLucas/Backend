package lista002_obj.exercicio01;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("Tamanho da senha: ");
        int passwordLength = scan.nextInt();
        Hasher hasher = new Hasher(passwordLength);
        System.out.println("Sua senha é: " + hasher.newPassword()); 
        scan.close();
        */

        JFrame frame = new JFrame("Criador automático de senhas");
        JTextField inputPasswordLength = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JLabel labelPasswordLength = new JLabel("Tamanho da senha:");
        JLabel labelPassword = new JLabel("Senha gerada:");
        JPanel panel = new JPanel();

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new FlowLayout());
        panel.add(labelPasswordLength);
        panel.add(inputPasswordLength);
        panel.add(labelPassword);
        panel.add(passwordField);

        frame.add(panel);
        frame.setVisible(true);
    }
}