package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Source;

public class GenSource {
	private static final String FILE_PATH = "./files/source/";
	private static final List<String> LINK_LIST = new ArrayList<String>();
	private static final List<String> DATE_LIST = new ArrayList<String>();
	
	public GenSource() {
		if (DATE_LIST.size() == 0) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				String line;
				fr = new FileReader(FILE_PATH + "link.txt");
				br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					LINK_LIST.add(line);
				}
				DATE_LIST.add("Thứ Hai");
				DATE_LIST.add("Thứ Ba");
				DATE_LIST.add("Thứ Tư");
				DATE_LIST.add("Thứ Năm");
				DATE_LIST.add("Thứ Sáu");
				DATE_LIST.add("Thứ Bảy");
				DATE_LIST.add("Chủ Nhật");
				
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
		String op = Integer.toString(year) + "-" + String.format("%02d", month) + "-" + String.format("%02d", date);
		return op;
	}
	
	public List<Source> genSource() {
		Random rand = new Random();
		List<Source> source = new ArrayList<Source>();
		int num = rand.nextInt(2) +1;
		for(int i=0; i<num;i++) {
			int sl = rand.nextInt(LINK_LIST.size());
			String link = LINK_LIST.get(sl);
			String date = genDate();
			source.add(new Source(link, date));
			}
		return source;
	}
}
