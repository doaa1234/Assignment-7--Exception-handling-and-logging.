package edu.najah.it.capp.asd.service;

import edu.najah.it.capp.asd.impl.ProtocolFactory;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Connection {
	
	
	
	public static Map connections = new HashMap<String, Protocol>();
	//getInstance, createConnection , getConnection 
	public static Protocol getInstance(String connectionType) throws ProtocolException{
		if(connections.containsKey(connectionType)) {
			Logger.getInstance().logError("Connection is already created!.");
			System.out.println("Connection is already created!.");
			return (Protocol) connections.get(connectionType);
		} else {
			if(connections.size() >= 3 ) {
				//do not create connection
				Logger.getInstance().logWarning("System busy");
				throw new ProtocolException("System busy");
//				System.out.println("Can't create more than 3 connection!!");
//				return null;
			}
			Protocol instance = ProtocolFactory.createProcol(connectionType);

			if(instance == null){
				Logger.getInstance().logError("No instance");
				throw new ProtocolException("No instance");
			}
			connections.put(connectionType, instance);
			return instance;
			
		}
	}
	
	public static boolean release(String connectionType) throws ProtocolException {
		if(connections.containsKey(connectionType)) {
			if(connections.get(connectionType) == null){
				// exception
				Logger.getInstance().logError("Connection is null ");
				throw new ProtocolException("Connection is null ");
			}
			connections.remove(connectionType);

			ProtocolFactory.createProcol(connectionType).release();
			
			return true;
		}
		
		return false;
		
	}
	public static ArrayList<String> getCurrentConnections() {
		Set<String> keys = connections.keySet();
		
		ArrayList<String> myConnection =  new ArrayList<String>();
		for (String key : keys) {
			myConnection.add(key);
		}
		return myConnection;
		
		
	}

}
