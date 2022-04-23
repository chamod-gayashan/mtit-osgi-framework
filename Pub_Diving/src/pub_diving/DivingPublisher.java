package pub_diving;

public interface DivingPublisher {

	public void displayDivingPlaces(int num);

	public double getPrice(int category, int place);

	public String getPlace(int category, int place);
}
