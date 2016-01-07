package com.harry.game.network;

import java.io.IOException;
import java.net.ServerSocket;


/**
 * Class for a socketServer
 * @author Harvinder Singh Sidhu
 */
public class GameServer {
	private ServerSocket serverListener = null;
	private static int PORT = 8901;
	
	public ServerSocket startServer() {
		try {
			serverListener = new ServerSocket(PORT);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serverListener;
	}

}
