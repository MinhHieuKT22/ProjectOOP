package main;

//import java.io.FileOutputStream;
import java.util.List;
import dataaccess.DataAction;

public class Main {
	public static void main(String[] args) throws Exception {
		List<Integer> simpleResult;
		List<Integer> complexResult;
		int[] entities = {0,100,5000,10000,100000,300000,600000};
		int[] relations = {0,200,7000,15000,180000,500000,900000};
		
		SaveResult save = new SaveResult();
		save.prepareSimple();
		save.prepareComplex();
		DataAction action = new DataAction();
		for(int i = 1; i<7;i++) {
			action.doInsert(entities[i] - entities[i-1], relations[i]- relations[i-1]);
			String out = String.format("Đã thêm %d thực thể và %d quan hệ", entities[i],relations[i]);
			System.out.println(out);
			Thread.sleep(1000);
			simpleResult = action.doSimpleQuery();
			save.addSimple(simpleResult, entities[i], relations[i]);
			complexResult = action.doComplexQuery();
			save.addComplex(complexResult, entities[i], relations[i]);
		}
		save.showResult();
	}		
}


