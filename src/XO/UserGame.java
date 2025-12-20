package XO;

public class UserGame extends Game{

	
	
	private Player user;
	private Player computer;
	
	public UserGame() {
		super();
		this.user = new UserPlayer('X');
		this.computer = new SelfPlayer ('O');
	
	}
	public void play() {
		
		
		while(true) {
			
			if(getTurn()==PlayerType.X) {
				user.run(this);
			}
			else {
				computer.run(this);
			}
			printBoard();
			if(checkWin()) {
				System.out.println("Player " + getTurn()+ " wins");
				break;
			}
			if(getFreeCells().length==0) {
				System.out.println("Draw-The board is full");
				break;
			}
			switchTurn();
			
			
			
		}
	}
	
}
