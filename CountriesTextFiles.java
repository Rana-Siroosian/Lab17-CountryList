import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author >>RanaSiroosian<<
 *
 */
public class CountriesTextFiles {
	private static String filePath = "src/countries.txt";

public static List<Country> readFiles() throws IOException{

	
		
		try {
			List<Country> country1 = new ArrayList<>();
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			//until you hit the end of the file 
			try {
				Object line = reader.readLine();
				while (line != null) {
				country1.add((Country) line);
				line = reader.readLine();
				}
				return country1;
			}finally {
			reader.close();
			} 
		}catch (FileNotFoundException e) {
			System.out.println("Unabel to read file.");
			return new ArrayList<>();
			}
		}
}
