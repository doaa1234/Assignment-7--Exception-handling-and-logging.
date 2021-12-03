package edu.najah.it.capp.asd.impl;

import edu.najah.cap.legcy.protocol.TFTPProtocol;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.logger.Logger;

import java.util.Date;

public class TFTPAdpter implements Protocol {

	private TFTPProtocol tftpLegcy;
	private static Protocol instance;
	private boolean inuse, busy;
	
	
	private TFTPAdpter() {
		inuse = false;
		busy = false;
		Logger.getInstance().logInfo("Creating a new TFTPAdpter insatnce");
		System.out.println("Creating a new TFTPAdpter insatnce");
		tftpLegcy = TFTPProtocol.getTFTPInstance();
	}

	 protected static Protocol getInsatnce() throws ProtocolException {
		 if(instance == null) {
			 instance = new TFTPAdpter();
		 }
		 if(instance == null) {
			 Logger.getInstance().logError("No connection is available");
			 throw new ProtocolException("No connection is available");
		 }
		 return instance;
	 }
	
	@Override
	public boolean release() throws ProtocolException {
		if(tftpLegcy != null) {
			tftpLegcy.releaseTFTP();
		}
		if(inuse){
			Logger.getInstance().logError("the protocol is in use");
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
	public void send(String message) throws ProtocolException  {
		if(tftpLegcy != null) {
			tftpLegcy.sendMessage(message);
		}
	/*	if(busy){
			Logger.getInstance().logError("System is busy");
			throw new ProtocolException("System is busy");
		}*/
		inuse = true;
		busy = true;
		long startTime = new Date().getTime();
		if(instance == null){
			Logger.getInstance().logError("No instance");
			throw new ProtocolException("No instance");
		}
		System.out.println("Sending message from TFTPAdpter :: " + message);
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
