package Graficos;

import java.awt.*;

public class ElipseBresenham {
    private Pixel px;

    public ElipseBresenham(Pixel p){ px = p; }

    public void drawElipse(int xc, int yc, int width, int height, Color c) {
        int a2 = width * width, b2 = height * height, fa2 = 4 * a2, fb2 = 4 * b2, x, y, sigma;

        for (x = 0, y = height, sigma = 2*b2+a2*(1-2*height); b2*x <= a2*y; x++) {
            pxElipse(xc,x,yc,y,c);
            if (sigma >= 0) { sigma += fa2 * (1 - y); y--; }
            sigma += b2 * ((4 * x) + 6);
        }

        for (x = width, y = 0, sigma = 2*a2+b2*(1-2*width); a2*y <= b2*x; y++) {
            pxElipse(xc,x,yc,y,c);
            if (sigma >= 0) { sigma += fb2 * (1 - x); x--; }
            sigma += a2 * ((4 * y) + 6);
        }
    }

    private void pxElipse(int xc, int x, int yc, int y, Color c){
            px.drawPx(xc + x, yc + y, c);
            px.drawPx(xc - x, yc + y, c);
            px.drawPx(xc + x, yc - y, c);
            px.drawPx(xc - x, yc - y, c);
    }
}