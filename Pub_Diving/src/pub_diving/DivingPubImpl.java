package pub_diving;

import java.util.HashMap;

public class DivingPubImpl implements DivingPublisher {

	// HashMaps use to store the adventure locations
	HashMap<String, Double> Deepdiving = new HashMap<String, Double>();
	HashMap<String, Double> Openwaterdiving = new HashMap<String, Double>();
	HashMap<String, Double> Driftdiving = new HashMap<String, Double>();
	HashMap<String, Double> Cavediving = new HashMap<String, Double>();
	
	// constructor to save locations with pricing based on their location.
	
	public DivingPubImpl() {

		// Add details to the HashMap dayHiking
		Deepdiving.put("Dolphin Watching", 5000.00);
		Deepdiving.put("Bubble Whale & Sharks Watching", 6000.00);
		Deepdiving.put("Coral Reef Watching", 3000.00);
		Deepdiving.put("President Coolidge", 7000.00);

		// Add details to the HashMap overnightHiking
		Openwaterdiving.put("Flooded quarries Swim", 1100.00);
		Openwaterdiving.put("Bioluminescent Watching", 900.00);
		Openwaterdiving.put("Giant Jellyfish Watching", 1300.00);
		Openwaterdiving.put("Orca Watching", 1400.00);

		// Add details to the HashMap waterfallHuntingHiking
		Driftdiving.put("Crab Watching", 2000.00);
		Driftdiving.put("Stingray Watching", 1500.00);
		Driftdiving.put("Turtle Watching", 1600.00);
		Driftdiving.put("Urchin Watching", 1900.00);

		// Add details to the HashMap fishingHiking
		Cavediving.put("The Silfra Crack", 1800.00);
		Cavediving.put("Old Skulls", 1400.00);
		Cavediving.put("Yellow Fish watching", 2000.00);
		Cavediving.put("Old Boats and Fish Watching", 2200.00);

	}

	@Override
	public void displayDivingPlaces(int num) {
		// Override method in the interface to display HashMap values

		int ct;
		switch (num) {
		case 1:
			ct = 1;
			for (String nm01 : Deepdiving.keySet()) {
				String ky01 = nm01.toString();
				String vl01 = Deepdiving.get(nm01).toString();
				System.out.println(ct + ". " + ky01 + " :- LKR " + vl01);
				ct++;
			}
			;
			break;
		case 2:
			ct = 1;
			for (String nm02 : Openwaterdiving.keySet()) {
				String ky02 = nm02.toString();
				String vl02 = Openwaterdiving.get(nm02).toString();
				System.out.println(ct + ". " + ky02 + " :- LKR " + vl02);
				ct++;
			}
			;
			break;

		case 3:
			ct = 1;
			for (String nm03 : Driftdiving.keySet()) {
				String ky03 = nm03.toString();
				String vl03 = Driftdiving.get(nm03).toString();
				System.out.println(ct + ". " + ky03 + " :- LKR " + vl03);
				ct++;
			}
			;
			break;

		case 4:
			ct = 1;
			for (String nm04 : Cavediving.keySet()) {
				String ky04 = nm04.toString();
				String vl04 = Cavediving.get(nm04).toString();
				System.out.println(ct + ". " + ky04 + " :- LKR " + vl04);
				ct++;
			}
			;
			break;
		}

	}

	@Override
	public double getPrice(int category, int place) {
		// Override the method in the interface to get prices of the places when the
		// place is given
		double price = 0;
		if (category == 1) {
			switch (place) {
			case 1:
				price = Deepdiving.get("Dolphin Watching");
				break;
			case 2:
				price = Deepdiving.get("Bubble Whale & Sharks Watching");
				break;
			case 3:
				price = Deepdiving.get("Coral Reef Watching");
				break;
			case 4:
				price = Deepdiving.get("President Coolidge");
				break;
			}
		} else if (category == 2) {
			switch (place) {
			case 1:
				price = Openwaterdiving.get("Flooded quarries Swim");
				break;
			case 2:
				price = Openwaterdiving.get("Bioluminescent Watching");
				break;
			case 3:
				price = Openwaterdiving.get("Giant Jellyfish Watching");
				break;
			case 4:
				price = Openwaterdiving.get("Orca Watching");
				break;
			}

		} else if (category == 3) {
			switch (place) {
			case 1:
				price = Driftdiving.get("Crab Watching");
				break;
			case 2:
				price = Driftdiving.get("Stingray Watching");
				break;
			case 3:
				price = Driftdiving.get("Turtle Watching");
				break;
			case 4:
				price = Driftdiving.get("Urchin Watching");
				break;
			}

		} else if (category == 4) {
			switch (place) {
			case 1:
				price = Cavediving.get("The Silfra Crack");
				break;
			case 2:
				price = Cavediving.get("Old Skulls");
				break;
			case 3:
				price = Cavediving.get("Yellow Fish watching");
				break;
			case 4:
				price = Cavediving.get("Old Boats and Fish Watching");
				break;
			}
		}
		return price;
	}

	@Override
	public String getPlace(int category, int place) {
		// Override the method in the interface to get the places according to the
		// category
		String name = "";
		if (category == 1) {
			switch (place) {
			case 1:
				name = "Dolphin Watching";
				break;
			case 2:
				name = "Bubble Whale & Sharks Watching";
				break;
			case 3:
				name = "Coral Reef Watching";
				break;
			case 4:
				name = "President Coolidge";
				break;
			}
		} else if (category == 2) {
			switch (place) {
			case 1:
				name = "Flooded quarries Swim";
				break;
			case 2:
				name = "Bioluminescent Watching";
				break;
			case 3:
				name = "Giant Jellyfish Watching";
				break;
			case 4:
				name = "Orca Watching";
				break;
			}

		} else if (category == 3) {
			switch (place) {
			case 1:
				name = "Crab Watching";
				break;
			case 2:
				name = "Stingray Watching";
				break;
			case 3:
				name = "Turtle Watching";
				break;
			case 4:
				name = "Urchin Watching";
				break;
			}

		} else if (category == 4) {
			switch (place) {
			case 1:
				name = "The Silfra Crack";
				break;
			case 2:
				name = "Old Skulls";
				break;
			case 3:
				name = "Yellow Fish watching";
				break;
			case 4:
				name = "Old Boats and Fish Watching";
				break;
			}
		}
		return name;
	}
}
