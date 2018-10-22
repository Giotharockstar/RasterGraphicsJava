package Graficos;

import java.awt.*;

public class CirculoBresenham {
    private Pixel px;
    private int size;

    public CirculoBresenham(Pixel p){
        px = p;
    }

    public void drawCirculo(int x1, int y1, int x2, int y2, Color c){
        double r = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        double x = 0, y = r, delta = 2 - (2 * r), e; pxIniciales((int) r,x1, y1,c); size = 0;
        while (y >= 0) {
            paintPixels(x,y,x1,y1,c);
            e = 2 * (delta + y) - 1;
            if (delta < 0 && e <= 0){
                x++;
                delta += 2 * x + 1;
                continue;
            }
            e = 2 * (delta - x) - 1;
            if(delta > 0 && e > 0) {
                y--;
                delta += 1 - 2 * y;
                continue;
            }
            x++;
            delta += 2 * (x - y);
            y--;
        }
    }

    private void paintPixels(double x, double y, int x1, int y1, Color c){
        if (size != px.SIZE - 1){ size++; } else {
            px.drawPx(x1 + (int) x, y1 + (int) y, c);
            px.drawPx(x1 - (int) x, y1 + (int) y, c);
            px.drawPx(x1 + (int) x, y1 - (int) y, c);
            px.drawPx(x1 - (int) x, y1 - (int) y, c);
            size = 0;
        }
    }

    private void pxIniciales(int x, int x1, int y1, Color c){
        px.drawPx( x + x1 + 1, y1, c);
        px.drawPx( -x + x1 - 1, y1, c);
        px.drawPx(x1, x + y1, c);
        px.drawPx(x1, -x + y1, c);
    }
}