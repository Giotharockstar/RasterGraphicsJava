package Views;

import Graficos.CirculoPuntoMedio;
import Graficos.Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    private Pixel px = new Pixel(this, 2);
    private int[] mask = {1,0,1,1,0,0};
    private CirculoPuntoMedio cs = new CirculoPuntoMedio(px,mask);
    private JPanel area;
    private JLabel status;
    private Image buffer, temporal;
    private int x, y; private double m = 0;

    public Ventana() {
        super("Mi primer ciruclo con máscara...");
        area = new JPanel();
        area.addMouseListener(this);
        area.addMouseMotionListener(this);
        status = new JLabel("Status", JLabel.LEFT);
        getContentPane().add(area, BorderLayout.CENTER);
        getContentPane().add(status, BorderLayout.SOUTH);
        setSize(600,600);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
        buffer = area.createImage(area.getWidth(),area.getHeight());
    }

    public void info() {
        System.out.println("Alumno: Fritz Giovanni Ruiz Velázquez");
        System.out.println("Clase: Gráficos 2D y 3D");
    }

    @Override
    public void actionPerformed(ActionEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        temporal = area.createImage(area.getWidth(), area.getHeight());
        temporal.getGraphics().drawImage(buffer, 0, 0, this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cs.drawCirculo(x,y,e.getX(),e.getY(),Color.BLUE);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        m = (double) (e.getY()-y) / (e.getX()-x);
        cs.drawCirculo(x,y,e.getX(),e.getY(),Color.BLUE);
        area.getGraphics().drawImage(temporal, 0, 0, this);
        cs.drawCirculo(x,y,e.getX(),e.getY(),Color.BLUE);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        status.setText("x=" + e.getX() + ",y=" + e.getY() + ", m= " + m);
    }
}