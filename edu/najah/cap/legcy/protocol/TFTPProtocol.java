package edu.najah.cap.legcy.protocol;

import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.logger.Logger;

import java.util.Date;

public class TFTPProtocol {

	private static TFTPProtocol instance;
	private boolean inuse, busy;
	private TFTPProtocol() {
		inuse = false;
		busy = false;
		Logger.getInstance().logInfo("Creating a new  TFTPProtocol");
		System.out.println("Creating a new  TFTPProtocol");
	}

	public static TFTPProtocol getTFTPInstance() {

		if(instance == null) {
			instance = new TFTPProtocol();
		}
		return instance;
		//return null;
	}

	public boolean releaseTFTP() throws ProtocolException {

		if(inuse){
			Logger.getInstance().logWarning("the protocol is in use");
			throw new ProtocolException("the protocol is in use");
		}
		instance = null;
		if(instance != null){
			Logger.getInstance().logWarning("Unknown Error");
			throw new ProtocolException("Unknown Error");
		}
		return true;
		
	}

	public void sendMessage(String message) throws ProtocolException {

		inuse = true;
		busy = true;
		long startTime = new Date().getTime();
		if(instance == null){
			Logger.getInstance().logDebug("No instance");
			throw new ProtocolException("No instance");
		}
		System.out.println("Sending message from TFTPProtocol :: " + message);
		long endTime = new Date().getTime();
		Logger.getInstance().logDebug("Checkinig time out");
		if(endTime - startTime >3000){
			Logger.getInstance().logError("Timeout");
			throw new ProtocolException("Timeout");
		}
		inuse = false;
		busy = false;
	}
		



}
