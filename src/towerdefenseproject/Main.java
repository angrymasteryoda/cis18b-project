/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefenseproject;

import static java.awt.EventQueue.invokeLater;

/**
 *
 * @author michael
 */
public class Main {
    
    public static void main( String[] args ){
        invokeLater( new Runnable() {
            public void run() {
                MainFrame.getInstance().setVisible( true );
                //new MainFrame().setVisible(true);
            }
        } );
    }
    
}
