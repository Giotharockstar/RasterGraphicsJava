package Graficos;

import java.awt.*;

public class Rectangulo {
    private LineaDDA ln; private Pixel px;

    public Rectangulo(Pixel px) { this.px = px; ln = new LineaDDA(px); }

    public void drawRectangulo(int x1, int y1, int x2, int y2, Color c){
        ln.drawLinea(x1,y1,x2,y1,c);
        ln.drawLinea(x1,y1,x1,y2,c);
        ln.drawLinea(x2,y1,x2,y2,c);
        ln.drawLinea(x1,y2,x2,y2,c);
        px.drawPx(x1,y1,Color.GREEN);
        px.drawPx(x2,y2,Color.RED);
    }
}