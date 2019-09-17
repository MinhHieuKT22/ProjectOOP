package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Country;

public class GenCountry {

	private static final String FILE_PATH = "./files/country/";
	private static final List<String> COUNTRY_LIST = new ArrayList<String>();
	private static final List<String> DETAIL_LIST = new ArrayList<String>();
	
	public GenCountry() {
		if (DETAIL_LIST.size() == 0) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				String line;
				fr = new FileReader(FILE_PATH + "country.txt");
				br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					COUNTRY_LIST.add(line);
				}
				fr = new FileReader(FILE_PATH + "detail.txt");
				br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					DETAIL_LIST.add(line);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if (br !=null) {
						br.close();
					}
					if (fr != null) {
						fr.close();
					}
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	public Country genCountry() {
		Random rand = new Random();
		int cn = rand.nextInt(COUNTRY_LIST.size());
		int dn = rand.nextInt(DETAIL_LIST.size());
		String label = COUNTRY_LIST.get(cn);
		String detail = DETAIL_LIST.get(dn);
		GenSource genS = new GenSource();
		Country country = new Country(label, detail, genS.genSource());
		return country;
	}
	
}
