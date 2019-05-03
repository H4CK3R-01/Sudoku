package de.florian.SudokuSolver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI {
	public static JFrame window = new JFrame("Sudoku");
	public static Panel panel = new Panel();
	public static JButton btn[][] = new JButton[9][9];
	public static JButton btnOK;

	public UI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}

		window.setSize(500, 555);
		window.setResizable(false);
		window.getContentPane().add(panel, BorderLayout.CENTER);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for (int y = 0; y < 9; y++) {
			for (int z = 0; z < 9; z++) {
				btn[y][z] = new JButton();
				btn[y][z].setText(Wert(z, y));
				btn[y][z].setFont(new Font("Monospace", Font.PLAIN, 30));
				btn[y][z].addActionListener(new ActionHandler());
				panel.add(btn[y][z]);
			}
		}
		
		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Monospace", Font.PLAIN, 20));
		btnOK.addActionListener(new ActionHandler());
		panel.add(btnOK);
		
		window.setVisible(true);
	}

	public static String Wert(int z, int y) {
		if (Main.sudoku[y][z] == 0) {
			btn[y][z].setBackground(new Color(255, 51, 0));
			return "  ";
		} else {
			btn[y][z].setEnabled(false);
			return String.valueOf(Main.sudoku[y][z]);
		}

	}

	public void actionPerformed(ActionEvent e) {

	}
}