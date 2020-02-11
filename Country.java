/**
 * 
 * @author >>RanaSiroosian<<
 *
 */
public class Country {
	
	private String name;
	private long population;
	
	public Country() {
		
	}
	
	public Country(String name, long population) {
		
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public String toString() {
//		return "Country [name=" + name + ", population=" + population + "]";
		return String.format("%s\t\t%s", name, population);
	}
	
	
}
