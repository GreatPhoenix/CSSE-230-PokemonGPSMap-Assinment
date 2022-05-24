import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.SourceDataLine;

public class MusicPlayer {
	ArrayList<String> files;

	public MusicPlayer() {
		files = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			files.add("GUImusic" + Integer.toString(i) + ".wav");
		}
		playMusic();
	}

	public void playMusic() {		
		 byte[] buffer = new byte[4096];
		    for (String filePath : files) {
		        File file = new File(filePath);
		        try {
		            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		            AudioFormat format = stream.getFormat();
		            SourceDataLine line = AudioSystem.getSourceDataLine(format);
		            line.open(format);
		            line.start();
		            while (stream.available() > 0) {
		                int len = stream.read(buffer);
		                line.write(buffer, 0, len);
		            }
		            line.drain();
		            line.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	}

}
