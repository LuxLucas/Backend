package lista001.exercicio03;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JOptionPane modal = new JOptionPane();

        frame.setSize(300, 400);
        frame.setVisible(true);

        String texto = modal.showInputDialog("Pressione algo");

        System.out.println(texto);
    }
}