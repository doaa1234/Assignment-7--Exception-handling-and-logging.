package edu.najah.it.capp.asd;


import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.logger.Logger;


//final

public class Demo {

	public static void main(String[] args){
	/*	Logger.getInstance().logInfo("This is a info message");
		Logger.getInstance().logDebug("This is a debug message");
		Logger.getInstance().logWarning("This is a warning message");
		Logger.getInstance().logError("This is a error message");
*/

		Protocol ssh = null;
		Protocol ssh2=null;
		Protocol telnet=null;
		Protocol scp=null;
		Protocol ftp=null;

		try{
			ssh = Connection.getInstance(ConnectionType.SSH);
			Logger.getInstance().logInfo(" testing ssh");
			ssh.send(" testing ssh ");
		} catch (ProtocolException e){
			Logger.getInstance().logError("connection is alreade");
		} finally {
			try {
				ssh.release();
			} catch (ProtocolException e) {
				Logger.getInstance().logError("problem connection ");
				e.printStackTrace();

			}
		}
		try {
			ssh2 = Connection.getInstance(ConnectionType.SSH);
		} catch (ProtocolException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				ssh2.release();
			} catch (ProtocolException e) {
				e.printStackTrace();
				Logger.getInstance().logInfo("connection is already ");
			}
		}

		try {
			 telnet = Connection.getInstance(ConnectionType.TELNET);
		} catch (ProtocolException e) {
			e.printStackTrace();
			Logger.getInstance().logInfo("problem connection");
		}finally {
			try {
				telnet.release();
			} catch (ProtocolException e) {
				e.printStackTrace();
				Logger.getInstance().logError("problem connection ");
			}
		}

		try {
			 scp = Connection.getInstance(ConnectionType.SCP);
		} catch (ProtocolException e) {
			Logger.getInstance().logWarning("This is a warning message 68");
		}finally {
			try {
				scp.release();
			} catch (ProtocolException e) {
				Logger.getInstance().logError("problem connection ");
			}
		}


		try {
			 ftp = Connection.getInstance(ConnectionType.FTP);
		} catch (ProtocolException e) {
			Logger.getInstance().logError("problem connection ");
			e.printStackTrace();
		}finally {
			try {
				ftp.release();
			} catch (ProtocolException e) {
				Logger.getInstance().logError("problem connection ");
				e.printStackTrace();
			}
		}


		if(ssh == ssh2) {
		//	System.out.println(" ssh is equal to ssh2");
			Logger.getInstance().logDebug("ssh is equal to ssh2");
		}
		try {
			Logger.getInstance().logInfo("Testing telnet");
			telnet.send("Testing telnet ");
		} catch (ProtocolException e) {
			Logger.getInstance().logError("problem connection ");
			e.printStackTrace();
		}finally {
			try {
				ssh.release();
				Connection.release(ConnectionType.SSH);
			} catch (ProtocolException e) {
				Logger.getInstance().logError("problem connection ");
				e.printStackTrace();
			}
		}
		try {
			scp.send("Testing scp");
		} catch (ProtocolException e) {
			Logger.getInstance().logError("problem connection ");
			e.printStackTrace();
		}finally {
			try {
				scp.release();
			} catch (ProtocolException e) {
				Logger.getInstance().logError("problem connection ");
				e.printStackTrace();
			}
		}


		System.out.println(Connection.getCurrentConnections());
		//Connection.release(ConnectionType.SSH);
		System.out.println(Connection.getCurrentConnections());

		try {
			ftp = Connection.getInstance(ConnectionType.FTP);
		} catch (ProtocolException e) {
			Logger.getInstance().logError("problem connection ");
			e.printStackTrace();
		}
		System.out.println(Connection.getCurrentConnections());


		try {
			ssh = Connection.getInstance(ConnectionType.SSH);
		} catch (ProtocolException e) {
			Logger.getInstance().logError("problem connection ");
			e.printStackTrace();
		}
		try {
			ftp = Connection.getInstance(ConnectionType.FTP);
		} catch (ProtocolException e) {
			Logger.getInstance().logError("problem connection ");
			e.printStackTrace();
		}
		try {
			ftp = Connection.getInstance(ConnectionType.FTP);
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		try {
			ftp = Connection.getInstance(ConnectionType.FTP);
			Logger.getInstance().logInfo("Testing FTP");
			ftp.send("Testing FTP");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}finally {
			try {
				Connection.release(ConnectionType.FTP);
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
		}



		Protocol tftp = null;
		try {
			tftp = Connection.getInstance(ConnectionType.TFTP);
			Logger.getInstance().logInfo("test the TFTP");
			tftp.send("test the TFTP ");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		Protocol tftp2 = null;
		try {
			tftp2 = Connection.getInstance(ConnectionType.TFTP);
			Logger.getInstance().logInfo("test the TFTP");
			tftp2.send("test the TFTP ");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		System.out.println(Connection.getCurrentConnections());
		if(tftp == tftp2 ) {
			Logger.getInstance().logDebug("Same object");
			//System.out.println("Same object");
		}
		//tftp.send("test the TFTP ");
		//tftp2.send("test the TFTP ");

		//ftp = Ftp.getInsatnce();
		///Connection.release(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());//3
		if(ftp == null) {
			Logger.getInstance().logDebug("FTP is a null");
			//System.out.println("FTP is a null");
		} else {
			Logger.getInstance().logDebug("FTP is not a null");
			//System.out.println("FTP is not a null");
		}
		try {
			Logger.getInstance().logInfo("breaking the logic");
			ftp.send(" breaking the logic ");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}


	}

}
