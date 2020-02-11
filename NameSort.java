import java.util.Comparator;
/**
 * 
 * 
 * @author >>RanaSiroosian<<
 *
 */
public class NameSort implements Comparator<Country>{

	@Override
	public int compare(Country o1, Country o2) {
		
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
