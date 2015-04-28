package com.harry.game;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable {

	private String name;
	private int score = 15; // initial score
	private Box box;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}



	/**
	 * @return the box
	 */
	public Box getBox() {
		return box;
	}

	/**
	 * @param box
	 *            the box to set
	 */
	public void setBox(Box box) {
		this.box = box;
	}

	public void decreaseScore() {
		if(score > 0 )
			score--;
		else
			System.out.println("Score range voilated");
		System.out.println("Score: "+ score);
	}

}
