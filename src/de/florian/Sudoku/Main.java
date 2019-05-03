package de.florian.Sudoku;

import java.util.Random;

public class Main {
	public static int SudokuFertig[][] = new int[9][9];
	public static int SudokuMitNullen[][] = new int[9][9];
	
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		Random r = new Random();
		int firstval = r.nextInt(8);
		//boolean fertig = false;
		int x = firstval, v = 1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((x + j + v) <= 9)
					SudokuFertig[i][j] = j + x + v;
				else
					SudokuFertig[i][j] = j + x + v - 9;
				if (SudokuFertig[i][j] == 10)
					SudokuFertig[i][j] = 1;
			}
			x += 3;
			if (x >= 9)
				x = x - 9;
			if (i == 2) {
				v = 2;
				x = firstval;
			}
			if (i == 5) {
				v = 3;
				x = firstval;
			}

		}

		SudokuMitNullen[0][3] = SudokuFertig[0][3];
		SudokuMitNullen[0][4] = SudokuFertig[0][4];
		SudokuMitNullen[1][2] = SudokuFertig[1][2];
		SudokuMitNullen[1][3] = SudokuFertig[1][3];
		SudokuMitNullen[1][6] = SudokuFertig[1][6];
		SudokuMitNullen[1][7] = SudokuFertig[1][7];
		SudokuMitNullen[1][8] = SudokuFertig[1][8];
		SudokuMitNullen[2][0] = SudokuFertig[2][0];
		SudokuMitNullen[2][4] = SudokuFertig[2][4];
		SudokuMitNullen[2][8] = SudokuFertig[2][8];
		SudokuMitNullen[3][2] = SudokuFertig[3][2];
		SudokuMitNullen[3][5] = SudokuFertig[3][5];
		SudokuMitNullen[3][8] = SudokuFertig[3][8];
		SudokuMitNullen[4][0] = SudokuFertig[4][0];
		SudokuMitNullen[4][2] = SudokuFertig[4][2];
		SudokuMitNullen[4][3] = SudokuFertig[4][3];
		SudokuMitNullen[4][4] = SudokuFertig[4][4];
		SudokuMitNullen[4][5] = SudokuFertig[4][5];
		SudokuMitNullen[4][6] = SudokuFertig[4][6];
		SudokuMitNullen[5][0] = SudokuFertig[5][0];
		SudokuMitNullen[5][1] = SudokuFertig[5][1];
		SudokuMitNullen[5][4] = SudokuFertig[5][4];
		SudokuMitNullen[5][6] = SudokuFertig[5][6];
		SudokuMitNullen[6][0] = SudokuFertig[6][0];
		SudokuMitNullen[6][4] = SudokuFertig[6][4];
		SudokuMitNullen[6][6] = SudokuFertig[6][6];
		SudokuMitNullen[6][8] = SudokuFertig[6][8];
		SudokuMitNullen[7][0] = SudokuFertig[7][0];
		SudokuMitNullen[7][1] = SudokuFertig[7][1];
		SudokuMitNullen[7][2] = SudokuFertig[7][2];
		SudokuMitNullen[7][5] = SudokuFertig[7][5];
		SudokuMitNullen[7][6] = SudokuFertig[7][6];
		SudokuMitNullen[8][2] = SudokuFertig[8][2];
		SudokuMitNullen[8][4] = SudokuFertig[8][4];
		SudokuMitNullen[8][5] = SudokuFertig[8][5];
		new UI();
/*
		while (fertig == false) {
			int ZeilenNummer = 1;
			System.out.println("┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐");
			System.out.println("│   │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │");
			for (int y = 0; y < 9; y++) {
				System.out.println("├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤");
				System.out.println("│ " + ZeilenNummer + " │ " + SudokuMitNullen[y][0] + " │ " + SudokuMitNullen[y][1] + " │ " + SudokuMitNullen[y][2] + " │ "
						+ SudokuMitNullen[y][3] + " │ " + SudokuMitNullen[y][4] + " │ " + SudokuMitNullen[y][5] + " │ " + SudokuMitNullen[y][6] + " │ " + SudokuMitNullen[y][7] + " │ "
						+ SudokuMitNullen[y][8] + " │");
				ZeilenNummer++;
			}
			System.out.println("└───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘");
			System.out.print("Bitte die waagerechten Koordinaten eingeben: ");
			int xKoordinate = Integer.parseInt(s.next());
			System.out.print("Bitte die senkrechten Koordinaten eingeben: ");
			int yKoordinate = Integer.parseInt(s.next());
			System.out.print("Wert eingeben: ");
			int zahl = Integer.parseInt(s.next());
			
			SudokuMitNullen[yKoordinate-1][xKoordinate-1] = zahl;
			
			fertig = true;
			for (int y = 0; y < 9; y++) {
				for (int z = 0; z < 9; z++) {
					if(SudokuMitNullen[y][z] == 0){
						fertig=false;
						break;
					}
				}
			}
		}
		System.out.println("Alles ausgefüllt!");
		for (int y = 0; y < 9; y++) {
			for (int z = 0; z < 9; z++) {
				if(SudokuMitNullen[y][z] != SudokuFertig[y][z]){
					System.out.println("Leider mindestens 1 Fehler!");
					System.exit(0);
				}
			}
		}
		System.out.println("Alles Richtig!");
		*/
	}
}