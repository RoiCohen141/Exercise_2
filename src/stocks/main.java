package stocks;
import static stocks.StockServer.Stock.*;
import java.util.Random;

import stocks.StockServer.Stock;
public class main {

	public static void main(String[] args)// throws InterruptedException //
	{
	
		StockServer neverland = new StockServer();//יצירת ״שרת״ שבוא הנתונים של הבורסה
		
	//יצירת תהליכונים לסוחרים
		Threads t1 = new Threads ("Tami Tan",MICROSOFT, neverland );
		Threads t2 = new Threads("Tim Sruli", APPLE, neverland);
		Threads t3 = new Threads ("Sima Didas",GOOGLE, neverland);
		//יצירת תהליכון לעדכון המניות
		StockUpdateThread t4 =new StockUpdateThread(neverland);

		//ריצת 4 התהליכונים
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
		/*try {
			t1.join(); // ה-main thread מחכה ש-t1 יסיים
			t2.join(); // ה-main thread מחכה ש-t2 יסיים
			t3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
*/

	}

	}
