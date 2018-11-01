package Graficos;

import java.awt.*;

class LineaDDA {
    private Pixel px;

    LineaDDA(Pixel p){
        px = p;
    }

    void drawLinea(int x1, int y1, int x2, int y2, Color c){
        float m = (float) (y2-y1) / (x2-x1), x, y;
        if (m > 1 || m < -1){
            if (y1 > y2) { y = y2; x = x2; } else { y = y1; x = x1;}
            for (int i = 0; i < Math.abs(y1-y2); i++) {
                x += 1 / m; y++;
                px.drawPx((int) x, (int) y, c);
            }
        } else {
            if (x1 > x2) { x = x2; y = y2; } else { x = x1; y = y1;}
            for (int i = 0; i < Math.abs(x1-x2); i++) {
                y += m; x++;
                px.drawPx((int) x, (int) y, c);
            }
        }
        px.drawPx(x1,y1, c);
        px.drawPx(x2,y2, c);
    }
}