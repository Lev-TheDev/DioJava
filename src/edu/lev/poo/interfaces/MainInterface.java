package edu.lev.poo.interfaces;

public class MainInterface {
	
	public static void main(String[] args) {
		
		MusicPlayer musicPlayer = new Computer();
		runMusic(musicPlayer);
		runMusic(new MusicBoxX());
		runVideo(new Smartphone());
		//runVideo(musicPlayer);
		
		/*var musicPlayer = new MusicPlayer() {
			
			@Override
			public void stopMusic() {
				System.out.println("Stopping the music...");
			}
			
			@Override
			public void playMusic() {
				System.out.println("Playing the music...");				
			}
			
			@Override
			public void pauseMusic() {
				System.out.println("Pausing the music...");
			}
		};
		musicPlayer.playMusic();*/
		
	}
	public static void runVideo(VideoPlayer videoPlayer) {
		videoPlayer.playVideo();
	}
	
	public static void runMusic(MusicPlayer musicPlayer) {
		musicPlayer.playMusic();
	}

}
