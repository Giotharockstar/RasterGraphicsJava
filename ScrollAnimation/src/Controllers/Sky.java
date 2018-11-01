package Controllers;

import Graficos.LineaPuntoMedio;
import Graficos.Pixel;

import javax.swing.*;
import java.awt.*;

public class Sky {
    public void draw(JPanel area, Image temporal, int x, int y){
        int pxSize = 5; Color c;
        Pixel px = new Pixel(area,temporal, pxSize);
        LineaPuntoMedio ln = new LineaPuntoMedio(px);
        int rgb = 255;
        for (int i = 0; i < 100; i+= pxSize) {
            rgb-=5; c = new Color(100,100, rgb);
            ln.drawLinea(x,y+i,x+100,y+i, c);
        }
    }
}
