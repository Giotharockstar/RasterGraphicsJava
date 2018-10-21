package Views;

import Graficos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    private Pixel px = new Pixel(this, 5);
    private LineaPuntoMedio ln = new LineaPuntoMedio(px);
    private Rectangulo rc = new Rectangulo(px);
    private CirculoPuntoMedio cs = new CirculoPuntoMedio(px);
    private ElipseBresenham ep = new ElipseBresenham(px);

    public Ventana() {
        super("Figuras..");
        setSize(800,600);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
    }

    public void info() {
        System.out.println("Alumno: Fritz Giovanni Ruiz Velázquez");
        System.out.println("Clase: Gráficos 2D y 3D");
    }

    @Override
    public void paint(Graphics g) {
        Color c = Color.BLACK;
        //Lineas
        ln.drawLinea(250,200,100,75, c);
        ln.drawLinea(250,100,400,100, c);
        ln.drawLinea(725,75,600,200, c);
        ln.drawLinea(600,100,450,100, c);
        //Circulos
        cs.drawCirculo(175,400,75,400, c);
        cs.drawCirculo(175,400,95,400, c);
        cs.drawCirculo(175,400,115,400, c);
        cs.drawCirculo(175,400,150,400, c);
        //Rectangulos
        rc.drawRectangulo(300,350,500,450, c);
        rc.drawRectangulo(475,425,325,375, c);
        //Elipses
        ep.drawElipse(650,400,125,75, c);
        ep.drawElipse(650,400,100,50, c);
        ep.drawElipse(650,400,75,25, c);
        ep.drawElipse(650,400,60,10, c);
    }
}