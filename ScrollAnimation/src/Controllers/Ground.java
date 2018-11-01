package Controllers;

import Graficos.LineaPuntoMedio;
import Graficos.Pixel;

import javax.swing.*;
import java.awt.*;

public class Ground {
    public void draw(JPanel area, Image temporal, int x, int y){
        int pxSize = 3; Color c;
        Pixel px = new Pixel(area,temporal, pxSize);
        LineaPuntoMedio ln = new LineaPuntoMedio(px);
        int rgb = 20;
        for (int i = 0; i < 100; i+= pxSize) {
            rgb+=2; c = new Color(160,rgb+100, rgb);
            ln.drawLinea(x,y+i,x+100,y+i, c);
        }
        ln.drawLinea(x+1,y+1,x+1,y-20,Color.GREEN);
        ln.drawLinea(x+1,y+1,x+10,y-11,Color.GREEN);
        ln.drawLinea(x+1,y+1,x-10,y-11,Color.GREEN);
        ln.drawLinea(x+1+50,y+1+50,x+1+50,y-20+50,Color.GREEN);
        ln.drawLinea(x+1+50,y+1+50,x+10+50,y-11+50,Color.GREEN);
        ln.drawLinea(x+1+50,y+1+50,x-10+50,y-11+50,Color.GREEN);
    }
}
