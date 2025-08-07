package edu.lev.poo.interfaces;

public class Computer implements VideoPlayer, MusicPlayer {

	@Override
	public void playMusic() {
		System.out.println("The Computer is playing music...");
	}

	@Override
	public void pauseMusic() {
		System.out.println("The Computer is pausing the music...");
	}

	@Override
	public void stopMusic() {
		System.out.println("The Computer is stopping the music...");
	}

	@Override
	public void playVideo() {
		System.out.println("The Computer is playing video...");
	}

	@Override
	public void pauseVideo() {
		System.out.println("The Computer is pausing the video...");
	}

	@Override
	public void stopVideo() {
		System.out.println("The Computer is stopping the video...");
	}

}
