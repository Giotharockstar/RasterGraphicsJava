package Controllers;

import Graficos.CirculoBresenham;
import Graficos.Pixel;

import javax.swing.*;
import java.awt.*;

public class Arcoiris {
    public void show(JPanel area, Image temporal) {
        Pixel px = new Pixel(area,temporal, 7);
        CirculoBresenham cs = new CirculoBresenham(px);
        cs.drawCirculo(800,300,400,300,Color.RED);
        cs.drawCirculo(800,300,410,300,Color.ORANGE);
        cs.drawCirculo(800,300,420,300,Color.YELLOW);
        cs.drawCirculo(800,300,430,300,Color.GREEN);
        cs.drawCirculo(800,300,440,300,Color.BLUE);
        cs.drawCirculo(800,300,450,300,Color.PINK);
    }
}
