package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Time;

public class GenTime {
	private static final String FILE_PATH = "./files/time/time.txt";
	private static final List<String> TIME_LIST = new ArrayList<String>();
	
	public GenTime() {
		if(TIME_LIST.size() == 0) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				String line;
				fr = new FileReader(FILE_PATH);
				br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					TIME_LIST.add(line);
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
	
	private String genDate() {
		Random rand = new Random();
		int year = rand.nextInt(19) + 2000;
		int month = rand.nextInt(12) + 1;
		int date = 1;
		switch(month) {
			case 2:
				date = rand.nextInt(28) +1;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				date = rand.nextInt(31) +1;
				break;
			default:
				date = rand.nextInt(30) +1;
				break;
		}
		String op = String.format("%02d", date) + "/" + String.format("%02d", month) + "/" +Integer.toString(year);
		return op;
	}
	
	public Time genTime() {
		Random rand = new Random();
		int kindOfTime = rand.nextInt(2);
		
		if (kindOfTime==0) {
			int a = rand.nextInt(TIME_LIST.size());
			String tem_time = TIME_LIST.get(a);
			String label = tem_time.split(":")[0];
			String detail = tem_time.split(":")[1];
			GenSource genS = new GenSource();
			Time time = new Time(label, detail, genS.genSource());
			return time;
		}
		else {
			String label = genDate();
			String detail = "Một ngày bình thường";
			GenSource genS = new GenSource();
			Time time = new Time(label, detail, genS.genSource());
			return time;
		}
	}
	
}
