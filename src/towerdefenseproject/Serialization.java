
package towerdefenseproject;

import java.io.FileOutputStream;
import java.io.Serializable;

public class Serialization implements Serializable {

//	private static FileOutputStream file;
//	private static ObjectOutputStream write;
//	
//	public static boolean checkFile(String name){
//		boolean check = false;
//		check = new File("log",name+".ser").isFile();
//		return check;
//	}
//	
//	public static void createFile(String name) {
//		try {
//			file = new FileOutputStream("log/"+name+".ser");
//		} catch (FileNotFoundException ex) {
//			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
//	
//	public static ObjectOutputStream openFile(String name) {
//		try {
//			file = new FileOutputStream("log/"+name+".ser");
//			write = new ObjectOutputStream(file);
//		} catch (FileNotFoundException ex) {
//			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (IOException ex) {
//			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
//		}
//        return write;
//	}
//	
//	public static void addLine(ObjectOutputStream con,Object tm) {
//		try {
//			con.writeObject(tm);
//		} catch (IOException ex) {
//			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
//	
//	public static void readLine(ObjectOutputStream con){
//		
//	}
//	
//	public static void closeFile(ObjectOutputStream con){
//		try {
//			con.close();
//		} catch (IOException ex) {
//			Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
}