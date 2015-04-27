package com.harry.game;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Box extends Stripe {
	
	static final int HEIGHT=15;
	static final int WIDTH=100;
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
	void draw(Graphics g, int x, int y) {
		g.fill3DRect(x, y, Box.WIDTH, Box.HEIGHT, true);
	}
	
	//Detect bounds and move into the container in a straight line
	void moveRight() {
		setX(getX() + getSpeedX());
	}
	void moveLeft() {
		setX(getX() - getSpeedX());
	}
	
	void moveUp() {
		setY(getY() - getSpeedY());
	}
	void moveDown() {
		setY(getY() + getSpeedY());
	}
	
	
	boolean contains(int x, int y) {
		boolean containPoint = false;
		Rectangle rect = new Rectangle(getX(), getY(), WIDTH, HEIGHT); // create one rectanle with same height and width to check that if the 
		if(rect.contains(x, y)) {
			return true;
		}
		return containPoint;
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
