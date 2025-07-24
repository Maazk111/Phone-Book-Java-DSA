package Main_Package;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    Clip clip;

    String[] soundURL = new String[12];

    public Sound() {
        this.soundURL[0] ="src/Sound/0.wav";
        this.soundURL[1] ="src/Sound/1.wav";
        this.soundURL[2] ="src/Sound/2.wav";
        this.soundURL[3] ="src/Sound/3.wav";
        this.soundURL[4] ="src/Sound/4.wav";
        this.soundURL[5] ="src/Sound/5.wav";
        this.soundURL[6] ="src/Sound/6.wav";
        this.soundURL[7] ="src/Sound/7.wav";
        this.soundURL[8] ="src/Sound/8.wav";
        this.soundURL[9] ="src/Sound/9.wav";

        this.soundURL[10] ="src/Sound/star.wav";
        this.soundURL[11] ="src/Sound/#.wav";
    }

    public void setFile(int i) {
        try {
            File file = new File(soundURL[i]);
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Play() {

        clip.start();

    }
}
