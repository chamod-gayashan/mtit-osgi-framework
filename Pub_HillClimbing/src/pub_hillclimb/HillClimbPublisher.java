package pub_hillclimb;

public interface HillClimbPublisher {
	// Method declaration of displaying the places for the given category
		public void displayHillClimbPlaces(int num);

		// Method declaration of retrieving the prices
		public double getPrice(int category, int place);

		// Method declaration of retrieving the places
		public String getPlace(int category, int place);
}
