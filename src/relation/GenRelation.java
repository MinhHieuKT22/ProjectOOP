package relation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import relation.Relation;



public class GenRelation {
	private static final String FILE_PATH = "./files/relation/";
	private static final List<String> DETAIL_LIST[][] = new List[6][6];
	private static final String[] ENTITY = {"per","loc","org","cou","eve","time"};
	private static boolean constructed = false;
	
	public GenRelation() {
		if (!constructed) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				for(int i=0;i<6;i++) {
					for(int j=0;j<6;j++) {
						DETAIL_LIST[i][j] = new ArrayList<String>();
						String line;
						String file = FILE_PATH + ENTITY[i] + "-" + ENTITY[j] + ".txt";
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						while((line = br.readLine()) != null) {
							DETAIL_LIST[i][j].add(line);
							
						}
						br.close();
						fr.close();
					}
				}
				constructed = true;	
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
	
	public Relation genRelation(int firstEntity, int secondEntity) {
		try {
			Random rand = new Random();
			int a = rand.nextInt(DETAIL_LIST[firstEntity][secondEntity].size());
			String detail = DETAIL_LIST[firstEntity][secondEntity].get(a);
			Relation relation = new Relation(detail);
			return relation;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(firstEntity);
		}
		return null;
	}


}
