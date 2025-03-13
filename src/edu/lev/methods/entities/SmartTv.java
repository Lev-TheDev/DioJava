package edu.lev.methods.entities;

public class SmartTv {
	public boolean status = false;
	public int channel = 1;
	public int volume = 25;
	
	public void turnOn() {
		status = true;
	}
	public void turnOff() {
		status = false;
	}
	
	public void turnUpVolume() {
		volume++;
	}
	
	public void nextChannel() {
		channel++;
	}
	
	public void changeChannel(int newChannel) {
		channel = newChannel;
	}

}
