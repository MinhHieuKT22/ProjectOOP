package dataaccess;

import java.util.List;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;

import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGValueFactory;

import entity.Country;
import entity.Entity;
import entity.Event;
import entity.Location;
import entity.Organization;
import entity.Person;
import entity.Source;
import entity.Time;
import generate.GenEntity;
import relation.GenRelation;
import relation.Relation;

public class DataInsert extends Data{
		
	public void insertEntity(AGRepositoryConnection conn, ModelBuilder mb) throws InterruptedException {
		Entity entity = new GenEntity().genEntity();
		IRI id = null;
		Literal label;
		Literal detail;
		Literal link;
		Literal date;
		Literal age;
		Literal headquarter;
		List<Source> source;
		AGValueFactory vf = conn.getRepository().getValueFactory();
		if (entity instanceof Person) {
			Person person = (Person) entity;
			id = vf.createIRI(EXNS, "person/" + person.getId());
			mb.add(id, RDF.TYPE, personIRI);
			label = vf.createLiteral(person.getLabel());
			mb.add(id, labelIRI, label);
			detail = vf.createLiteral(person.getDetail());
			mb.add(id, detailIRI, detail);
			source = person.getSource();
			for (int i = 0; i < source.size(); i++) {
				link = vf.createLiteral(source.get(i).getLink());
				mb.add(id, linkIRI, link);
				date = vf.createLiteral(source.get(i).getDate(), XMLSchema.DATE);
				mb.add(id, dateIRI, date);
			}
			age = vf.createLiteral(person.getAge());
			mb.add(id, ageIRI, age);
		}
		else if (entity instanceof Country) {
			Country country = (Country) entity;
			id = vf.createIRI(EXNS, "country/" + country.getId());
			mb.add(id, RDF.TYPE, countryIRI);
			label = vf.createLiteral(country.getLabel());
			mb.add(id, labelIRI, label);
			detail = vf.createLiteral(country.getDetail());
			mb.add(id, detailIRI, detail);
			source = country.getSource();
			for (int i = 0; i < source.size(); i++) {
				link = vf.createLiteral(source.get(i).getLink());
				mb.add(id, linkIRI, link);
				date = vf.createLiteral(source.get(i).getDate(), XMLSchema.DATE);
				mb.add(id, dateIRI, date);
			} 
		}
		else if (entity instanceof Location) {
				Location location = (Location) entity;
				id = vf.createIRI(EXNS, "location/" + location.getId());
				mb.add(id, RDF.TYPE, locationIRI);
				label = vf.createLiteral(location.getLabel());
				mb.add(id, labelIRI, label);
				detail = vf.createLiteral(location.getDetail());
				mb.add(id, detailIRI, detail);
				source = location.getSource();
				for (int i = 0; i < source.size(); i++) {
					link = vf.createLiteral(source.get(i).getLink());
					mb.add(id, linkIRI, link);
					date = vf.createLiteral(source.get(i).getDate(), XMLSchema.DATE);
					mb.add(id, dateIRI, date);
				} 
			}
			if (entity instanceof Organization) {
				Organization organization = (Organization) entity;
				id = vf.createIRI(EXNS, "organization/" + organization.getId());
				mb.add(id, RDF.TYPE, organizationIRI);
				label = vf.createLiteral(organization.getLabel());
				mb.add(id, labelIRI, label);
				detail = vf.createLiteral(organization.getDetail());
				mb.add(id, detailIRI, detail);
				source = organization.getSource();
				for (int i = 0; i < source.size(); i++) {
					link = vf.createLiteral(source.get(i).getLink());
					mb.add(id, linkIRI, link);
					date = vf.createLiteral(source.get(i).getDate(), XMLSchema.DATE);
					mb.add(id, dateIRI, date);
				}
				headquarter = vf.createLiteral(organization.getHeadquarter());
				mb.add(id, headquarterIRI, headquarter);
			}
			if (entity instanceof Event) {
				Event event = (Event) entity;
				id = vf.createIRI(EXNS, "event/" + event.getId());
				mb.add(id, RDF.TYPE, eventIRI);
				label = vf.createLiteral(event.getLabel());
				mb.add(id, labelIRI, label);
				detail = vf.createLiteral(event.getDetail());
				mb.add(id, detailIRI, detail);
				source = event.getSource();
				for (int i = 0; i < source.size(); i++) {
					link = vf.createLiteral(source.get(i).getLink());
					mb.add(id, linkIRI, link);
					date = vf.createLiteral(source.get(i).getDate(), XMLSchema.DATE);
					mb.add(id, dateIRI, date);
				} 
			}
			if (entity instanceof Time) {
				Time time = (Time) entity;
				id = vf.createIRI(EXNS, "time/" + time.getId());
				mb.add(id, RDF.TYPE, timeIRI);
				label = vf.createLiteral(time.getLabel());
				mb.add(id, labelIRI, label);
				detail = vf.createLiteral(time.getDetail());
				mb.add(id, detailIRI, detail);
				source = time.getSource();
				for (int i = 0; i < source.size(); i++) {
					link = vf.createLiteral(source.get(i).getLink());
					mb.add(id, linkIRI, link);
					date = vf.createLiteral(source.get(i).getDate(), XMLSchema.DATE);
					mb.add(id, dateIRI, date);
				} 
			}

		}
	
	
	public void insertRelationship(AGRepositoryConnection conn, ModelBuilder mb) throws Exception{
		AGValueFactory vf = conn.getRepository().getValueFactory();
		IRI s = null,o = null;
		Random rand = new Random();
		int a;
		int firstEntity = rand.nextInt(13);
		switch(firstEntity) {
		case 0:
		case 6:
		case 7:
			a = rand.nextInt(Person.getNoPerson())+1;
			s = vf.createIRI(EXNS,"person/Person_" + Integer.toString(a));
			firstEntity = 0;
			break;
		case 1:
		case 8:
		case 9:
			a = rand.nextInt(Location.getNoLocation())+1;
			s = vf.createIRI(EXNS,"location/Location_" + Integer.toString(a));
			firstEntity = 1;
			break;
		case 2:
		case 10:
		case 11:
			a = rand.nextInt(Organization.getNoOrganization())+1;
			s = vf.createIRI(EXNS,"organization/Organization_" + Integer.toString(a));
			firstEntity = 2;
			break;
		case 3:
		case 12:
			a = rand.nextInt(Country.getNoCountry())+1;
			s = vf.createIRI(EXNS,"country/Country_" + Integer.toString(a));
			firstEntity = 3;
			break;
		case 4:
			a = rand.nextInt(Event.getNoEvent())+1;
			s = vf.createIRI(EXNS,"event/Event_" + Integer.toString(a));
			break;
		case 5:
			a = rand.nextInt(Time.getNoTime())+1;
			s = vf.createIRI(EXNS,"time/Time_" + Integer.toString(a));
			break;
		}
		int secondEntity = rand.nextInt(6);
		switch(secondEntity) {
		case 0:
			a = rand.nextInt(Person.getNoPerson())+1;
			o = vf.createIRI(EXNS,"person/Person_" + Integer.toString(a));
			break;
		case 1:
			a = rand.nextInt(Location.getNoLocation())+1;
			o = vf.createIRI(EXNS,"location/Location_" + Integer.toString(a));
			break;
		case 2:
			a = rand.nextInt(Organization.getNoOrganization())+1;
			o = vf.createIRI(EXNS,"organization/Organization_" + Integer.toString(a));
			break;
		case 3:
			a = rand.nextInt(Country.getNoCountry())+1;
			o = vf.createIRI(EXNS,"country/Country_" + Integer.toString(a));
			break;
		case 4:
			a = rand.nextInt(Event.getNoEvent())+1;
			o = vf.createIRI(EXNS,"event/Event_" + Integer.toString(a));
			break;
		case 5:
			a = rand.nextInt(Time.getNoTime())+1;
			o = vf.createIRI(EXNS,"time/Time_" + Integer.toString(a));
			break;
		}
		Relation relation = new GenRelation().genRelation(firstEntity, secondEntity);
		IRI p = vf.createIRI(EXNS,"relation/"+relation.getDetail().replace(" ", "_"));
		mb.add(s,p,o);
	}
	public void pushData(AGRepositoryConnection conn, ModelBuilder mb) {
		conn.add(mb.build());
		
	}
}
