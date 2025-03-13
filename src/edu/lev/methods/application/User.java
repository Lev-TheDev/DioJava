package edu.lev.methods.application;

import edu.lev.methods.entities.SmartTv;

public class User {

	public static void main(String[] args) {
		SmartTv smartTv = new SmartTv();
		
		System.out.println("TV ligada? " + smartTv.status);
		System.out.println("Qual canal? " + smartTv.channel);
		System.out.println("Qual volume? " + smartTv.volume);
		
		smartTv.turnOn();
		System.out.println("Update!");
		System.out.println("TV ligada? " + smartTv.status);
		
		smartTv.turnUpVolume();
		smartTv.turnUpVolume();
		smartTv.turnUpVolume();
		System.out.println("Qual volume? " + smartTv.volume);
		
		smartTv.nextChannel();
		smartTv.nextChannel();
		System.out.println("Qual canal? " + smartTv.channel);
		smartTv.changeChannel(8);
		System.out.println("Qual canal? " + smartTv.channel);

	}
}
