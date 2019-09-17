package dataaccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.query.QueryLanguage;
//import org.eclipse.rdf4j.query.TupleQueryResult;

import com.franz.agraph.repository.AGQueryLanguage;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGTupleQuery;

public class DataQuery {
	private static final String FILE_PATH = "./files/query/";
	private static final List<String> SIMPLE_QUERY = new ArrayList<String>();
	private static final List<String> COMPLEX_QUERY = new ArrayList<String>();
	private static boolean constructed = false;
	
	public DataQuery() {
		if(!constructed) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				String line;
				fr = new FileReader(FILE_PATH + "simple.txt");
				br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					SIMPLE_QUERY.add(line);
				}
				fr = new FileReader(FILE_PATH + "complex.txt");
				br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					COMPLEX_QUERY.add(line);
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
	public List<Integer> simpleQuery(AGRepositoryConnection conn) throws Exception{
		List<Integer> result = new ArrayList<Integer>();
		
		for (String query :SIMPLE_QUERY) {
			Integer time = (int)makeSingleSimpleQuery(conn, query);
			result.add(time);
		}
		return result;
	}
	
	public long makeSingleSimpleQuery(AGRepositoryConnection conn, String queryString) throws Exception {
		long time_begin = 0;
		long time_finish = 0;
		try {
			
			AGTupleQuery tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
			time_begin = System.currentTimeMillis();
			//TupleQueryResult result = 
			tupleQuery.evaluate();
			time_finish = System.currentTimeMillis();
//			try {
//				while(result.hasNext()) {
//					System.out.println(result.next());
//				}
//			}
//			finally {
//				result.close();
//			}
		}finally {
			
		}
		return time_finish - time_begin;
	}
	
	public List<Integer> complexQuery(AGRepositoryConnection conn) throws Exception{
		List<Integer> result = new ArrayList<Integer>();
		
		for (String query :COMPLEX_QUERY) {
			Integer time = (int)makeSingleComplexQuery(conn, query);
			result.add(time);
		}
		return result;
	}
	
	public long makeSingleComplexQuery(AGRepositoryConnection conn, String queryString) throws Exception{
		long time_begin = 0;
		long time_finish = 0;
		try {
			
			AGTupleQuery tupleQuery = conn.prepareTupleQuery(AGQueryLanguage.PROLOG, queryString);
			time_begin = System.currentTimeMillis();
//			TupleQueryResult result = 
			tupleQuery.evaluate();
			time_finish = System.currentTimeMillis();
//			try {
//				while(result.hasNext()) {
//					System.out.println(result.next());
//				}
//			}
//			finally {
//				result.close();
//			}
		}finally {
			
		}
		return time_finish - time_begin;
	}
}

