package race;

public class Track {
	
private int finishRace=1;//כדאי שנתחיל מהמקום הראשון

public synchronized int nextPlace() {
	int nextPlace = finishRace++;//נעלה את מסיימי המירוץ
	return nextPlace;

}
}
