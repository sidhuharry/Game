package com.harry.game.modal;
import java.awt.Graphics;


public abstract class Stripe {
	private int x;
	private int y; 

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	abstract void draw(Graphics g, int x, int y);
}
