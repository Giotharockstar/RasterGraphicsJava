package Graficos;

import java.awt.*;

public class CirculoPuntoMedio {
    private Pixel px;
    private int size;

    public CirculoPuntoMedio(Pixel p){
        px = p;
    }

    public void drawCirculo(int x1, int y1, int x2, int y2, Color c){
        int r = (int) (Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));
        int x = r, y = 0; int P = 5/4 - r; pxIniciales(x,x1,y,y1,c); size = 0;
        while (x > y) {
            if (P <= 0) {
                y++;
                P = P + 2*y + 3;
            } else {
                y++; x--; P = P + 2*y - 2*x + 5;
                if (x < y) { break; }
            }
            paintPixels(x,y,x1,y1,c);
        }
    }

    private void paintPixels(int x, int y, int x1, int y1, Color c){
        if (size != px.SIZE - 1){ size++; } else {
            px.drawPx( x + x1, y + y1, c);
            px.drawPx( -x + x1, y + y1, c);
            px.drawPx( x + x1, -y + y1, c);
            px.drawPx( -x + x1, -y + y1, c);
            px.drawPx( y + x1, x + y1, c);
            px.drawPx( -y + x1, x + y1, c);
            px.drawPx( y + x1, -x + y1, c);
            px.drawPx( -y + x1, -x + y1, c);
            size = 0;
        }
    }

    private void pxIniciales(int x, int x1, int y, int y1, Color c){
        px.drawPx( x + x1, y + y1, c);
        px.drawPx( -x + x1, y + y1, c);
        px.drawPx( y + x1, x + y1, c);
        px.drawPx( y + x1, -x + y1, c);
    }
}