package XO;

public abstract class Game {

	private final char [][] gameBoard = new char[5][5];
	private PlayerType currentPlayer;

	public Game(){

		for (int i = 0; i < 5 ;i++) {
			for (int j=0; j < 5 ; j++) {
				gameBoard[i][j] = ' ';

			}
		}
		currentPlayer = PlayerType.X;
	}
	public enum PlayerType{

		X,
		O
	}
	public void printBoard() {
		for (int i = 0; i < 5 ;i++) {// תבנית ש1 ו3 יהיו הקוים של הלוח
			for (int j=0; j < 5 ; j++) {

				System.out.print(gameBoard[i][j]+ " ");
			}
			System.out.println();// ירידת שורה
		}
		System.out.println();
	}


	public PlayerType getTurn() {
		return currentPlayer;
	}

	public synchronized void switchTurn() {//set של החלפת שחקן
		if(currentPlayer == PlayerType.X)
			currentPlayer= PlayerType.O;
		else
			currentPlayer=PlayerType.X;

	}

	public Cell [] getFreeCells(){
		Cell [] temp = new Cell[25];
		int count=0;

		for (int i=0 ; i < 5;i++ ) {//מעבר על הלוח ובדיקה על איפה נשאר תו ריק
			for(int j=0;j < 5;j++) {
				if(gameBoard[i][j]==' ') {
					temp[count] = new Cell(i,j);
					count++;
				}

			}
		}
		Cell [] current = new Cell [count];//ליצור מערך בגודל של הכמות תאים הריקים
		for(int i =0;i < count ; i++) {
			current[i] = temp[i];
		}
		return current;
	}


	public synchronized boolean placeSymbol(int row,int col) {

		if(row > 4 || row < 0 || col >4 || col < 0 ) {
			return false;
		}
		if(gameBoard[row][col]!=' ') {
			return false;
		}
		if(currentPlayer == PlayerType.X) {
			gameBoard[row][col] = 'X';
		}else { 
			gameBoard[row][col] = 'O';
		}

		return true;

	}
	public boolean placeSymbol(Cell cell) {
	    if (cell == null) {
	        return false;
	    }
	    return placeSymbol(cell.getRow(), cell.getCol());
	}
	public boolean checkWin() {

		char symbol;
		if (currentPlayer == PlayerType.X) {
		    symbol = 'X';
		} else {
		    symbol = 'O';
		}

		// שורות
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= 1; j++) {
				if (gameBoard[i][j] == symbol &&
						gameBoard[i][j+1] == symbol &&
						gameBoard[i][j+2] == symbol &&
						gameBoard[i][j+3] == symbol) {
					return true;
				}
			}
		}

		// עמודות
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i <= 1; i++) {
				if (gameBoard[i][j] == symbol &&
						gameBoard[i+1][j] == symbol &&
						gameBoard[i+2][j] == symbol &&
						gameBoard[i+3][j] == symbol) {
					return true;
				}
			}
		}

		// אלכסון ראשי
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				if (gameBoard[i][j] == symbol &&
						gameBoard[i+1][j+1] == symbol &&
						gameBoard[i+2][j+2] == symbol &&
						gameBoard[i+3][j+3] == symbol) {
					return true;
				}
			}
		}

		// אלכסון משני
		for (int i = 0; i <= 1; i++) {
			for (int j = 3; j < 5; j++) {
				if (gameBoard[i][j] == symbol &&
						gameBoard[i+1][j-1] == symbol &&
						gameBoard[i+2][j-2] == symbol &&
						gameBoard[i+3][j-3] == symbol) {
					return true;
				}
			}
		}

		return false;
	}


	
}