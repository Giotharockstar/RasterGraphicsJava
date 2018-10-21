package Graficos;

import java.awt.*;

public class CirculoCartesiano {
    private int pxSize; private Pixel px;

    public CirculoCartesiano(Pixel p){
        pxSize = p.SIZE;
        px = p;
    }

    public void drawCirculo(int x1, int y1, int x2, int y2, Color c){
        double r = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        double SR, r2 = r * r;
        for (int i = 0; i < (r*2); i++){
            SR = Math.sqrt(r2 - (Math.pow((r-i),2)));
            if ((i-1+x1) % pxSize == 0){
                px.drawPx(i+x1, (int) (r+SR) + y1, c);
                px.drawPx(i+x1, (int) (r-SR) + y1, c);
            }
        }
    }
}
