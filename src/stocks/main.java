package stocks;
import static stocks.StockServer.Stock.*;
import java.util.Random;

import stocks.StockServer.Stock;
public class main {

	public static void main(String[] args)// throws InterruptedException //
	{
	
		StockServer neverland = new StockServer();//יצירת ״שרת״ שבוא הנתונים של הבורסה
		
	//יצירת תהליכונים לסוחרים
		Threads t1 = new Threads ("Tami Tan",MICROSOFT, neverland);
		Threads t2 = new Threads("Tim Sruli", APPLE, neverland);
		Threads t3 = new Threads ("Sima Didas",GOOGLE, neverland);
		//יצירת תהליכון לעדכון המניות
		StockUpdateThread t4 =new StockUpdateThread(neverland);

		// יצירת וריצת 4 התהליכונים
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		Thread th3 = new Thread(t3);
		Thread th4 = new Thread(t4);

		th1.start();
		th2.start();
		th3.start();
		th4.start();

		try {
		    th1.join();
		    th2.join();
		    th3.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}

	}
