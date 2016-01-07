package com.harry.game.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * The GameClient class gives the client for a game 
 * @author Harvinder Singh Sidhu
 */
public class GameClient {
	private Socket gameSocket; // the socket object for the game
	private BufferedReader inputStream;

	public BufferedReader getGameInputStream(String serverIPAddress, int port) {
		try {
			gameSocket = new Socket(serverIPAddress, port);
			inputStream = new BufferedReader(new InputStreamReader(gameSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
