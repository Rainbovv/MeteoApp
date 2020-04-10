import java.util.*;

public class MeteoApp {	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		System.out.printf("Please enter the code of one of these countries:%"+
						  "n%-16s - 498%n%-16s - 380%n%-16s - 642%n"+
						  "%-16s - 826%n%-16s - 156%n", "Moldova" , 
						  "Italy" , "Romania" , "United Kingdom" , "China");
		
		MeteoOutput.countryByCode(in.nextInt());
		

		
		System.out.printf("%nWhich information should be desplayed?%n" +
						  "For temperature enter %7s%nFor humadity enter %10s%n" +
						  "For both enter %14s%n" , "- 1", "- 2", "- 3");
		
		MeteoOutput.outputCheck(in.nextInt());
		
		
			
	}	
}

class OpenMeteoProvider {
	
	static double getCurrentTemperature() {
		
		Random random = new Random();
		
		double min = -50;
		double max = 50;
		
		double randTemp = min + random.nextDouble() * (max - min);
		return randTemp;
		
	}
}

class PrivateMeteoProvider extends OpenMeteoProvider {
	
	static byte getCurrentHumidity() {
		
		Random random = new Random();
		
		
		return (byte)random.nextInt(101);
		
	}
		
}

class MeteoOutput extends PrivateMeteoProvider { 
	
	static String country;
	
	static void devider() {
		System.out.println("################################################\n");
	}
	
	static void countryByCode(int countryCode) {
		Scanner in = new Scanner(System.in);
			
		switch(countryCode) {
			case 498:
				country = "Moldova";
				break;
			case 380:
				country = "Italy";
				break;
			case 642:
				country = "Romania";
				break;
			case 826:
				country = "United Kingdom";
				break;
			case 156:
				country = "China";
				break;
			default:
				System.err.println("Can't provide data for this country!\n" +
								   "Please enter a valid code!");
				countryByCode(in.nextInt());
		}
	}
	
	static void outputCheck(int choise) {
		Scanner in = new Scanner(System.in);
		
		switch(choise) {
			case 1:
				devider();
				tempOutput(country);
				break;
			case 2:
				devider();
				humidityOutput(country);
				break;
			case 3:
				devider();
				tempOutput(country);
				humidityOutput(country);
				break;
			default:
				System.err.println("Please enter a valid option!");
				outputCheck(in.nextInt());
		}
	}
	
	public static void tempOutput(String country) {	
			
		System.out.printf("The current temperature in " + country +
						  " is: %.1f\u2103%n" , getCurrentTemperature());
	}
	
	public static void humidityOutput(String country) {
		
		
		System.out.println("The humadity of air in " + country + " is: " + 
						    getCurrentHumidity() + "%.");
	}
}
