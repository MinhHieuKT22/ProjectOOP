package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Event;

public class GenEvent {

	private static final String FILE_PATH = "./files/event/";
	private static final List<String> EVENT_LIST = new ArrayList<String>();
	private static final List<String> DETAIL_LIST = new ArrayList<String>();
	
	public GenEvent() {
		if (DETAIL_LIST.size() == 0) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				String line;
				fr = new FileReader(FILE_PATH + "event.txt");
				br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					EVENT_LIST.add(line);
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
	
	public Event genEvent() {
		Random rand = new Random();
		int cn = rand.nextInt(EVENT_LIST.size());
		int dn = rand.nextInt(DETAIL_LIST.size());
		String label = EVENT_LIST.get(cn);
		String detail = DETAIL_LIST.get(dn);
		GenSource genS = new GenSource();
		Event event = new Event(label, detail, genS.genSource());
		return event;
	}
}
