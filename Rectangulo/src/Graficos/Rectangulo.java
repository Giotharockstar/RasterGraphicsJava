package Graficos;

import java.awt.*;

public class Rectangulo {
    private Linea linea;

    public Rectangulo(Linea ln) {
        linea = ln;
    }

    public void drawRectangulo(int x1, int y1, int x2, int y2, Color c){
        linea.drawLinea(x1,y1,x2,y1,c);
        linea.drawLinea(x1,y1,x1,y2,c);
        linea.drawLinea(x2,y1,x2,y2,c);
        linea.drawLinea(x1,y2,x2,y2,c);
    }
}
