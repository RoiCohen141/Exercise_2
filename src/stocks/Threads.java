package stocks;
import stocks.StockServer.Stock;
import java.util.Random;
public class Threads implements Runnable  {

	private String name;
	private Stock stock;
	private StockServer server;


	public Threads(String name,Stock stock,StockServer server){
		this.name = name;
		this.stock = stock ;
		this.server = server; 

	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < 10 ; i++) {
			int stockValue = server.GetStock(stock);
			System.out.print("Name: " + name + ", " +stock + " Stock: " 
				 + stockValue + " USD\n");
			Random random = new Random();
			int sleepTime = 1000 + random.nextInt(2001);//מנוחה של בין1-3 שניות
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				
				e.printStackTrace();//  אם השינה מופרעת באמצע
			}

		}
		System.out.println("\n" + name + "'s thread finished\n");
		
	}

}
