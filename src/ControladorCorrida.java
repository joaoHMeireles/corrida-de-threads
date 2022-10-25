import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorCorrida extends JFrame implements Runnable {
    private JPanel controladorCorrida;
    private JComboBox corredoresComboBox, tempoComboBox, distanciaComboBox;
    private JButton iniciarButton;
    private JProgressBar corredor1, corredor2, corredor3, corredor4, corredor5, corredor6,
            corredor7, corredor8, corredor9, corredor10, corredor11, corredor12, corredor13,
            corredor14, corredor15;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9,
            label10, label11, label12, label13, label14, label15;
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
                JProgressBar posicaoCoredor = null;
                switch (i) {
                    case 0 -> {
                        posicaoCoredor = corredor1;
                        corredor1.setVisible(true);
                        label1.setVisible(true);
                    }
                    case 1 -> {
                        posicaoCoredor = corredor2;
                        corredor2.setVisible(true);
                        label2.setVisible(true);
                    }
                    case 2 -> {
                        posicaoCoredor = corredor3;
                        corredor3.setVisible(true);
                        label3.setVisible(true);
                    }
                    case 3 -> {
                        posicaoCoredor = corredor4;
                        corredor4.setVisible(true);
                        label4.setVisible(true);
                    }
                    case 4 -> {
                        posicaoCoredor = corredor5;
                        corredor5.setVisible(true);
                        label5.setVisible(true);
                    }
                    case 5 -> {
                        posicaoCoredor = corredor6;
                        corredor6.setVisible(true);
                        label6.setVisible(true);
                    }
                    case 6 -> {
                        posicaoCoredor = corredor7;
                        corredor7.setVisible(true);
                        label7.setVisible(true);
                    }
                    case 7 -> {
                        posicaoCoredor = corredor8;
                        corredor8.setVisible(true);
                        label8.setVisible(true);
                    }
                    case 8 -> {
                        posicaoCoredor = corredor9;
                        corredor9.setVisible(true);
                        label9.setVisible(true);
                    }
                    case 9 -> {
                        posicaoCoredor = corredor10;
                        corredor10.setVisible(true);
                        label10.setVisible(true);
                    }
                    case 10 -> {
                        posicaoCoredor = corredor11;
                        corredor11.setVisible(true);
                        label11.setVisible(true);
                    }
                    case 11 -> {
                        posicaoCoredor = corredor12;
                        corredor12.setVisible(true);
                        label12.setVisible(true);
                    }
                    case 12 -> {
                        posicaoCoredor = corredor13;
                        corredor13.setVisible(true);
                        label13.setVisible(true);
                    }
                    case 13 -> {
                        posicaoCoredor = corredor14;
                        corredor14.setVisible(true);
                        label14.setVisible(true);
                    }
                    case 14 -> {
                        posicaoCoredor = corredor15;
                        corredor15.setVisible(true);
                        label15.setVisible(true);
                    }

                }
                threads.add(new Thread(new Corredor(i + 1, tempoParada, distanciaCorrida, posicaoCoredor), "Corredor 1"));
            } else {
                switch (i) {
                    case 0 -> {
                        corredor1.setVisible(false);
                        label1.setVisible(false);
                    }
                    case 1 -> {
                        corredor2.setVisible(false);
                        label2.setVisible(false);
                    }
                    case 2 -> {
                        corredor3.setVisible(false);
                        label3.setVisible(false);
                    }
                    case 3 -> {
                        corredor4.setVisible(false);
                        label4.setVisible(false);
                    }
                    case 4 -> {
                        corredor5.setVisible(false);
                        label5.setVisible(false);
                    }
                    case 5 -> {
                        corredor6.setVisible(false);
                        label6.setVisible(false);
                    }
                    case 6 -> {
                        corredor7.setVisible(false);
                        label7.setVisible(false);
                    }
                    case 7 -> {
                        corredor8.setVisible(false);
                        label8.setVisible(false);
                    }
                    case 8 -> {
                        corredor9.setVisible(false);
                        label9.setVisible(false);
                    }
                    case 9 -> {
                        corredor10.setVisible(false);
                        label10.setVisible(false);
                    }
                    case 10 -> {
                        corredor11.setVisible(false);
                        label11.setVisible(false);
                    }
                    case 11 -> {
                        corredor12.setVisible(false);
                        label12.setVisible(false);
                    }
                    case 12 -> {
                        corredor13.setVisible(false);
                        label13.setVisible(false);
                    }
                    case 13 -> {
                        corredor14.setVisible(false);
                        label14.setVisible(false);
                    }
                    case 14 -> {
                        corredor15.setVisible(false);
                        label15.setVisible(false);
                    }
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
            if (numero == 100) {
                tempoComboBox.setSelectedItem(numero);
            }
        }
        for (int i = 0; i < 10; i++) {
            Integer numero = (i + 1) * 50;
            distanciaComboBox.addItem(numero);
            if (numero == 250) {
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

        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        label8.setVisible(false);
        label9.setVisible(false);
        label10.setVisible(false);
        label11.setVisible(false);
        label12.setVisible(false);
        label13.setVisible(false);
        label14.setVisible(false);
        label15.setVisible(false);

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
