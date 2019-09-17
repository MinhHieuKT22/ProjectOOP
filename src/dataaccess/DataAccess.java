package dataaccess;



import com.franz.agraph.repository.*;


public class DataAccess extends Data{
	static protected final String USERNAME = "test";
	static protected final String PASSWORD = "xyzzy";
	static protected final String SERVER_URL = "http://localhost:10035";
	static protected final String REPOSITORY_ID = "project_oop";
	
	
	@SuppressWarnings("static-access")
	public void getPrepare() throws Exception {
		AGRepositoryConnection conn = this.getConnection();

		AGValueFactory vf = conn.getRepository().getValueFactory();
		this.personIRI = vf.createIRI(EXNS,"ontology/Person");
		this.locationIRI = vf.createIRI(EXNS,"ontology/Location");
		this.organizationIRI = vf.createIRI(EXNS,"ontology/Organization");
		this.eventIRI = vf.createIRI(EXNS,"ontology/Event");
		this.countryIRI = vf.createIRI(EXNS,"ontology/Country");
		this.timeIRI = vf.createIRI(EXNS,"ontology/Time");
		this.linkIRI = vf.createIRI(EXNS,"entity/link");
		this.dateIRI = vf.createIRI(EXNS,"entity/date");
		this.labelIRI = vf.createIRI(EXNS,"entity/label");
		this.detailIRI = vf.createIRI(EXNS,"entity/detail");
		this.ageIRI = vf.createIRI(EXNS,"entity/age");
		this.headquarterIRI = vf.createIRI(EXNS,"entity/headquarter");
		conn.setNamespace("nse", EXNS + "entity/");
		conn.setNamespace("nst", EXNS + "ontology/");
		conn.setNamespace("rela", EXNS + "relation/");
		conn.close();
		}
	
	@SuppressWarnings("resource")
	public AGRepositoryConnection getConnection() throws Exception {
		AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
		AGCatalog catalog = server.getRootCatalog();
		AGRepository myRepository = catalog.createRepository(REPOSITORY_ID);
		myRepository.initialize();
		AGRepositoryConnection conn = myRepository.getConnection();
		return conn;
	}
	
	
	
	public void closeDB(AGRepositoryConnection conn) {
		conn.clear();
		conn.close();
	}
	
}
