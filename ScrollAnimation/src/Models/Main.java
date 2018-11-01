package Models;


import Controllers.AnimationController;

import java.io.File;
import javax.sound.sampled.*;

public class Main {

    public static void main(String[] args) throws Exception {
        File fl = new File("rain.wav");
        Clip clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.
                getAudioInputStream( fl );
        clip.open(ais);
        clip.loop(100);
        AnimationController window = new AnimationController();
        window.info();
    }
}
