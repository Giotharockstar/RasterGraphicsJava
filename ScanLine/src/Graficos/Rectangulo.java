package Graficos;

import java.awt.*;

public class Rectangulo {
    private LineaDDA ln;

    public Rectangulo(LineaDDA linea) {
        ln = linea;
    }

    public void drawRectangulo(int x1, int y1, int x2, int y2, Color c){
        ln.drawLinea(x1,y1,x2,y1,c);
        ln.drawLinea(x1,y1,x1,y2,c);
        ln.drawLinea(x2,y1,x2,y2,c);
        ln.drawLinea(x1,y2,x2,y2,c);
    }
}
