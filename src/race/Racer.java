package race;

public class Racer implements Runnable{

	private static int globalId = 1;
	private int id;
	private int speed;
	private Track track;


	public Racer(int speed,Track track) {
		this.speed = speed;
		this.track = track;
		this.id = getNextId();

	}

	public static synchronized int getNextId() {
		return globalId++;
	}
	public void go() {
		Thread.currentThread().setPriority(speed);
		for (int i = 0; i < 100 ; i++) {
			System.out.println("Runner " + id + " ran " + i + " meters");
		}
		System.out.println("\nRunner " + id + " ran 100 meters");
		
		int place = track.nextPlace();
		System.out.println("\n" + getFinishPlace(place));
		
	}	
	private String getFinishPlace(int place) {
		switch(place) {
		case 1 :
			return "Runner " + id + " finished 1st";
		case 2 :
			return "Runner "+ id + " finished 2nd";
		case 3 :
			return "Runner "+ id + " finished 3rd";
		default:
			return "Runner " +id + " finished "+ place+ "th " ;
		}
	}



	@Override
	public void run() {
		this.go();
		// TODO Auto-generated method stub

	}
}
