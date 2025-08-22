package lista001.exercicio03;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Janela Principal");
        JDialog meuDialog = new JDialog(frame,"Caixa de Diálogo");

        JPanel painel = new JPanel();
        JLabel label = new JLabel("Mensagem no diálogo");
        JButton botaoOk = new JButton("OK");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        painel.add(label);
        painel.add(botaoOk);
        meuDialog.getContentPane().add(painel);
        meuDialog.pack();
        meuDialog.setLocationRelativeTo(frame);

        botaoOk.addActionListener(e -> meuDialog.dispose());

        frame.setVisible(true);
        meuDialog.setVisible(true);
    }
}