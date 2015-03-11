package towerdefenseproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static towerdefenseproject.GameWindow.frame;
import static towerdefenseproject.GameWindow.fullScreen;
import static towerdefenseproject.GameWindow.maximized;
import static towerdefenseproject.GameWindow.scene;
import static towerdefenseproject.GameWindow.windowH;
import static towerdefenseproject.GameWindow.windowW;

public class Screens extends JFrame {
	
	// PANEL LAYOUT SETTINGS
	private static int gridPanelH;
	private static int gridPanelW;
	private static int hudPanelH;
	private static int hudPanelW;
	private static int gridSquareSize;
	private static int hudY;
	
	// PANEL FOR INTRO SCREEN
	private static JPanel introPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
	
	// PANELS FOR GAME GRID
	private static JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
	
	// PANELS FOR PLAYER HUD
	private static JPanel hudPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
	private static JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	private static JPanel slotsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	private static JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	private static JPanel wavePanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	
	// IMAGES USED FOR DECORATION
	private static Image introBackground;
	
	public static void updateGridSquareSize() {
		// Windows width / by 56 squares wide. 50 for grid and 6 as padding
		gridSquareSize = (int) Math.floor( GameWindow.windowW / 56 );
	}
	
	public static void updateGridPanel() {
		gridPanelH = gridSquareSize*25;
		gridPanelW = GameWindow.windowW;
		// (int) Math.floor( ( windowW - 40 ) / 55 )
	}
	
	public static void updateHudPanel() {
		if (fullScreen==true){
			hudY = gridPanelH + ((windowH-gridPanelH)/5);
		} else if (maximized==true){
			// TODO - See comment in GameWindow updateScreenSize()
		} else {
			hudY = (gridSquareSize*26)-(gridSquareSize/4)*3;
		}
		hudPanelH = gridSquareSize*4;
		hudPanelW = GameWindow.windowW;
	}
	
	public static void loadImages(){
		try {
			introBackground = ImageIO.read(new File("res/tdc-logo.jpg"));
		} catch (IOException ex) {
			// TODO - Handle this better
			Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void updateLayoutPanels(){
		
		// Update window size (Do the math once)
		updateGridSquareSize();
		updateGridPanel();
		updateHudPanel();
		
		// Clear all panels and their contents (children)
		frame.remove(introPanel);
		frame.remove(gridPanel);
		frame.remove(hudPanel);
		introPanel.removeAll();
		gridPanel.removeAll();
		hudPanel.removeAll();
		statsPanel.removeAll();
		slotsPanel.removeAll();
		scorePanel.removeAll();
		wavePanel.removeAll();
		
		// 0 = Intro screen
		// 1 = Login / Account Screen
		// 2 = Main menu
		// 3 = Help/ Instructions
		// 4 = About
		// 5 = High scores
		// 10 = Game - Play level
		
		if (scene==0){
				// START INTRO CONTAINER
				introPanel.setBounds(0,0,windowW,windowH);
				
				// Resize image
				Image tmp = introBackground.getScaledInstance(windowW,windowH,java.awt.Image.SCALE_SMOOTH);
				ImageIcon newTmp = new ImageIcon(tmp);
				
				// Add background
				JLabel introBackgroundImage = new JLabel();
				introBackgroundImage.setPreferredSize(new Dimension(windowW,windowH));
				introBackgroundImage.setIcon(newTmp);
				introPanel.add(introBackgroundImage);
				
				frame.add(introPanel);
		}
		if (scene==10){
			// TOWER STATS LABELS
			JLabel statsTowerName = new JLabel("TMP",SwingConstants.CENTER);	// Dynamically assigned
			JLabel statsTowerType = new JLabel("Type");
			JLabel statsTowerTypeF = new JLabel("Ground",SwingConstants.RIGHT);
			JLabel statsTowerDamage = new JLabel("Damage");
			JLabel statsTowerDamageF = new JLabel("100",SwingConstants.RIGHT);
			JLabel statsTowerReload = new JLabel("Reload");
			JLabel statsTowerReloadF = new JLabel("2s",SwingConstants.RIGHT);
			JLabel statsTowerLevel = new JLabel("Level");
			JLabel statsTowerLevelF = new JLabel("1",SwingConstants.RIGHT);
			JLabel statsTowerUpgrade = new JLabel("Upgrade");
			JLabel statsTowerUpgradeF = new JLabel("500",SwingConstants.RIGHT); 
			JLabel statsTowerCost = new JLabel("TMP");	// Dynamically assigned: Buy or Sell
			JLabel statsTowerCostF = new JLabel("250", SwingConstants.RIGHT);
			// TOWER AND WEAPON SLOTS
			JLabel slotOne = new JLabel();
			JLabel slotTwo = new JLabel();
			JLabel slotThree = new JLabel();
			JLabel slotFour = new JLabel();
			JLabel slotFive = new JLabel();
			JLabel slotSix = new JLabel();
			JLabel slotSeven = new JLabel();
			JLabel slotEight = new JLabel();
			JLabel slotNine = new JLabel();
			JLabel slotTen = new JLabel();
			JLabel slotEleven = new JLabel();
			JLabel slotTwelve = new JLabel();
			// SCORE AND MONEY LABELS
			JLabel scoreName = new JLabel("Score",SwingConstants.CENTER);
			JLabel scoreNameF = new JLabel("1000",SwingConstants.CENTER);
			JLabel scoreMoney = new JLabel("Money",SwingConstants.CENTER);
			JLabel scoreMoneyF = new JLabel("999",SwingConstants.CENTER);
			// WAVE LABELS
			JLabel wavePointer = new JLabel(">",SwingConstants.CENTER);
			JLabel waveOne = new JLabel("1",SwingConstants.CENTER);
			JLabel waveTwo = new JLabel("2",SwingConstants.CENTER);
			JLabel waveThree = new JLabel("3",SwingConstants.CENTER);
			JLabel waveFour = new JLabel("4",SwingConstants.CENTER);
			JLabel waveFive = new JLabel("5",SwingConstants.CENTER);
			JLabel waveSix = new JLabel("6",SwingConstants.CENTER);
			JLabel waveNext = new JLabel("Next Wave");
			JLabel waveNextF = new JLabel("3s",SwingConstants.RIGHT);
			JLabel waveNum = new JLabel("Wave");
			JLabel waveNumF = new JLabel("10",SwingConstants.RIGHT);
			JLabel waveSendNow = new JLabel("Send Now",SwingConstants.CENTER);
			JLabel wavePause = new JLabel("Pause",SwingConstants.CENTER);

			// START GRID CONTAINER
			gridPanel.setBounds(0,0,Screens.gridPanelW,Screens.gridPanelH);
			gridPanel.setBackground(Color.BLACK);
			frame.add(gridPanel);


			// START HUD CONTAINER WORK
				// Tower stats container
				statsPanel.setPreferredSize(new Dimension(gridSquareSize*12,gridSquareSize*4));
				statsPanel.setBackground(Color.GREEN);
				statsPanel.setBorder(null);
				// Tower name
				statsTowerName.setPreferredSize(new Dimension(gridSquareSize*12,gridSquareSize));
				statsTowerName.setBackground(Color.PINK);
				statsTowerName.setOpaque(true);
				// Tower type
				statsTowerType.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerType.setBackground(Color.PINK);
				statsTowerType.setOpaque(true);
				statsTowerTypeF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerTypeF.setBackground(Color.PINK);
				statsTowerTypeF.setOpaque(true);
				statsTowerType.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				// Tower level
				statsTowerLevel.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerLevel.setBackground(Color.PINK);
				statsTowerLevel.setOpaque(true);
				statsTowerLevelF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerLevelF.setBackground(Color.PINK);
				statsTowerLevelF.setOpaque(true);
				// Tower damage
				statsTowerDamage.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerDamage.setBackground(Color.PINK);
				statsTowerDamage.setOpaque(true);
				statsTowerDamageF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerDamageF.setBackground(Color.PINK);
				statsTowerDamageF.setOpaque(true);
				// Tower current upgrade cost
				statsTowerUpgrade.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerUpgrade.setBackground(Color.PINK);
				statsTowerUpgrade.setOpaque(true);
				statsTowerUpgradeF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerUpgradeF.setBackground(Color.PINK);
				statsTowerUpgradeF.setOpaque(true);
				// Tower reload time after each shot
				statsTowerReload.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerReload.setBackground(Color.PINK);
				statsTowerReload.setOpaque(true);
				statsTowerReloadF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerReloadF.setBackground(Color.PINK);
				statsTowerReloadF.setOpaque(true);
				// Tower cost to buy / profit if sold
				statsTowerCost.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerCost.setBackground(Color.PINK);
				statsTowerCost.setOpaque(true);
				statsTowerCostF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				statsTowerCostF.setBackground(Color.PINK);
				statsTowerCostF.setOpaque(true);
				// Add labels to tower stats contaner
				statsPanel.add(statsTowerName);
				statsPanel.add(statsTowerType);
				statsPanel.add(statsTowerTypeF);
				statsPanel.add(statsTowerLevel);
				statsPanel.add(statsTowerLevelF);
				statsPanel.add(statsTowerDamage);
				statsPanel.add(statsTowerDamageF);
				statsPanel.add(statsTowerUpgrade);
				statsPanel.add(statsTowerUpgradeF);
				statsPanel.add(statsTowerReload);
				statsPanel.add(statsTowerReloadF);
				statsPanel.add(statsTowerCost);
				statsPanel.add(statsTowerCostF);

				// Tower slots container
				slotsPanel.setPreferredSize(new Dimension(gridSquareSize*12,gridSquareSize*4));
				slotsPanel.setBackground(Color.GREEN);
				slotsPanel.setBorder(null);
				// Slot 1
				slotOne.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotOne.setBackground(Color.PINK);
				slotOne.setOpaque(true);
				// Slot 2
				slotTwo.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotTwo.setBackground(Color.PINK);
				// Slot 3
				slotThree.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotThree.setBackground(Color.PINK);
				// Slot 4
				slotFour.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotFour.setBackground(Color.PINK);
				// Slot 5
				slotFive.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotFive.setBackground(Color.PINK);
				// Slot 6
				slotSix.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotSix.setBackground(Color.PINK);
				// Slot 7
				slotSeven.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotSeven.setBackground(Color.PINK);
				// Slot 8
				slotEight.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotEight.setBackground(Color.PINK);
				// Slot 9
				slotNine.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotNine.setBackground(Color.PINK);
				// Slot 10
				slotTen.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotTen.setBackground(Color.PINK);
				// Slot 11
				slotEleven.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotEleven.setBackground(Color.PINK);
				// Slot 12
				slotTwelve.setPreferredSize(new Dimension(gridSquareSize*2,gridSquareSize*2));
				slotTwelve.setBackground(Color.PINK);
				slotTwelve.setOpaque(true);
				// Add labels to tower slots contaner
				slotsPanel.add(slotOne);
				slotsPanel.add(slotTwo);
				slotsPanel.add(slotThree);
				slotsPanel.add(slotFour);
				slotsPanel.add(slotFive);
				slotsPanel.add(slotSix);
				slotsPanel.add(slotSeven);
				slotsPanel.add(slotEight);
				slotsPanel.add(slotNine);
				slotsPanel.add(slotTen);
				slotsPanel.add(slotEleven);
				slotsPanel.add(slotTwelve);

				// Score and Money container
				scorePanel.setPreferredSize(new Dimension(gridSquareSize*5,gridSquareSize*4));
				scorePanel.setBackground(Color.cyan);
				scorePanel.setBorder(null);
				// Score title + score
				scoreName.setPreferredSize(new Dimension(gridSquareSize*5,gridSquareSize));
				scoreName.setBackground(Color.PINK);
				scoreName.setOpaque(true);
				scoreNameF.setPreferredSize(new Dimension(gridSquareSize*5,gridSquareSize));
				scoreNameF.setBackground(Color.PINK);
				scoreNameF.setOpaque(true);
				// Money title + money
				scoreMoney.setPreferredSize(new Dimension(gridSquareSize*5,gridSquareSize));
				scoreMoney.setBackground(Color.PINK);
				scoreMoney.setOpaque(true);
				scoreMoneyF.setPreferredSize(new Dimension(gridSquareSize*5,gridSquareSize));
				scoreMoneyF.setBackground(Color.PINK);
				scoreMoneyF.setOpaque(true);
				// Add labels to score and money contaner
				scorePanel.add(scoreName);
				scorePanel.add(scoreNameF);
				scorePanel.add(scoreMoney);
				scorePanel.add(scoreMoneyF);

				// Wave + pause container
				wavePanel.setPreferredSize(new Dimension(gridSquareSize*7,gridSquareSize*4));
				wavePanel.setBackground(Color.GREEN);
				wavePanel.setBorder(null);
				// Wave pointer
				wavePointer.setPreferredSize(new Dimension(gridSquareSize,gridSquareSize));
				wavePointer.setBackground(Color.PINK);
				wavePointer.setOpaque(true);
				// Waves coming
				waveOne.setPreferredSize(new Dimension(gridSquareSize,gridSquareSize));
				waveOne.setBackground(Color.PINK);
				waveOne.setOpaque(true);
				waveTwo.setPreferredSize(new Dimension(gridSquareSize,gridSquareSize));
				waveTwo.setBackground(Color.PINK);
				waveTwo.setOpaque(true);
				waveThree.setPreferredSize(new Dimension(gridSquareSize,gridSquareSize));
				waveThree.setBackground(Color.PINK);
				waveThree.setOpaque(true);
				waveFour.setPreferredSize(new Dimension(gridSquareSize,gridSquareSize));
				waveFour.setBackground(Color.PINK);
				waveFour.setOpaque(true);
				waveFive.setPreferredSize(new Dimension(gridSquareSize,gridSquareSize));
				waveFive.setBackground(Color.PINK);
				waveFive.setOpaque(true);
				waveSix.setPreferredSize(new Dimension(gridSquareSize,gridSquareSize));
				waveSix.setBackground(Color.PINK);
				waveSix.setOpaque(true);
				// Wave number
				waveNum.setPreferredSize(new Dimension(gridSquareSize*4,gridSquareSize));
				waveNum.setBackground(Color.PINK);
				waveNum.setOpaque(true);
				waveNumF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				waveNumF.setBackground(Color.PINK);
				waveNumF.setOpaque(true);
				// Wave - time to next attck
				waveNext.setPreferredSize(new Dimension(gridSquareSize*4,gridSquareSize));
				waveNext.setBackground(Color.PINK);
				waveNext.setOpaque(true);
				waveNextF.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				waveNextF.setBackground(Color.PINK);
				waveNextF.setOpaque(true);
				// Wave - send wave now
				waveSendNow.setPreferredSize(new Dimension(gridSquareSize*4,gridSquareSize));
				waveSendNow.setBackground(Color.PINK);
				waveSendNow.setOpaque(true);
				// Wave - pause game/ menu
				wavePause.setPreferredSize(new Dimension(gridSquareSize*3,gridSquareSize));
				wavePause.setBackground(Color.PINK);
				wavePause.setOpaque(true);
				// Add labels to score and money contaner
				wavePanel.add(wavePointer);
				wavePanel.add(waveOne);
				wavePanel.add(waveTwo);
				wavePanel.add(waveThree);
				wavePanel.add(waveFour);
				wavePanel.add(waveFive);
				wavePanel.add(waveSix);
				wavePanel.add(waveNum);
				wavePanel.add(waveNumF);
				wavePanel.add(waveNext);
				wavePanel.add(waveNextF);
				wavePanel.add(waveSendNow);
				wavePanel.add(wavePause);

			// END HUD PANEL WORK - Attach children and spacing, then add to GameWindow
			hudPanel.setBounds(0,Screens.hudY,Screens.hudPanelW,Screens.hudPanelH);
			hudPanel.setBackground(Color.YELLOW);
			hudPanel.add(statsPanel);
			hudPanel.add(Box.createRigidArea(new Dimension(gridSquareSize,gridSquareSize*4)));
			hudPanel.add(slotsPanel);
			hudPanel.add(Box.createRigidArea(new Dimension(gridSquareSize,gridSquareSize*4)));
			hudPanel.add(scorePanel);
			hudPanel.add(Box.createRigidArea(new Dimension(gridSquareSize,gridSquareSize*4)));
			hudPanel.add(wavePanel);
			frame.add(hudPanel);
		}
		
		
		// END ALL UPDATES - Refresh GameWindow
		frame.repaint();
		frame.revalidate();
	}
	
}