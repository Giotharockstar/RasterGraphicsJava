package Graficos;

import java.awt.*;

public class CirculoPolar {
    private Pixel px;

    public CirculoPolar(Pixel p){
        px = p;
    }

    public void drawCirculo(int x1, int y1, int x2, int y2, Color c){
        double r = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        for (double i = 0; i < 360; i+=0.125){
            int x = (int) (r * Math.cos(i) + x1);
            int y = (int) (r * Math.sin(i) + y1);
            px.drawPx(x,y,c);
        }
    }
}
