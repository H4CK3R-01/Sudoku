package de.florian.Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		boolean fertig = true;
		boolean allesRichtig = true;
		for (int y = 0; y < 9; y++) {
			for (int z = 0; z < 9; z++) {
				if (e.getSource() == UI.alleButtons[y][z]) {
					String eingabe = JOptionPane.showInputDialog("Welche Zahl kommt in dieses Feld?");

					try {
						Integer.parseInt(eingabe);
						Main.SudokuMitNullen[y][z] = Integer.parseInt(eingabe);
						if (Integer.parseInt(eingabe) > 9 || Integer.parseInt(eingabe) < 1) {
							JOptionPane.showMessageDialog(UI.frame, "Zahl zwischen 1 und 9 eingeben!");
						} else {
							UI.alleButtons[y][z].setText(eingabe);
							UI.alleButtons[y][z].repaint();
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(UI.frame, "Bitte eine Zahl zwischen 1 und 9 eingeben!");
					}

				}
			}
		}
		fertig = true;
		for (int y = 0; y < 9; y++) {
			for (int z = 0; z < 9; z++) {
				if (Main.SudokuMitNullen[y][z] == 0) {
					fertig = false;
					break;
				}
			}
		}
		
		if (fertig == true) {
			JOptionPane.showMessageDialog(UI.frame, "Alles ausgefüllt\nErgebnis wird überprüft!");
			for (int y = 0; y < 9; y++) {
				for (int z = 0; z < 9; z++) {
					if(Main.SudokuMitNullen[y][z] != Main.SudokuFertig[y][z]){
						JOptionPane.showMessageDialog(UI.frame, "Leider mindestens 1 Fehler!");
						allesRichtig = false;
					}
				}
			}
			if(allesRichtig == true){
				JOptionPane.showMessageDialog(UI.frame, "Alles Richtig!");
			}
		}
	}
}