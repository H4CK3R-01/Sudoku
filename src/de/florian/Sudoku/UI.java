package de.florian.Sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI {
	public static JButton alleButtons[][] = new JButton[9][9];

	public static JFrame frame;
	public static JTable tabelle;
	public static Panel panel;
	
	public UI() {
		try {
			   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		catch(Exception e){}
		
		frame = new JFrame();
		panel = new Panel();
		
		frame.setSize(500, 520);
		frame.setResizable(false);
		frame.setTitle("Sudoku");
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int y = 0; y < 9; y++) {
			for (int z = 0; z < 9; z++) {
				
				alleButtons[y][z] = new JButton();
				alleButtons[y][z].setText(Wert(z, y));
				alleButtons[y][z].setFont(new Font("Monospace", Font.PLAIN, 30));
				panel.add(alleButtons[y][z]);
				alleButtons[y][z].addActionListener(new ActionHandler());
			}
		}
		frame.setVisible(true);
	}
	
	public static String Wert(int z, int y) {
		if(Main.SudokuMitNullen[y][z] == 0){
			return "  ";
		} else {
			alleButtons[y][z].setEnabled(false);
			return String.valueOf(Main.SudokuMitNullen[y][z]);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {

	}
}