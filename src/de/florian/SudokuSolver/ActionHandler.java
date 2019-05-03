package de.florian.SudokuSolver;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ActionHandler implements ActionListener {
	int sudokuSort[][] = new int[9][9];
	int column[] = new int[9];
	List<String> newValues = new ArrayList<String>();

	public void actionPerformed(ActionEvent e) {
		SortArray();

		if (e.getSource() == UI.btnOK) {
			UI.btnOK.setEnabled(false);
			checkSudoku();
		}
		Main.finished = true;
		for (int t = 0; t < 9; t++) {
			for (int z = 0; z < 9; z++) {
				if (Main.sudoku[t][z] == 0) {
					Main.finished = false;
				}
			}
		}
		// Zahleneingabe
		if (Main.finished == false) {
			for (int y = 0; y < 9; y++) {
				for (int z = 0; z < 9; z++) {
					if (e.getSource() == UI.btn[y][z] && Main.sudoku[y][z] == 0) {
						String input = JOptionPane.showInputDialog("Welche Zahl kommt in dieses Feld?");

						try {
							Integer.parseInt(input);
							Main.sudoku[y][z] = Integer.parseInt(input);
							if (Integer.parseInt(input) > 9 || Integer.parseInt(input) < 1) {
								JOptionPane.showMessageDialog(UI.window, "Zahl zwischen 1 und 9 eingeben!");
							} else {
								UI.btn[y][z].setText(input);
								UI.btn[y][z].repaint();
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(UI.window, "Bitte eine Zahl zwischen 1 und 9 eingeben!");
						}
					}
				}
			}
		}
	}

	// Sudoku überprüfen
	void checkSudoku() {
		newValues.clear();
		int counter = 100;
		while (counter > 0) {
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					if (Main.sudoku[y][x] == 0) {
						// counter++;
						checkRow(y, x);
						checkColumn(y, x);
						checkField(y, x);
						editBtn(y, x);
					}
				}
			}
			counter--;
			SortArray();
		}
	}

	// Reihe überprüfen
	void checkRow(int y, int x) {
		newValues.clear();
		for (int a = 0; a < 10; a++) {
			int i = Arrays.binarySearch(sudokuSort[y], a);
			for (int k = 0; k < 10; k++) {
				if (!(i > -1)) {
					if (!newValues.contains(String.valueOf(a))) {
						newValues.add(String.valueOf(a));
					}
					break;
				}
			}
		}
	}

	// Spalte überprüfen
	void checkColumn(int y, int x) {
		for (int i = 0; i < 9; i++) {
			column[i] = Main.sudoku[i][x];
		}
		Arrays.sort(column);

		for (int a = 0; a < 10; a++) {
			int i = Arrays.binarySearch(column, a);
			for (int k = 0; k < 10; k++) {
				if (i > -1) {
					if (newValues.contains(String.valueOf(a))) {
						newValues.remove(String.valueOf(a));
					}
					break;
				}
			}
		}
	}

	// Felder überprüfen
	void checkField(int y, int x) {
		int yWert = ((int) (y / 3)) * 3;
		int xWert = ((int) (x / 3)) * 3;

		for (int i = yWert; i < (yWert + 3); i++) {
			for (int j = xWert; j < (xWert + 3); j++) {
				column[i] = Main.sudoku[i][j];
			}
		}
		Arrays.sort(column);

		for (int a = 1; a < 10; a++) {
			int i = Arrays.binarySearch(column, a);
			for (int k = 0; k < 10; k++) {
				if (i > -1) {
					if (newValues.contains(String.valueOf(a))) {
						newValues.remove(String.valueOf(a));
					}
					break;
				}
			}
		}
	}

	// Buttons berarbeiten
	void editBtn(int y, int x) {
		if (newValues.size() == 1) {
			Main.sudoku[y][x] = Integer.parseInt(newValues.get(0));
			UI.btn[y][x].setText(newValues.get(0).toString());
			UI.btn[y][x].repaint();
		}

	}

	// Array Sortieren
	private void SortArray() {
		for (int i = 0; i < 9; i++) {
			sudokuSort[i] = Main.sudoku[i].clone();
			Arrays.sort(sudokuSort[i]);
		}
	}
}