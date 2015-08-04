package towerdefenseproject;

import com.michael.api.IO.IO;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static towerdefenseproject.MysqlCon.*;

/**
 * Created By: Michael Risher
 * Date: 5/27/15
 * Time: 7:02 PM
 */
public class Session implements Serializable {
	private String userId;
	private long created;
	private long expires;
	private String username;

	private static String outFileDir = "data";
	private static String outFileName = outFileDir + "/session.dat";

	public Session( String userId, String username ){
		this.userId = userId;
		this.created = getUnix();
		this.username = username;
		this.expires = created + ( 7 * 24 * 60 * 60 );
		// 7 days * 24 hours * 60 minutes * 60 seconds
	}

	public Session( String userId, long created, long expires, String username ) {
		this.userId = userId;
		this.created = created;
		this.expires = expires;
		this.username = username;
	}

	public void createSession(){
		dbOpen();
		if ( connectionStatus() ) {
			if ( tableExists( "td_sessions" ) ) {
				int find = numRows( "td_sessions", "user='" + userId + "'" );
				if ( find == 0 ) {
					PreparedStatement statement = query( "INSERT INTO `td_sessions` ( user, start, expires ) VALUES (?,?,?)" );
					try {
						statement.setString( 1, userId );
						statement.setLong( 2, created );
						statement.setLong( 3, expires );

						find = statement.executeUpdate();
						if ( find == 0 ) {
							IO.println( "failed to create session" );
						}
						else {
							Thread thread = new Thread(){
								public void run(){

								}
							};
							thread.start();
						}
					} catch ( SQLException e ){
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void serialize(){
		try {
			File testFile = new File( outFileName );
			if ( !testFile.exists() ) {
				testFile.getParentFile().mkdir();
				testFile.createNewFile();
			}
			FileOutputStream file = new FileOutputStream( outFileName );
			ObjectOutputStream out = new ObjectOutputStream( file );
			out.writeObject( this );
			out.close();
			file.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	private long getUnix(){
		return System.currentTimeMillis() / 1000L;
	}
}
