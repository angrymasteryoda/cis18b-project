
package towerdefenseproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serialization implements Serializable {

	private static FileOutputStream file;
	private static ObjectOutputStream write;
	
	public static boolean checkFile(String name){
		boolean check = false;
		check = new File("log",name+".ser").isFile();
		return check;
	}
	
	public static void createFile(String name) {
		try {
			file = new FileOutputStream("log/"+name+".ser");
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static ObjectOutputStream openFile(String name) {
		try {
			file = new FileOutputStream("log/"+name+".ser");
			write = new ObjectOutputStream(file);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		}
        return write;
	}
	
	public static void addLine(ObjectOutputStream con,Object data) {
		try {
			con.writeObject(data);
		} catch (IOException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void readLine(String name){
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream("log/"+name+".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			System.out.println(in.readObject());
			in.close();
			fileIn.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				fileIn.close();
			} catch (IOException ex) {
				Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public static void closeFile(ObjectOutputStream con){
		try {
			con.close();
		} catch (IOException ex) {
			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}