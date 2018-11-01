package Graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel {
    private BufferedImage buffer;
    private JPanel frame;
    int SIZE;
    private Image temporal;

    public Pixel(JPanel window, Image temp, int size){
        frame = window; SIZE = size; temporal = temp;
        buffer = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
    }

    void drawPx(int x, int y, Color color){
        for(int i = 0 ; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                buffer.setRGB(i,j,color.getRGB());
            }
        }
        temporal.getGraphics().drawImage(buffer,x,y,frame);
    }
}