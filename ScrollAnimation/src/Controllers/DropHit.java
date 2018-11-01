package Controllers;

import Graficos.CirculoBresenham;
import Graficos.Pixel;

import javax.swing.*;
import java.awt.*;

public class DropHit {
    private double x,y,width,height;

    public DropHit(double w, double h) {
        width = w; height = h;
        x = Math.random() * -width + width;
        y = Math.random() *  height/2 + height/2;
    }

    public void update() {
        x = Math.random() * -width + width;
        y = Math.random() * height/2 + height/2;
    }

    public void show(JPanel area, Image temporal) {
        Pixel px = new Pixel(area,temporal, 1);
        CirculoBresenham cs = new CirculoBresenham(px);
        cs.drawCirculo((int)x,(int)y,(int) x + (int) (Math.random() * 3 + 1),(int) y + (int) (Math.random() * 3 + 1), Color.BLUE);
    }
}
