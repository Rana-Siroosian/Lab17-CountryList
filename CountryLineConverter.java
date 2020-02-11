/**
 * 
 * @author >>RanaSiroosian<<
 *
 */
public class CountryLineConverter implements LineConverter<Country> {

	@Override
	public String toLine(Country country) {
		
		return String.format("%s\t%d",  country.getName(),country.getPopulation());

	}

	@Override
	public Country fromLine(String line) {
		
		String [] country = line.split("\t");
		String name = country[0];
		int population = Integer.parseInt(country[1]);
		return new Country(name , population);
	}

	


}
