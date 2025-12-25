package stocks;
import java.util.Random;


public class StockUpdateThread implements Runnable{

	private StockServer server;

	public StockUpdateThread(StockServer server) {//לעדכן את ערכי המניות 
		this.server = server;
	}
	@Override
	public void run() {
		//ריצה של 10 פעמים לעדכון המניות

		Random random = new Random();
		for(int i = 0 ; i < 10 ; i++) {
			server.UpdateStock(StockServer.Stock.MICROSOFT,100+random.nextInt(401) );
			server.UpdateStock(StockServer.Stock.APPLE,100+random.nextInt(401) );
			server.UpdateStock(StockServer.Stock.GOOGLE,100+random.nextInt(401) );

			try {//מצב שינה לשנייה
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				return;
			}
			System.out.println("Stock update");
		}


	}

}
