import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorCorrida extends JFrame implements Runnable {
    private JPanel controladorCorrida;
    private JComboBox corredoresComboBox, tempoComboBox, distanciaComboBox;
    private JButton iniciarButton;
    private JLabel corredor1, corredor2, corredor3, corredor4, corredor5, corredor6, corredor7, corredor8, corredor9, corredor10, corredor11, corredor12, corredor13, corredor14, corredor15;
    private static Integer tempoParada, distanciaCorrida;
    public static Boolean acabou = false;

    public ControladorCorrida() {
        criarComponentes();
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempoParada = Integer.parseInt(tempoComboBox.getSelectedItem().toString());
                distanciaCorrida = Integer.parseInt(distanciaComboBox.getSelectedItem().toString());
                if (acabou) {
                    acabou = false;
                }
                corrida();
            }
        });
    }

    private void corrida() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i < corredoresComboBox.getSelectedIndex() + 2) {
                JLabel posicaoCoredor = null;
                switch (i) {
                    case 0 -> posicaoCoredor = corredor1;
                    case 1 -> posicaoCoredor = corredor2;
                    case 2 -> posicaoCoredor = corredor3;
                    case 3 -> posicaoCoredor = corredor4;
                    case 4 -> posicaoCoredor = corredor5;
                    case 5 -> posicaoCoredor = corredor6;
                    case 6 -> posicaoCoredor = corredor7;
                    case 7 -> posicaoCoredor = corredor8;
                    case 8 -> posicaoCoredor = corredor9;
                    case 9 -> posicaoCoredor = corredor10;
                    case 10 -> posicaoCoredor = corredor11;
                    case 11 -> posicaoCoredor = corredor12;
                    case 12 -> posicaoCoredor = corredor13;
                    case 13 -> posicaoCoredor = corredor14;
                    case 14 -> posicaoCoredor = corredor15;
                }
                posicaoCoredor.setVisible(true);
                threads.add(new Thread(new Corredor(i + 1, tempoParada, distanciaCorrida, posicaoCoredor), "Corredor 1"));
            } else {
                switch (i) {
                    case 0 -> corredor1.setVisible(false);
                    case 1 -> corredor2.setVisible(false);
                    case 2 -> corredor3.setVisible(false);
                    case 3 -> corredor4.setVisible(false);
                    case 4 -> corredor5.setVisible(false);
                    case 5 -> corredor6.setVisible(false);
                    case 6 -> corredor7.setVisible(false);
                    case 7 -> corredor8.setVisible(false);
                    case 8 -> corredor9.setVisible(false);
                    case 9 -> corredor10.setVisible(false);
                    case 10 -> corredor11.setVisible(false);
                    case 11 -> corredor12.setVisible(false);
                    case 12 -> corredor13.setVisible(false);
                    case 13 -> corredor14.setVisible(false);
                    case 14 -> corredor15.setVisible(false);
                }
            }

        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private void criarComponentes() {
        for (int i = 1; i < 15; i++) {
            corredoresComboBox.addItem(i + 1);
        }
        for (int i = 0; i < 10; i++) {
            Integer numero = (i + 1) * 25;
            tempoComboBox.addItem(numero);
            if(numero == 100){
                tempoComboBox.setSelectedItem(numero);
            }
        }
        for (int i = 0; i < 10; i++) {
            Integer numero = (i + 1) * 50;
            distanciaComboBox.addItem(numero);
            if(numero == 250){
                distanciaComboBox.setSelectedItem(numero);
            }
        }

        corredor1.setVisible(false);
        corredor2.setVisible(false);
        corredor3.setVisible(false);
        corredor4.setVisible(false);
        corredor5.setVisible(false);
        corredor6.setVisible(false);
        corredor7.setVisible(false);
        corredor8.setVisible(false);
        corredor9.setVisible(false);
        corredor10.setVisible(false);
        corredor11.setVisible(false);
        corredor12.setVisible(false);
        corredor13.setVisible(false);
        corredor14.setVisible(false);
        corredor15.setVisible(false);

        setContentPane(controladorCorrida);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela já está aberta");
        }
    }

    public static void setAcabou(Boolean acabou) {
        ControladorCorrida.acabou = acabou;
    }

}
