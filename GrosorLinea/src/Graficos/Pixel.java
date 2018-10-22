package Graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel {
    private BufferedImage buffer;
    private JFrame frame; private int SIZE = 1;

    public Pixel(JFrame window){
        frame = window;
        buffer = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
    }

    void drawPx(int x, int y, Color color){
        for(int i = 0 ; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                buffer.setRGB(i,j,color.getRGB());
            }
        }
        frame.getGraphics().drawImage(buffer,x,y,frame);
    }

    public void setS(char e) {
        if (e == '+'){
            SIZE++;
            buffer = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
        } else if (e == '-') {
            if (SIZE - 1 != 0){
                SIZE--;
                buffer = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
            }
        }
    }
}