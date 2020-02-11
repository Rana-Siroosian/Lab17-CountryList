import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author >>RanaSiroosian<<
 *
 */

public class CountriesApp {

	private static FileHelper<Country> fileHelper = new FileHelper<>("src/countries.txt",
			new CountryLineConverter());
//	private static String filePath = "src/countries.txt";
	
	
	public static CountriesApp instance = new CountriesApp();

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner (System.in);
		System.out.println("Welcome to the Countries Maintenance Application! \n");
		Path filePath = Paths.get("src/countries.txt");
		try { 
			if(Files.notExists(filePath)) {
				Files.createFile(filePath);
			}
			
			}catch (Exception x) {
				System.out.println("There is an error..!");
		}
		
		fileHelper.rewrite(Arrays.asList(new Country("Rwanda" , 12210000 )));
		fileHelper.append(new Country ("USA  " , 327000000 ));
		fileHelper.append(new Country ("India" , 1339000000 ));
		fileHelper.append(new Country ("China" , 1386000000 ));

		List<Country> country = fileHelper.readAll();

		printMenu(scnr,country);

	}

	public static void printMenu(Scanner scnr, List<Country> country) {
		CountriesApp cntr = new CountriesApp();

		String[] menu = {"See the list of countries", "Add a country", "Remove a country","Sort countries","Quit"};
		
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i+1) + ". " + menu[i]);
			
		}
		System.out.println("-------------------------------");
		int choice = Validator.getInt(scnr, "\nWhat would you like to do? ", 1,5);

		System.out.println("--------------------------------");
		
		switch (choice) {
		
		case 1:
				cntr.seeList(country, scnr);
				break;
				
			case 2 : 
					country = cntr.addCountry(country, scnr);	 
					printMenu(scnr, country);
						 break;
			
			case 3 : cntr.removeCountry(country,scnr); break;
			
			case 4 : cntr.sortedCountries(country,scnr); break;
				
			case 5 :
//					System.out.println("Thank you, Have a great day.");
//
//					break;
				System.out.print("Are you sure you want to leave the application? (y/n): ");
				String question = Validator.yesOrNo(scnr);
				if (question.equalsIgnoreCase("y")) {

					System.out.println("\nThank you, have a great day!");
					break;
				}
				if (question.equalsIgnoreCase("n")) {
					System.out.println("--------------------------------");
					printMenu(scnr, country);

				}
		}
//		fileHelper.rewrite(country);

	}

	private List<Country> removeCountry(List<Country> country,Scanner scnr) {
		
		int choice = Validator.getInt(scnr, "Which country you want to delete from the list?"
				+ "(choose by number)", 1, country.size());
		
		System.err.print("Are you sure you want to delete " + country.get(choice-1).getName() + " from the list? (y/n): ");

		String question = Validator.yesOrNo(scnr);

		if (question.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.println(country.get(choice-1).getName() + " is removed from the list" );
			country.remove(choice-1);
			
		}
				
		if (question.equalsIgnoreCase("n")) {
			System.out.println();
			System.out.println("Ok , next time make up your mind before pressing delete.");

		}

		System.out.println("--------------------------------");

		printMenu(scnr, country);
		return country;
	}


	public List<Country> addCountry(List<Country> country, Scanner scnr) {
		
		String countryName = Validator.getString(scnr, "Please enter country name: ");
		
		System.out.println("Please enter " + countryName +"'s population: ");
		
		Long population = Validator.getLong(scnr);
		country.add(new Country(countryName, population));
		System.out.println("--------------------------------");
		printMenu(scnr, country);
		return country;
		
	}

	private void seeList(List<Country>country, Scanner scnr) {
		
		System.out.println(String.format("%-23s%-12s", "Country's Name", "Population\n"));
		System.out.println("*****************************************");
		
		for (int i = 1; i<=country.size(); i++) {
			System.out.println(String.format("%-5s",i) + country.get(i-1));
			System.out.println();
		}
		System.out.println("--------------------------------");

		printMenu(scnr, country);	
		
	}
	
	public void sortedCountries(List<Country> country, Scanner scnr) {
		
		Collections.sort(country, new NameSort());
		fileHelper.rewrite(country);
		System.out.println(String.format("%26s", "(Sorted Countries)\n"));
		seeList(country,scnr);
	}
	

	
}

