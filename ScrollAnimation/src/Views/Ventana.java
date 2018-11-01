package Views;

import Controllers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame {
    private JPanel area; private Image buffer;
    private Drop[] drops = new Drop[150];
    private DropHit[] dropHits = new DropHit[50];

    public Ventana() {
        super("Lluvia...");
        area = new JPanel();
        setSize(800,600);
        setResizable(false);
        getContentPane().add(area, BorderLayout.CENTER);
        setVisible(true);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
        buffer = area.createImage(area.getWidth(),area.getHeight());
        for (int i = 0; i < drops.length; i++){
            drops[i] = new Drop(area.getWidth(),area.getHeight());
        }
        for (int i = 0; i < dropHits.length; i++){
            dropHits[i] = new DropHit(area.getWidth(),area.getHeight());
        }
    }

    public void animate(){
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Image temporal = area.createImage(area.getWidth(), area.getHeight());
        temporal.getGraphics().drawImage(buffer, 0, 0, this);



        Sky sky = new Sky();
        for (int x = 0; x < area.getWidth(); x+=100){
            sky.draw(area,temporal,x,0);
            sky.draw(area,temporal,x,75);
            sky.draw(area,temporal,x, 175);
        }

        Arcoiris arcoiris = new Arcoiris();
        arcoiris.show(area,temporal);

        Ground terrain = new Ground();
        for (int x = 0; x < area.getWidth(); x+=100){
            terrain.draw(area,temporal,x,275);
            terrain.draw(area,temporal,x,375);
            terrain.draw(area,temporal,x, 475);
        }

        for (Drop drop : drops) {
            drop.fall();
            drop.show(area,temporal);
        }
        for (DropHit dropHit : dropHits) {
            dropHit.update();
            dropHit.show(area,temporal);
        }


        area.getGraphics().drawImage(temporal, 0, 0, this);
    }
}