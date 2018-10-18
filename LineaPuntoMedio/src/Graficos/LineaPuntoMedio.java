package Graficos;

import java.awt.*;

public class LineaPuntoMedio {
    private int pxSize; private Pixel px;

    public LineaPuntoMedio(Pixel p){
        pxSize = p.SIZE;
        px = p;
    }

    public void drawLinea(int x1, int y1, int x2, int y2, Color c){
        float m = (float) (y2-y1) / (x2-x1), x, y, xi, xf, yi, yf;
        int dy = y1 - y2, dx = x1 - x2;
        int a = (2 * dy), b = (2 * dy) - (2 * dx), pk = (2 * dy) - dx;
        if (m > 1 || m < -1){
            if(y1 < y2) { yi = y1; yf = y2; x = x1; } else { yi = y2; yf = y1; x = x2; }
            for (y = yi; y < yf; y++){
                x += 1 / m;
                if (pk <= 0){
                    pk += a;
                } else {
                    pk += b;
                }
                if (y % pxSize == 0){
                    px.drawPx((int) x, (int) y, c);
                }
            }
        } else {
            if(x1 < x2) { xi = x1; xf = x2; y = y1; } else { xi = x2; xf = x1; y = y2; }
            for (x = xi; x < xf; x++){
                y += m;
                if (pk <= 0){
                    pk += a;
                } else {
                    pk += b;
                }
                if (x % pxSize == 0){
                    px.drawPx((int) x, (int) y, c);
                }
            }
        }
        px.drawPx(x1,y1, Color.GREEN);
        px.drawPx(x2,y2, Color.RED);
    }
}