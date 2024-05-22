package playsounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public final class Sounds {
	
	
	private static void startClip(AudioInputStream audioStream) {
		
		 Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        try {
				clip.open(audioStream);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        clip.start();
	}
	
	
	public static void plim() throws UnsupportedAudioFileException, IOException{
		  
		File file = new File("sounds/menu/plim.wav");
		startClip(AudioSystem.getAudioInputStream(file));
        
       
	}
	

	public static void boing() throws UnsupportedAudioFileException, IOException{
		  
		File file = new File("sounds/menu/boing.wav");
		startClip(AudioSystem.getAudioInputStream(file));
	}
	
	public static void onMove() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/move.wav");
		startClip(AudioSystem.getAudioInputStream(file));
	}
	
	public static void gameStart() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/game-start.wav");
		startClip(AudioSystem.getAudioInputStream(file));
	}
	
	public static void gameEnd() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/game-end.wav");
		startClip(AudioSystem.getAudioInputStream(file));
	}
	
	public static void onCapture() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/capture.wav");
		startClip(AudioSystem.getAudioInputStream(file));
		
	}
	
	public static void onCastle() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/castle.wav");
		startClip(AudioSystem.getAudioInputStream(file));
		
	}
}
