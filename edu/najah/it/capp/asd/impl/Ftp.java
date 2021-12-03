package edu.najah.it.capp.asd.impl;

import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.logger.Logger;

import java.util.Date;

public class Ftp implements Protocol {
	
	private static Protocol instance;
	private boolean inuse, busy;
	
	
	private Ftp() {
		inuse = false;
		busy = false;
		Logger.getInstance().logInfo("Creating a new FTP insatnce");
		System.out.println("Creating a new FTP insatnce");
	}
	
	protected static Protocol getInsatnce() throws ProtocolException {
		if(instance == null) {
			instance = new Ftp();
		}
		//exception not needed
		/*if(instance == null) {
			throw new ProtocolException("No connection is available");
		}*/
		return instance;
	}
	@Override
	public boolean release() throws ProtocolException {
		//exception not needed
	/*	if(instance ==null){
			throw new ProtocolException("instance is already released");
		}*/
		if(inuse){
			Logger.getInstance().logWarning("the protocol is in use");
			throw new ProtocolException("the protocol is in use");
		}
		instance = null;
		// unknown error
		if(instance != null){
			Logger.getInstance().logError("Unknown Error");
			throw new ProtocolException("Unknown Error");
		}
		return true;
	}

	@Override
	public void send(String message) throws ProtocolException {
	/*	if(busy){
			Logger.getInstance().logWarning("System is busy");
			throw new ProtocolException("System is busy");
		}*/
		inuse = true;
		busy = true;
		long startTime = new Date().getTime();
		if(instance == null){
			Logger.getInstance().logError("No instance");
			throw new ProtocolException("No instance");
		}
		System.out.println("Sending message from FTP :: " + message);
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
