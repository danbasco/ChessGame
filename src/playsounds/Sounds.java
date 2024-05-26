package playsounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/** Classe final para reproduzir os sons
 * @version 1.0
 */
public final class Sounds {
	
	/**
	 * pega o áudio e da play
	 * @param audioStream AudioInputStream
	 */
	private static void startClip(AudioInputStream audioStream) {
		
		 Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	        try {
				clip.open(audioStream);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        clip.start();
	}
	
	/**
	 * Efeito sonoro do movimento
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public static void onMove() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/move.wav");
		startClip(AudioSystem.getAudioInputStream(file));
	}
	
	/**
	 * Efeito sonoro de inicio de jogo
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public static void gameStart() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/game-start.wav");
		startClip(AudioSystem.getAudioInputStream(file));
	}
	
	/**
	 * Efeito sonoro do fim de jogo
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public static void gameEnd() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/game-end.wav");
		startClip(AudioSystem.getAudioInputStream(file));
	}
	
	/**
	 * Efeito sonoro de captura
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public static void onCapture() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/capture.wav");
		startClip(AudioSystem.getAudioInputStream(file));
		
	}
	
	/**
	 * Efeito sonoro do roque
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public static void onCastle() throws UnsupportedAudioFileException, IOException {
		
		File file = new File("sounds/movement/castle.wav");
		startClip(AudioSystem.getAudioInputStream(file));
		
	}
}
