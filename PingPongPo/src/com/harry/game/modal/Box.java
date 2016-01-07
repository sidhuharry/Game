package com.harry.game.modal;

import java.awt.Graphics;


public class Box extends Stripe {
	
	public static final int HEIGHT=15;
	public static final int WIDTH=100;
	private int speedX; //speed of moving the box to right or left
	private int speedY; //speed of moving up or down
	private char axis;//used to check along which axis box is moving.
	
	public Box(){}
	
	public int getSpeedX() {
		return speedX;
	}
	
	public void setSpeedX(int speed) {
		this.speedX = speed;
	}
	
	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		g.fill3DRect(x, y, Box.WIDTH, Box.HEIGHT, true);
	}
	
	//Detect bounds and move into the container in a straight line
	public void moveRight() {
		setX(getX() + getSpeedX());
	}
	public void moveLeft() {
		setX(getX() - getSpeedX());
	}
	
	public void moveUp() {
		setY(getY() - getSpeedY());
	}
	public void moveDown() {
		setY(getY() + getSpeedY());
	}

	/**
	 * @return the axis
	 */
	public char getAxis() {
		return axis;
	}

	/**
	 * @param axis the axis to set
	 */
	public void setAxis(char axis) {
		if(axis == 'X' || axis == 'Y')
			this.axis = axis;
		else
			System.out.println("Wrong axis value");
	}
}
