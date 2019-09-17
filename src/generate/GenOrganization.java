package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Organization;

public class GenOrganization {
	
	
	private static final String FILE_PATH = "./files/organization/";
	private static final List<String> ORGANIZATION_LIST = new ArrayList<String>();
	private static final List<String> HEADQUARTER_LIST = new ArrayList<String>();
	private static final List<String> DETAIL_LIST = new ArrayList<String>();

	public GenOrganization() {
		if(DETAIL_LIST.size() == 0) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(FILE_PATH + "organization.txt");
			br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				ORGANIZATION_LIST.add(line);
			}
			fr = new FileReader(FILE_PATH + "headquarter.txt");
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				HEADQUARTER_LIST.add(line);
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

	public Organization genOrganization() {
		Random rand = new Random();
		int lb = rand.nextInt(ORGANIZATION_LIST.size());
		int hq = rand.nextInt(HEADQUARTER_LIST.size());
		int dt = rand.nextInt(DETAIL_LIST.size());
		String label = ORGANIZATION_LIST.get(lb);
		String headquarter = HEADQUARTER_LIST.get(hq);
		String detail = DETAIL_LIST.get(dt);
		GenSource genS = new GenSource();
		Organization organization = new Organization(label, detail,headquarter, genS.genSource());
		return organization;

	}

}
