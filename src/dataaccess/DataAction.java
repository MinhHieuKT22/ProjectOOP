package dataaccess;

import java.util.List;

import org.eclipse.rdf4j.model.util.ModelBuilder;

import com.franz.agraph.repository.AGRepositoryConnection;

public class DataAction {
	
	private DataAccess dataAccess = new DataAccess();
	private DataInsert dataInsert = new DataInsert();
	private DataQuery dataQuery = new DataQuery();
	private AGRepositoryConnection conn = null;
	
	public DataAction() throws Exception {
		// TODO Auto-generated constructor stub
		dataAccess.getPrepare();
		conn = dataAccess.getConnection();
		conn.clear();
	}
	
	public void doInsert(int numOfEntity,int numOfRelation) throws Exception {
		int entityLoops = (int)(numOfEntity/20000);
		int relationLoops = (int)(numOfRelation/20000);
		int entityRemain = numOfEntity%20000;
		int relationRemain = numOfRelation%20000;
		for (int a=0; a<entityLoops; a++) { 
			ModelBuilder mb = new ModelBuilder();
			for(int i=0;i<20000;i++) {
				dataInsert.insertEntity(conn, mb);
			}
			dataInsert.pushData(conn, mb);
		}
		for (int a=0; a<relationLoops; a++) {
			ModelBuilder mb = new ModelBuilder();
			for(int i=0;i<20000;i++) {
				dataInsert.insertRelationship(conn, mb);
			}
			dataInsert.pushData(conn, mb);
		}
		ModelBuilder mb = new ModelBuilder();
		for(int i=0;i<entityRemain;i++) {
			dataInsert.insertEntity(conn, mb);
		}
		for(int i=0;i<relationRemain;i++) {
			dataInsert.insertRelationship(conn, mb);
		}
		dataInsert.pushData(conn, mb);
	}
	
	public List<Integer> doSimpleQuery() throws Exception{
		List<Integer> result = dataQuery.simpleQuery(conn);
		return result;
	}
	
	public List<Integer> doComplexQuery() throws Exception{
		List<Integer> result = dataQuery.complexQuery(conn);
		return result;
	}
	
}
