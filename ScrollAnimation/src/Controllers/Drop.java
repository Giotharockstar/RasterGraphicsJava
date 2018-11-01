package Controllers;

import Graficos.LineaPuntoMedio;
import Graficos.Pixel;

import javax.swing.*;
import java.awt.*;

public class Drop {
    private int x , y, height;
    private float speed = (int) (Math.random() * 4 + 7);
    private int len = (int) (Math.random() * 20 + 10);
    private int size = (int) (Math.random() * 3 + 1);

    public Drop(int width, int height) {
        x = (int) (Math.random() * width + 1);
        y = (int) (Math.random() * -1000 + -50);
        this.height = height;
    }

    public void fall() {
        y = (int) (y + speed);
        speed += 0.05;
        if (y > height) {
            y = (int) (Math.random() * -200 + -100);
            len = (int) (Math.random() * 10 + 20);
            speed = (int) (Math.random() * 4 + 7);
        }
    }

    public void show(JPanel area, Image temporal) {
        Pixel px = new Pixel(area,temporal, size);
        LineaPuntoMedio ln = new LineaPuntoMedio(px);
        ln.drawLinea(x,y,x,y+len, Color.BLUE);
    }
}
