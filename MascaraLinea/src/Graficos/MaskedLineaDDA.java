package Graficos;

import java.awt.*;

public class MaskedLineaDDA {
    private int pxSize, pos, size;
    private int[] mask;
    private Pixel px;


    public MaskedLineaDDA(Pixel p, int[] m){ pxSize = p.SIZE; px = p; mask = m; }

    public void drawLinea(int x1, int y1, int x2, int y2, Color c){
        float m = (float) (y2-y1) / (x2-x1), x, y; pos = 0; size = 0;
        if (m > 1 || m < -1){
            if (y1 > y2) { y = y2; x = x2; } else { y = y1; x = x1;}
            for (int i = 0; i < Math.abs(y1-y2); i++) {
                x += 1 / m; y++;
                paintPixels(x,y,c);
            }
        } else {
            if (x1 > x2) { x = x2; y = y2; } else { x = x1; y = y1;}
            for (int i = 0; i < Math.abs(x1-x2); i++) {
                y += m; x++;
                paintPixels(x,y,c);
            }
        }
        px.drawPx(x1,y1, Color.GREEN);
        px.drawPx(x2,y2, Color.RED);
    }

    private void paintPixels(float x, float y, Color c){
        if (size != pxSize - 1){ size++; } else {
            if (mask[pos] == 1){ px.drawPx((int) x, (int) y, c); }
            if (pos != mask.length - 1){ pos++; } else { pos = 0; }
            size = 0;
        }
    }
}