package Views;

import Graficos.LineaDDA;
import Graficos.Pixel;
import Graficos.Rectangulo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Ventana extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    private Pixel px = new Pixel(this, 3);
    private LineaDDA ln = new LineaDDA(px);
    private Rectangulo rc = new Rectangulo(ln);
    private JLabel status; private Color c;
    private BufferedImage buffer;


    public Ventana() {
        super("Mi primer fill inundacion...");
        JPanel area = new JPanel();
        area.addMouseListener(this);
        area.addMouseMotionListener(this);
        status = new JLabel("Status", JLabel.LEFT);
        getContentPane().add(area, BorderLayout.CENTER);
        getContentPane().add(status, BorderLayout.SOUTH);
        setSize(600,600);
        setResizable(false);
        setVisible(true);
        c = Color.RED;
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
    }

    public void info() {
        System.out.println("Alumno: Fritz Giovanni Ruiz Velázquez");
        System.out.println("Clase: Gráficos 2D y 3D");
    }

    @Override
    public void paint(Graphics g) {
        rc.drawRectangulo(50,50,150,150,c);
        ln.drawLinea(203,109,335,162,c);
        ln.drawLinea(335,162,463,62,c);
        ln.drawLinea(463,62,458,253,c);
        ln.drawLinea(458,253,181,242,c);
        ln.drawLinea(181,242,203,109,c);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            Robot robot = new Robot();
            Rectangle area = new Rectangle(0, 0, 600, 600);
            buffer = robot.createScreenCapture(area);
            floodFill(e.getX(), e.getY(), c);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
    }

    private void floodFill(int x, int y, Color c) {
        if (buffer.getRGB(x,y) == -1){
            px.drawPx(x,y,c);
            floodFill(x+1,y,c);
            floodFill(x-1,y,c);
            floodFill(x,y-1,c);
            floodFill(x,+1,c);
        }
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
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {
        status.setText("x=" + e.getX() + ",y=" + e.getY());
    }
}