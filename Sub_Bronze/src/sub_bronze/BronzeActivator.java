package sub_bronze;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import pub_adventure.AdventurePublisher;
import pub_diving.DivingPublisher;
import pub_safari.SafariPublisher;
import pub_hillclimb.HillClimbPublisher;


public class BronzeActivator implements BundleActivator {

	// declaring reference to the publishers
	ServiceReference serviceRefDiving;
	ServiceReference serviceRefAdventure;
	ServiceReference serviceRefSafari;
	ServiceReference serviceRefHillClimbing;
	


	// Scanner Take Inputs
	Scanner scan = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {

		// store details and to calculate the total
		double tot = 0;
		double dis = 0;
		float disPercentage = (float) 0.05;
		ArrayList<String> selecPlaces = new ArrayList<String>();
		int publisherType, place, selected, equalType, tentType, type, nights = 0, exType;
		String tent = null;
		double tentPrice = 0;
		double exPrice = 0;

		//identify the serviced and initialize the references
		

		serviceRefDiving = bundleContext.getServiceReference(DivingPublisher.class.getName());
		DivingPublisher divingPub = (DivingPublisher) bundleContext.getService(serviceRefDiving);

		serviceRefAdventure = bundleContext.getServiceReference(AdventurePublisher.class.getName());
		AdventurePublisher adventurePub = (AdventurePublisher) bundleContext.getService(serviceRefAdventure);
		
		serviceRefSafari= bundleContext.getServiceReference(SafariPublisher.class.getName());
		SafariPublisher safariPub = (SafariPublisher) bundleContext.getService(serviceRefSafari);
		
		serviceRefHillClimbing= bundleContext.getServiceReference(HillClimbPublisher.class.getName());
		HillClimbPublisher hillClimbPub = (HillClimbPublisher) bundleContext.getService(serviceRefHillClimbing);


		// Get inputs and Organize output

		System.out.println("Bronze Subscriber has started.");
		System.out.println("\n================================ Publishers ================================");
		System.out.println("Publishers: ");
		System.out.println("1. Diving"); //Pilgrimages
		System.out.println("2. Adventure"); //hiking
		System.out.println("3. Safari");
		System.out.println("4. Hill Climbing\n");

		try {
			System.out.print("Select a Type: ");
			publisherType = scan.nextInt();
			System.out.println("============================================================================");
			
			//Starting Diving 
			if (publisherType == 1) {
				System.out.println("\n================== Locations under Diving Publisher ===================");
				System.out.println("1. Island Scuba");
				System.out.println("2. Colombo Divers Dehiwala");
				System.out.println("3. Negombo Diving Centre");
				System.out.println("4. Master Divers Galle");

				System.out.println("\nPress 0 to Exit from the locations.\n");

				System.out.print("Select Your Diving Location: ");
				place = scan.nextInt();
				System.out.println("=============================================================================");

				// it will prompt the places until exit.
				// 0 should be enter to exit
				while (place != 0) {

					// if the subscriber need to diving equipment meal, subscriber can give Yes/No
					System.out.print("\nDo You Need Any Diving Equipments? (Y/N): ");
					char isEqual = scan.next().charAt(0);

					// if subscriber needs equipment
					if (isEqual == 'Y') {
						System.out.println(
								"\n============================== Equipment Provided =============================== ");
						System.out.println("1. Scuba mask with mask tamer perday \tLKR 200.00");
						System.out.println("2. Scuba diving fins perday \tLKR 500.00");
						System.out.println("3. Neoprene wetsuit perday \tLKR 750.00");

						System.out.println();

						System.out.print("Select The Equipment You Need : ");
						equalType = scan.nextInt();
						System.out.println("======================================================================");

						// This is in charge of obtaining the pricing.
						switch (equalType) {

						case 1:
							equalType = 200;
							break;
						case 2:
							equalType = 500;
							break;
						case 3:
							equalType = 750;
							break;
						}
						tot += equalType;
					}

					System.out.println("\nThe Followings Are The Diving Type You Can Watch:");
					divingPub.displayDivingPlaces(place);
					System.out.println("\nTo Quit The Current Location, type -1.");
					System.out.print("\nSelect Diving Type: ");
					selected = scan.nextInt();


					//need to exit subscriber should enter -1
					while (selected != -1) {
						tot += divingPub.getPrice(place, selected);
						selecPlaces.add(divingPub.getPlace(place, selected));
						System.out.print("Select Diving Type: ");
						selected = scan.nextInt();
					}
					System.out.print("\nSelect your Next Diving Location: ");
					place = scan.nextInt();
				}


				dis = (tot * disPercentage);

				//displays the summary
				System.out.println("\n============================== Summary Report =============================");
				System.out.println("\nSelected Places : " + selecPlaces);
				System.out.println("\nTotal : " + tot);
				System.out.printf("You Just Recieved A Discount Amount of LKR %.2f For Your Subscription!\n", dis);
				System.out.printf("Amount to be paid : LKR %.2f \n", (tot - dis));
				System.out.println("\n===========================================================================");
			
			} else if (publisherType == 2) { //Starting Adventure 

				// Display Category list
				System.out.println("\n================== Category Of Adventure ===================");

				System.out.println("1. Canoeing");
				System.out.println("2. Archery");
				System.out.println("3. TeamBuilding Adventure");
				System.out.println("4. Mountain Biking\n");

				System.out.println("=============================================================================");
				System.out.println();

				System.out.println("To exit and get the total, press O.\n");
				System.out.print("\nSelect Your Categories: ");
				type = scan.nextInt();
				while (type != 0) {

					System.out.print("\nDo You Want Any Safety Items For The Adventure? (Y/N): ");
					char isEx = scan.next().charAt(0);

					if (isEx == 'Y') {

						System.out.println(
								"\n============================== Extra Stuff =============================== ");
						System.out.println("1. Special Travel Backpack \tLKR 2000.00");
						System.out.println("2. Travel Tent            \tLKR 4500.00");
						System.out.println("3. Extra Biking Equipment \tLKR 2700.00");
						System.out.println("4. Map Device (Digital) \tLKR 2500.00\n");

						System.out.println("======================================================================");

						System.out.print("\nSelect Your Extra Stuff: ");
						exType = scan.nextInt();
						System.out.println("======================================================================");

						switch (exType) {

						case 1:
							exPrice = 2000;
							break;
						case 2:
							exPrice = 4500;
							break;
						case 3:
							exPrice = 2700;
							break;
						case 4:
							exPrice = 2500;
							break;
						}
						tot += exPrice; // cal total price
					}

					System.out.println("\nThe Followings Are The Adventure Places You Can Visit :");
					adventurePub.displayAdvPlaces(type);
					System.out.println("\nTo quit the Current Category, type -1. .\n");
					System.out.print("\nSelect Your Place: ");
					selected = scan.nextInt();
					while (selected != -1) {
						tot += adventurePub.getPrice(type, selected);
						selecPlaces.add(adventurePub.getPlace(type, selected));
						System.out.print("Select Your Place: ");
						selected = scan.nextInt();
					}
					System.out.println();
					System.out.print("\nSelect Your Next Category: ");
					type = scan.nextInt();
				}
				dis = tot * disPercentage;
				
				//displays the summary
				System.out.println("\n============================== Summary Report =============================");
				System.out.println("\nSelected Places : " + selecPlaces);
				System.out.println("\nTotal : " + tot);
				System.out.printf("You Have Just Recieved A Discount LKR %.2f For Your Subscription!\n", dis);
				System.out.printf("Total : LKR %.2f \n", (tot - dis));
				System.out.println("\n===========================================================================");

			} 
			
			//start safari publisher
			else if (publisherType == 3) { //Starting Safari 

				// Display Category list
				System.out.println("\n================== Safari Locations ===================");

				System.out.println("1. YalaSafaris");
				System.out.println("2. WilpattuSafaris");
				System.out.println("3. UdawalaweSafaris");
				System.out.println("4. MinneriyaSafaris\n");

				System.out.println("=============================================================================");
				System.out.println();

				System.out.println("To exit and get the total, press O.\n");
				System.out.print("\nSelect Your Safari Locations: ");
				type = scan.nextInt();
				while (type != 0) {

					System.out.print("\nDo You Need Any Safari Equipments? (Y/N): ");
					char isExtra = scan.next().charAt(0);

					if (isExtra == 'Y') {

						System.out.println(
								"\n============================== Extra Equipments =============================== ");
						System.out.println("1. Safari Wearables (sunglasses, hat, sunblock \tLKR 1500.00");
						System.out.println("2. First aid kit                               \tLKR 1000.00");
						System.out.println("3. Hand luggage (can keep it forever)          \tLKR 1700.00");
						System.out.println("4. Food and Soft Drinks                        \tLKR 500.00\n");

						System.out.println("======================================================================");

						System.out.print("\nSelect extra: ");
						exType = scan.nextInt();

						switch (exType) {

						case 1:
							exPrice = 1500;
							break;
						case 2:
							exPrice = 1000;
							break;
						case 3:
							exPrice = 1700;
							break;
						case 4:
							exPrice = 500;
							break;
						}
						tot += exPrice; // cal total price
					}

					safariPub.displaySafPlaces(type);
					System.out.println("\nTo quit the Current Category, type -1. .\n");
					System.out.print("\nSelect Your Safari Places: ");
					selected = scan.nextInt();
					while (selected != -1) {
						tot += safariPub.getPrice(type, selected);
						selecPlaces.add(safariPub.getPlace(type, selected));
						System.out.print("Select Your Safari Places: ");
						selected = scan.nextInt();
					}
					System.out.println();
					System.out.print("\nSelect Your Next Category: ");
					type = scan.nextInt();
				}
				dis = tot * disPercentage;
				
				//displays the summary
				System.out.println("\n============================== Summary Report =============================");
				System.out.println("Your Selected Safari Places: " + selecPlaces);
				System.out.println("\nTotal : " + tot);
				System.out.printf("You Have Just Recieved A Discount LKR %.2f For Your Subscription!\n", dis);
				System.out.printf("Total : LKR %.2f \n", (tot - dis));
				System.out.println("\n===========================================================================");
				
				

			} else if (publisherType == 4) {
				// Starting Hill Climb
				
				System.out.println("================================ Categories ================================\n");
				System.out.println("Categories: ");
				System.out.println("1. Day Mountaineering");
				System.out.println("2. Overnight Mountaineering");
				System.out.println("3. Waterfall Climbing");
				System.out.println("4. Alpine Climbing\n");

				System.out.println("To exit and get the total, press O.**\n");
				System.out.print("\nSelect Your Category: ");
				type = scan.nextInt();
				System.out.println("===========================================================================");
				while (type != 0) {

					if (type == 2) {
						System.out.print("\nDo You Require a Tent?(Y/N): ");
						char isCanopy = scan.next().charAt(0);
						if (isCanopy == 'Y') {
							System.out.println(
									"\n================================ Tent Types ===============================\n");
							System.out.println("Tent Types: ");
							System.out.println("1. For one Person \t \t LKR 1800.00");
							System.out.println("2. For two Person \t \t LKR 2000.00");
							System.out.println("3. For three person \t LKR 2800.00");
							System.out.println();

							System.out.print("\nSelect Your Tent Type: ");
							tentType = scan.nextInt();

							System.out.print("\nEnter Number of nights required: ");
							nights = scan.nextInt();
							System.out.println(
									"===========================================================================");

							switch (tentType) {

							case 1:
								tent = "For one person";
								tentPrice = 1000;
								break;
							case 2:
								tent = "For two Person";
								tentPrice = 1800;
								break;
							case 3:
								tent = "For three Person";
								tentPrice = 2500;
								break;
							}

							// add tent price to total
							tot += tentPrice * nights;
						}

					}

					System.out.println("================================== Places =================================\n");
					hillClimbPub.displayHillClimbPlaces(type);
					System.out.println("\nType -1 to exit from the Current Category.\n");
					System.out.print("\nSelect Your Hiking Places: ");
					selected = scan.nextInt();
					while (selected != -1) {
						tot += hillClimbPub.getPrice(type, selected);
						selecPlaces.add(hillClimbPub.getPlace(type, selected));
						System.out.print("Select Your Hiking Places: ");
						selected = scan.nextInt();
					}
					
					System.out.println();
					System.out.print("\nSelect Another Category: ");
					type = scan.nextInt();
				}

				// calculate the discount
				dis = tot * disPercentage;

				// Final Output of Total and summary of the choices
				System.out.println("\n============================ Summary Report ==============================");
				System.out.println("Your Selected Hill Climb Locations: " + selecPlaces);
				System.out.println("\nTotal : " + tot);
				System.out.println(" Your Selected Tent: " + tent + "\t" + "Number of Nights: " + nights);
				System.out.printf("You Have Just Recieved A Discount of LKR %.2f For Your Subscription!\n", dis);
				System.out.printf("Total : LKR %.2f \n", (tot - dis));
				System.out.println("==========================================================================\n");

			}
				
		} catch (InputMismatchException e) {
			System.out.println("The value entered should be an integer.!" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Bronze Subscriber Has Stopped.");
		bundleContext.ungetService(serviceRefDiving);
		bundleContext.ungetService(serviceRefAdventure);
		bundleContext.ungetService(serviceRefSafari);
		bundleContext.ungetService(serviceRefHillClimbing);
		
	}

}
