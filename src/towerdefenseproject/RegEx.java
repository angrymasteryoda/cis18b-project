/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefenseproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author minjikim
 */
public class RegEx {

	public static String[] users;
	public static int totalUsersNum = 0;

	public static void checkDate( String s ) {
		Pattern p = Pattern.compile( "([0][1-9]|[1][0-2])-([0][1-9]|[1][0-9]|[2][0-9]|[3][0-2])-([1-2][0-9][0-9][0-9])" );
		Matcher m = p.matcher( s );
		boolean b = m.matches();
		if ( b ) {
			System.out.println( "it matches :" + s );
		} else {
			System.out.println( "it does not match :" + s );
		}
	}

	//todo provide what this matches
	public static boolean checkPassword( String s ) {
		Pattern p = Pattern.compile( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" );
		Matcher m = p.matcher( s );
		//String r="excellent";
		if ( m.matches() == true ) {
			//if(s.length()<10)r="poor";
			//else if(s.length()<15)r="good";
			return true;
		} else {
			return false;
			//r="unacceptable";
		}
		//System.out.println(r);
	}

	public static boolean checkID( String s ) {
		Pattern p = Pattern.compile( "^[a-zA-Z0-9]{4,10}$" );
		Matcher m = p.matcher( s );
		if ( m.matches() == true ) return true;
		return false;
	}

	/**
	 * checks if email is valid
	 * @param s string to check
	 * @return true if valid
	 */
	public static boolean email( String s ){
		Pattern p = Pattern.compile( "[a-zA-Z0-9]+(?:(\\.|_)[A-Za-z0-9!#$%&'*+/=?^`{|}~-]+)*@(?!([a-zA-Z0-9]*\\.[a-zA-Z0-9]*\\.[a-zA-Z0-9]*\\.))(?:[A-Za-z0-9](?:[a-zA-Z0-9-]*[A-Za-z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?" );
		return ( ( p.matcher( s ).matches() ) ? ( true ) : ( false ) );
	}

	/**
	 * check username for alphanumerical input 3 - 50
	 * @param s string to check
	 * @return true if valid
	 */
	public static boolean username( String s ){
		Pattern p = Pattern.compile( "^(?:[A-Za-z0-9]{3,50})$" );
		return ( ( p.matcher( s ).matches() ) ? ( true ) : ( false ) );
	}

	/**
	 * check password
	 * contain at least 6 characters in length
	 * contain at least 1 upper or 1 lower case letter or 1 number
	 * can contain at least 1 special characters "!#$%&? "
	 * @param s string to check
	 * @return true if valid
	 */
	public static boolean password( String s ) {
		Pattern p = Pattern.compile( "^.*(?=.{6,})(?=.*\\w)(?=.*[!&$%&? \"])?.*$" );
		return ( ( p.matcher( s ).matches() ) ? ( true ) : ( false ) );
	}
}
