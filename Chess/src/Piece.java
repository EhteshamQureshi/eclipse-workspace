import java.util.ArrayList;

public class Piece extends ArrayList<String>{
	
	String color;
	char type;
	char columns;
	int rows;
	public ArrayList<String>[] steps;
	public String currentPosition;

	public Piece(char columns, int rows, char type) {
		this.columns = columns;
		this.rows = rows;
		this.type = type;
		this.currentPosition = ""+this.columns+this.rows;
		
		steps = new ArrayList[4];
		
		steps[0] = new ArrayList<String>();
		steps[1] = new ArrayList<String>();
		steps[2] = new ArrayList<String>();
		steps[3] = new ArrayList<String>();
		this.findValidMoves();
	}
	
	public void findValidMoves() {
		
		
		if(type == 'B') {
			moveLeftUp(columns, rows);
			moveRightDown(columns, rows);
			moveRightUp(columns, rows);
			moveLeftDown(columns, rows);

		}else {
			moveUpNight(columns, rows);
			moveDownNight(columns, rows);
			moveLeftNight(columns, rows);
			moveRightNight(columns, rows);
		}		
	}
	
	private void moveRightDown(char col, int row) {
		col++;
		row--;
		for(int i = 0; i < 8; i++) {
			if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
				steps[0].add(""+col+row);
				col++;
				row--;
			}
		}
	}
	
	private void moveRightUp(char col, int row) {
		col++;
		row++;
		for(int i = 0; i < 8; i++) {
			if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//				System.out.print(col++);
//				System.out.print(row++);
//				System.out.print(" ");
				steps[1].add(""+col+row);
				col++;
				row++;
			}
		}
	}
	
	private void moveLeftDown(char col, int row) {
		col--;
		row--;
		for(int i = 0; i < 8; i++) {
			if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//				System.out.print(col--);
//				System.out.print(row--);
//				System.out.print(" ");
				steps[2].add(""+col+row);
				col--;
				row--;
			}
		}
	}

	private void moveLeftUp(char col, int row) {
		col--;
		row++;
		for(int i = 0; i < 8; i++) {
			if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//				System.out.print(col--);
//				System.out.print(row++);
//				System.out.print(" ");
				steps[3].add(""+col+row);
				col--;
				row++;
			}
		}
	}
	private void moveUpNight(char col, int row) {
		row += 2;
		
		col++;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[0].add(""+col+row);
		}
		
		col -= 2;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[0].add(""+col+row);
		}
	}
	
	private void moveDownNight(char col, int row) {
		row -= 2;
		
		col++;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[1].add(""+col+row);
		}
		
		col -= 2;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[1].add(""+col+row);
		}
	}
	
	private void moveLeftNight(char col, int row) {
		col += 2;
		
		row++;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[2].add(""+col+row);
		}
		
		row -= 2;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[2].add(""+col+row);
		}
	}

	private void moveRightNight(char col, int row) {
		col -= 2;
		
		row++;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[3].add(""+col+row);
		}
		
		row -= 2;
		if((col >= 'A' && col <= 'H') && (row >= 1 && row <= 8) ) {
//			System.out.print(col);
//			System.out.print(row);
//			System.out.print(" ");
//			col++;
//			row--;
			steps[3].add(""+col+row);
		}
	}
}
