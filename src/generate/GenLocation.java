package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Location;

public class GenLocation {
	private static final String FILE_PATH = "./files/location/";
	private static final List<String> LOCATION_LIST = new ArrayList<String>();	
	private static final List<String> DETAIL_LIST = new ArrayList<String>();
	
	public GenLocation() {
		if(DETAIL_LIST.size() == 0) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				fr = new FileReader(FILE_PATH + "location.txt");
				br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null) {
					LOCATION_LIST.add(line);
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
	
	public Location genLocation() {
		Random rand = new Random();
		int lb = rand.nextInt(LOCATION_LIST.size());
		int dt = rand.nextInt(DETAIL_LIST.size());
		String label = LOCATION_LIST.get(lb);
		String detail = DETAIL_LIST.get(dt);
		GenSource genS = new GenSource();
		Location location = new Location(label, detail, genS.genSource());
		return location;
	}

}
