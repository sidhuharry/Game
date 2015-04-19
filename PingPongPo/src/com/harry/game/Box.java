package com.harry.game;

import java.awt.Graphics;


public class Box extends Stripe {
	
	static final int HEIGHT=30;
	static final int WIDTH=100;
	private int speed; //speed of moving the box to right or left
	
	public Box(){}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	void draw(Graphics g, int x, int y) {
		g.fill3DRect(x, y, Box.WIDTH, Box.HEIGHT, true);
	}
	
	//Detect bounds and move into the container in a straight line
	void moveRight() {
		setX(getX() + getSpeed());
	}
	void moveLeft() {
		setX(getX() - getSpeed());
	}
}
