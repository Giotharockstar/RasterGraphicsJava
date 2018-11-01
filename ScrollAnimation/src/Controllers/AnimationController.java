package Controllers;

import Views.Ventana;

public class AnimationController implements Runnable{
    private Ventana window;

    public AnimationController() {
        window = new Ventana();
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            try {
                Thread.sleep(0);
                window.animate();
            } catch (InterruptedException ignored) {
                exit = true;
            }
        }
    }

    public void info() {
        System.out.println("Alumno: Fritz Giovanni Ruiz Velázquez");
        System.out.println("Clase: Gráficos 2D y 3D");
    }
}