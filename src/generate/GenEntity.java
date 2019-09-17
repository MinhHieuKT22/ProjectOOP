package generate;

import java.util.Random;

import entity.Entity;


public class GenEntity {
	
	public Entity genEntity() throws InterruptedException {
		Random rand = new Random();
		int type = rand.nextInt(6);
		switch(type) {
		case 0:
			return new GenPerson().genPerson();
		case 1:
			return new GenLocation().genLocation();
		case 2:
			return new GenOrganization().genOrganization();
		case 3:
			return new GenCountry().genCountry();
		case 4:
			return new GenEvent().genEvent();
		case 5:
			return new GenTime().genTime();
		}
		return null;
	}
}
