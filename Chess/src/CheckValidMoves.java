import java.util.ArrayList;
import java.util.Scanner;

public class CheckValidMoves {
    static int noOfPieces;
    static String color;
    static String position;
    static char col;
    static String type;
    static int row;
    
    static ArrayList<Piece> piece;
    
	public static void main(String args[]){
		
		boolean cont = true;
		Scanner scan = new Scanner(System.in);
		
		while(cont) {
			
			piece = new ArrayList<Piece>();
			//		Taking input
				getUserInput();
				showOutput();
			
				System.out.println("Continue (Y/y)");
				String input = scan.nextLine();
				
				if(input.equals("Y") || input.equals("y")) {
					cont = true;
				}else {
					cont = false;
				}
		}
	}
	
//	Input Method
//	Output Method
	public static void showOutput() {
		for(int i = 0; i < piece.size(); i++) {
			System.out.print("Valid Moves of : "+piece.get(i).currentPosition + " [");
			
			if(piece.get(i).type == 'B') {
				filterForBishop(piece.get(i));
			}else {
				filterForKnight(piece.get(i));
			}
			
			for(int j = 0; j < 4; j++) {
				System.out.print("");
				for(int k = 0; k < piece.get(i).steps[j].size(); k++) {
					System.out.print(piece.get(i).steps[j].get(k)+" ,");
				}
				System.out.print("");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	public static void filterForKnight(Piece obj) {
		
		for(int i=0; i < piece.size(); i++) {			
			for(int j = 0; j < 4; j++){
				
				if(!obj.steps[j].isEmpty()) {
					if(obj.steps[j].get(0).equals(piece.get(i).currentPosition)) {
						if(obj.type == piece.get(i).type) {
							obj.steps[j].remove(0);
						}
					}else {
						if(obj.steps[j].get(1).equals(piece.get(i).currentPosition)) {
							if(obj.type == piece.get(i).type) {
								obj.steps[j].remove(1);
							}
						}
					}
				}
			}
		}
		
	}
	
	public static void filterForBishop(Piece obj) {
		
		for(int i=0; i < piece.size(); ++i) {			
			for(int j = 0; j < 4; j++) {
				boolean range = false;
				int size = obj.steps[j].size();
				ArrayList<String> change = new ArrayList();
				for(int k = 0; k < size; k++) {					
					if(obj.steps[j].get(k).equals(piece.get(i).currentPosition)) {

						if(piece.get(i).type != obj.type) {
							obj.steps[j] = change;
						}else {
								change.add(obj.steps[j].get(k));
								obj.steps[j] = change;
//								obj.steps[j].remove(k);
							}
						break;
					}else {
						change.add(obj.steps[j].get(k));
					}
				}
			}
		}
		
	}
	
	public static void getUserInput() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter No of Pieces: ");
    	noOfPieces = Integer.parseInt(input.nextLine());
    	    	
//      No of Pieces to input
    	
    	for(int i = 0; i < noOfPieces; i++) {
    		
    		System.out.println("For Piece " + (i+1) + ":");
        	System.out.print("Enter colour (W/B): ");
        	color=input.nextLine();
        	
        	
        	System.out.print("Enter type (B/N): ");
        	type=input.nextLine();
        	
        	
        	System.out.print("Enter position: ");
        	position=input.nextLine();
        	
        	
        	col=position.charAt(0);
        	row=position.charAt(1);
        	piece.add(new Piece(position.charAt(0), Integer.parseInt(String.valueOf(position.charAt(1))), type.charAt(0)));
       	}
    }
}