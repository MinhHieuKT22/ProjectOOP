package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Person;

public class GenPerson {
	private static final String FILE_PATH = "./files/person/";
	private static final List<String> FIRST_NAME_LIST = new ArrayList<String>();
	private static final List<String> MIDDLE_NAME_LIST = new ArrayList<String>();
	private static final List<String> LAST_NAME_LIST = new ArrayList<String>();
	private static final List<String> DETAIL_LIST = new ArrayList<String>();
	
	public GenPerson() {
		if(DETAIL_LIST.size() == 0) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(FILE_PATH + "firstname.txt");
			br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				FIRST_NAME_LIST.add(line);
			}
			fr = new FileReader(FILE_PATH + "middlename.txt");
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				MIDDLE_NAME_LIST.add(line);
			}
			fr = new FileReader(FILE_PATH + "lastname.txt");
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				LAST_NAME_LIST.add(line);
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
	
	private String genName() {
		Random rand = new Random();
		int fn = rand.nextInt(FIRST_NAME_LIST.size());
		int mn = rand.nextInt(MIDDLE_NAME_LIST.size());
		int ln = rand.nextInt(100);
		if (ln>=0 && ln <=38) {
			ln = 0; 
		}
		else if(ln>38 && ln<=50) {
			ln = 1;
		}
		else if(ln>50 && ln<=60) {
			ln = 2;
		}
		else if(ln>60 && ln<=68) {
			ln = 3;
		}
		else if(ln>68 && ln<=73) {
			ln = 4;
		}
		else if(ln>73 && ln<=77) {
			ln = 5;
		}
		else if(ln>77 && ln<=81) {
			ln = 6;
		}
		else if(ln>81 && ln<=83) {
			ln = 7;
		}
		else if(ln>83 && ln<=85) {
			ln = 8;
		}
		else if(ln>85 && ln<=87) {
			ln = 9;
		}
		else if(ln>87 && ln<=91) {
			ln = 101 - ln; 
		}
		else {
			ln = 14 + rand.nextInt(LAST_NAME_LIST.size()-14);
		}
		String name = LAST_NAME_LIST.get(ln) + ' ' + MIDDLE_NAME_LIST.get(mn) + ' ' + FIRST_NAME_LIST.get(fn);
		return name;		
	}

	private String genDetail() {
		Random rand = new Random();
		int a = rand.nextInt(DETAIL_LIST.size());
		String detail = DETAIL_LIST.get(a);
		return detail;
	}
	
	public Person genPerson() throws InterruptedException {
		Random rand = new Random();
		String label = this.genName();
		String detail = this.genDetail();
		int age = rand.nextInt(100) + 1;
		GenSource genS = new GenSource();
		Person person = new Person(label, detail, age, genS.genSource());
		return person;
	}
}
