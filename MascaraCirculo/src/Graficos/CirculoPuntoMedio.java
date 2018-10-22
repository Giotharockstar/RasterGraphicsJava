package Graficos;

import java.awt.*;

public class CirculoPuntoMedio {
    private Pixel px; private int[] mask;
    private int pxSize, pos, size;

    public CirculoPuntoMedio(Pixel p, int[] m){ pxSize = p.SIZE; px = p; mask = m; }

    public void drawCirculo(int x1, int y1, int x2, int y2, Color c){
        int r = (int) (Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));
        int x = r, y = 0; int P = 5/4 - r;
        pos = 0; size = 0;
        while (x > y) {
            if (P <= 0) {
                y++;
                P = P + 2*y + 3;
            } else {
                y++; x--; P = P + 2*y - 2*x + 5;
                if (x < y) { break; }
            }
            paintPixels(x, y, x1, y1, c);
        }
    }

    private void paintPixels(int x, int y, int x1, int y1, Color c){
        if (size != pxSize - 1){ size++; } else {
            if (mask[pos] == 1){
                px.drawPx( x + x1, y + y1, c);
                px.drawPx( -x + x1, y + y1, c);
                px.drawPx( x + x1, -y + y1, c);
                px.drawPx( -x + x1, -y + y1, c);
                px.drawPx( y + x1, x + y1, c);
                px.drawPx( -y + x1, x + y1, c);
                px.drawPx( y + x1, -x + y1, c);
                px.drawPx( -y + x1, -x + y1, c);
            }
            if (pos != mask.length - 1){ pos++; } else { pos = 0; }
            size = 0;
        }
    }
}