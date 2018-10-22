package Graficos;

import java.awt.*;

public class CirculoPolar {
    private Pixel px;

    public CirculoPolar(Pixel p){
        px = p;
    }

    public void drawCirculo(int x1, int y1, int x2, int y2, Color c){
        double r = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        double size = 0;
        for (double i = 0; i < 45; i+=0.125){
            if (size != px.SIZE - 1){ size+=0.5; } else {
                int y = (int) (r * Math.sin(Math.toRadians(i)));
                int x = (int) (r * Math.cos(Math.toRadians(i)));
                px.drawPx(x1 + x, y1 + y, c);
                px.drawPx(x1 + y, y1 + x, c);
                px.drawPx(x1 - y, y1 + x, c);
                px.drawPx(x1 - x, y1 + y, c);
                px.drawPx(x1 - x, y1 - y, c);
                px.drawPx(x1 - y, y1 - x, c);
                px.drawPx(x1 + y, y1 - x, c);
                px.drawPx(x1 + x, y1 - y, c);
                size = 0;
            }
        }
    }
}