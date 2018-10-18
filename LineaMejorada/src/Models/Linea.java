package Models;

import java.awt.*;

public class Linea {
    private int pxSize; private Pixel px;

    public Linea(Pixel p){
        pxSize = p.SIZE;
        px = p;
    }

    public void drawLinea(int x1, int y1, int x2, int y2, Color c){
        double m = (double) (y2-y1) / (x2-x1);
        if (m > 1 || m < -1){
            int yi, yf;
            if(y1 > y2){ yi = y2; yf = y1; } else { yi = y1; yf = y2; }
            for(int y = yi; y < yf; y++){
                if(y % pxSize == 0) {
                    int x = (int) ((y-y1) / m) + x1;
                    px.drawPx(x, y, c);
                }
            }
        } else {
            int xi, xf;
            if(x1 > x2){ xi = x2; xf = x1; } else { xi = x1; xf = x2; }
            for(int x = xi; x < xf; x++){
                if(x % pxSize == 0) {
                    int y = (int) (m * (x-x1)) + y1;
                    px.drawPx(x, y, c);
                }
            }
        }
        px.drawPx(x1,y1, Color.GREEN);
        px.drawPx(x2,y2, Color.RED);
    }
}
