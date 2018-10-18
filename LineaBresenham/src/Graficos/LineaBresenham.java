package Graficos;

import java.awt.*;

public class LineaBresenham {
    private int pxSize; private Pixel px;

    public LineaBresenham(Pixel p){
        pxSize = p.SIZE;
        px = p;
    }

    public void drawLinea(int x1, int y1, int x2, int y2, Color c){
        float m = (float) (y2-y1) / (x2-x1), x, y, xi, xf, yi, yf, e = 0;
        if (m > 1 || m < -1){
            int dx = x1 - x2, dy = y1 - y2; float de = Math.abs(dx/dy);
            if (y1 > y2) { yf = y1; yi = y2; x = x2; } else { yf = y2; yi = y1; x = x1; }
            for (y = yi; y < yf; y++) {
                if (y % pxSize == 0) {
                    px.drawPx((int)x, (int) y, c);
                }
                e += de;
                x += 1 / m;
                if (e >= 0.5){
                    x += Math.abs(dx);
                    e += -1;
                }
            }
        } else {
            int dx = x2 - x1, dy = y2 - y1; float de = Math.abs(dy/dx);
            if (x1 > x2) { xf = x1; xi = x2; y = y2; } else { xf = x2; xi = x1; y = y1; }
            for (x = xi; x < xf; x++){
                if(x % pxSize == 0) {
                    px.drawPx((int) x, (int) y, c);
                }
                e += de;
                y += m;
                if (e >= 0.5) {
                    y += Math.abs(dy);
                    e += -1;
                }
            }
        }
        px.drawPx(x1,y1, Color.GREEN);
        px.drawPx(x2,y2, Color.RED);
    }
}