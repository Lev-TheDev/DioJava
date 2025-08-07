package edu.lev.poo.interfaces;

public class MusicBoxX implements MusicPlayer {

	@Override
	public void playMusic() {
		System.out.println("The MusicBoxX is playing music...");
	}

	@Override
	public void pauseMusic() {
		System.out.println("The MusicBoxX is pausing the music...");
	}

	@Override
	public void stopMusic() {
		System.out.println("The MusicBoxX is stopping the music...");
	}
}
