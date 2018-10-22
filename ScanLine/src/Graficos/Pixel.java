package Graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel {
    private BufferedImage buffer;
    private JFrame frame; int SIZE;

    public Pixel(JFrame window, int size){
        frame = window; SIZE = size;
        buffer = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
    }

    public void drawPx(int x, int y, Color color){
        for(int i = 0 ; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                buffer.setRGB(i,j,color.getRGB());
            }
        }
        frame.getGraphics().drawImage(buffer,x,y,frame);
    }
}