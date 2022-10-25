import javax.swing.*;
import java.util.Random;

public class Corredor implements Runnable{

    private final Integer idCorredor, tempoEspera, distanciaFinal;
    private final JProgressBar barCorredor;
    private Integer distanciaAtual = 0;

    public Corredor(Integer idCorredor, Integer tempoEspera, Integer distanciaFinal, JProgressBar barCorredor) {
        this.idCorredor = idCorredor;
        this.tempoEspera = tempoEspera;
        this.distanciaFinal = distanciaFinal;
        this.barCorredor = barCorredor;
    }

    @Override
    public synchronized void run() {
        Random random = new Random();

        while(!ControladorCorrida.acabou){
            try {
                Integer distanciaPercorrida = random.nextInt(5);

                setdistanciaAtual(distanciaAtual + distanciaPercorrida);
                if(distanciaAtual >= distanciaFinal){
                    ControladorCorrida.setAcabou(true);
                    setBarCorredor("Corredor " + idCorredor + " chegou aos" + distanciaFinal + "m, Venceu!");
                } else {
                    setBarCorredor("Corredor " + idCorredor + " está em " + distanciaAtual + " metros");
                }

                Thread.sleep((long) (Math.random() * tempoEspera));
            } catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    public void setdistanciaAtual(Integer distanciaAtual) {
        this.distanciaAtual = distanciaAtual;
    }

    public void setBarCorredor(String text) {
        int conta = (this.distanciaAtual * 100)/distanciaFinal;
        this.barCorredor.setValue(conta);
    }
}
