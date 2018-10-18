package Views;

import Models.Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame {
    private Pixel px = new Pixel(this, 10);

    public Ventana() {
        super("Mi primer pixel...");
        setSize(600,600);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
    }

    public void paint(Graphics g) {
        px.drawPx(150,150, Color.RED);
    }

    public void info() {
        System.out.println("Alumno: Fritz Giovanni Ruiz Velázquez");
        System.out.println("Clase: Gráficos 2D y 3D");
    }
}