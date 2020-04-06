import java.awt.*;
import java.util.*;

import acm.util.RandomGenerator;

public class BananaTree extends LifeForm {
	
	RandomGenerator rgen = new RandomGenerator();
	public BananaTree(Location l, World w) {
		super(l,w);
		myLifeSpan = 20;
		myColor = Color.YELLOW;
	}
	
	public void reproduce() {
		boolean validPosition = false;
		boolean viableToReproduce = false;
		int numberOfBananaTrees = 0;
		for(LifeForm x: myWorld.getCreatureList()){
			if (x.getClass().getName().equals("BananaTree")) {
				numberOfBananaTrees++;
			}
		}
		if (numberOfBananaTrees < 16) {
			for (LifeForm y: myWorld.getCreatureList()){
				if(this.equals(y) != true) {
					if (y.getClass().getName().equals("BananaTree")) {
						if (Math.abs(y.getMyLocation().getX()- getMyLocation().getX()) <=2 && Math.abs(y.getMyLocation().getY()-getMyLocation().getY()) <=2) {
							viableToReproduce = true;
							}
						}
					}
				}
		}
		if (viableToReproduce == true) {
			int children = 2;
			int newX = 0;
			int newY = 0;
				for (int i = 0; i<children; i++) {
					newX = this.getMyLocation().getX() + rgen.nextInt(-2,2);
					newY = this.getMyLocation().getY() +  rgen.nextInt(-2,2);
					if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
						validPosition = true;
						for (LifeForm c: myWorld.getCreatureList()){
							if (c.getMyLocation().getX() == newX && c.getMyLocation().getY() == newY) {
								validPosition = false;
							}
						}
					}
					if(validPosition = true) {
						break;
					}
				}
			if (validPosition = true) {
				myWorld.getCreatureList().add(new BananaTree(new Location(newX,newY), myWorld));
				}
			}	
	}
	
	public void eat() {
	}
	

}
	

