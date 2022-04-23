package pub_hillclimb;

import java.util.HashMap;

public class HillClimbPubImpl implements HillClimbPublisher {
	
	// HashMaps use to store the Safari types\
	HashMap<String, Double> dayMountaineering = new HashMap<String, Double>();
	HashMap<String, Double> overnightMountaineering = new HashMap<String, Double>();
	HashMap<String, Double> waterfallClimbing = new HashMap<String, Double>();
	HashMap<String, Double> alpineClimbing = new HashMap<String, Double>();
	
	public HillClimbPubImpl() {
		
		
		dayMountaineering.put("Hunnasgiriya", 4000.00);
		dayMountaineering.put("Dimbulagala", 8000.00);
		dayMountaineering.put("Yahangala", 2000.00);
		dayMountaineering.put("Kirigalpoththa", 9000.00);

		
		overnightMountaineering.put("Ella Rock", 1400.00);
		overnightMountaineering.put("Narangala", 1900.00);
		overnightMountaineering.put("RiverstonPeak", 2300.00);
		overnightMountaineering.put("Knukles Mountain Range", 5400.00);

		
		waterfallClimbing.put("Nuwara Eliya", 1000.00);
		waterfallClimbing.put("Hortain Plains", 1800.00);
		waterfallClimbing.put("Nuwara", 1500.00);
		waterfallClimbing.put("Kegalle", 2000.00);

	
		alpineClimbing.put("Peacock Hills", 2800.00);
		alpineClimbing.put("Dolukanda", 3400.00);
		alpineClimbing.put("Kabaragala", 5000.00);
		alpineClimbing.put("Bopaththalawa ", 4200.00);
		
	}
	
	@Override
	public void displayHillClimbPlaces(int num) {
		// TODO Auto-generated method stub
		
		int ct;
		switch (num) {
		case 1:
			ct = 1;
			for (String nm01 : dayMountaineering.keySet()) {
				String key01 = nm01.toString();
				String val01 = dayMountaineering.get(nm01).toString();
				System.out.println(ct + ". " + key01 + " :- LKR " + val01);
				ct++;
			}
			;
			break;
		case 2:
			ct = 1;
			for (String nm02 : overnightMountaineering.keySet()) {
				String key02 = nm02.toString();
				String val02 = overnightMountaineering.get(nm02).toString();
				System.out.println(ct + ". " + key02 + " :- LKR " + val02);
				ct++;
			}
			;
			break;

		case 3:
			ct = 1;
			for (String nm03 : waterfallClimbing.keySet()) {
				String key03 = nm03.toString();
				String val03 = waterfallClimbing.get(nm03).toString();
				System.out.println(ct + ". " + key03 + " :- LKR " + val03);
				ct++;
			}
			;
			break;

		case 4:
			ct = 1;
			for (String nm04 : alpineClimbing.keySet()) {
				String key04 = nm04.toString();
				String val04 = alpineClimbing.get(nm04).toString();
				System.out.println(ct + ". " + key04 + " :- LKR " + val04);
				ct++;
			}
			;
			break;
		}

	}

		


	@Override
	public double getPrice(int category, int place) {
		// TODO Auto-generated method stub
		double price = 0;
		if (category == 1) {
			switch (place) {
			case 1:
				price = dayMountaineering.get("Hunnasgiriya");
				break;
			case 2:
				price = dayMountaineering.get("Dimbulagala");
				break;
			case 3:
				price = dayMountaineering.get("Yahangala");
				break;
			case 4:
				price = dayMountaineering.get("Kirigalpoththa");
				break;
			}
		} else if (category == 2) {
			switch (place) {
			case 1:
				price = overnightMountaineering.get("Ella Rock");
				break;
			case 2:
				price = overnightMountaineering.get("Narangala");
				break;
			case 3:
				price = overnightMountaineering.get("RiverstonPeak");
				break;
			case 4:
				price = overnightMountaineering.get("Knukles Mountain Range");
				break;
			}

		} else if (category == 3) {
			switch (place) {
			case 1:
				price = waterfallClimbing.get("Nuwara Eliya");
				break;
			case 2:
				price = waterfallClimbing.get("Hortain Plains");
				break;
			case 3:
				price = waterfallClimbing.get("Nuwara");
				break;
			case 4:
				price = waterfallClimbing.get("Kegalle");
				break;
			}

		} else if (category == 4) {
			switch (place) {
			case 1:
				price = alpineClimbing.get("Peacock Hills");
				break;
			case 2:
				price = alpineClimbing.get("Dolukanda");
				break;
			case 3:
				price = alpineClimbing.get("Kabaragala");
				break;
			case 4:
				price = alpineClimbing.get("Bopaththalawa");
				break;
			}
		}
		return price;
	}

	@Override
	public String getPlace(int category, int place) {
		String name = "";
		if (category == 1) {
			switch (place) {
			case 1:
				name = "Hunnasgiriya";
				break;
			case 2:
				name = "Dimbulagala";
				break;
			case 3:
				name = "Yahangala";
				break;
			case 4:
				name = "Kirigalpoththa";
				break;
			}
		} else if (category == 2) {
			switch (place) {
			case 1:
				name = "Ella Rock";
				break;
			case 2:
				name = "Narangala";
				break;
			case 3:
				name = "RiverstonPeak";
				break;
			case 4:
				name = "Knukles Mountain Range";
				break;
			}

		} else if (category == 3) {
			switch (place) {
			case 1:
				name = "Nuwara Eliya";
				break;
			case 2:
				name = "Hortain Plains";
				break;
			case 3:
				name = "Nuwara";
				break;
			case 4:
				name = "Kegalle";
				break;
			}

		} else if (category == 4) {
			switch (place) {
			case 1:
				name = "Peacock Hills";
				break;
			case 2:
				name = "Dolukanda";
				break;
			case 3:
				name = "Kabaragala";
				break;
			case 4:
				name = "Bopaththalawa";
				break;
			}
		}
		return name;
	}

}
