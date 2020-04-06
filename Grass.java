import java.util.ArrayList;

public class Grass extends Plant {
	
	public Grass(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
	}
	
	public void reproduce() {
		int numberOfGrasses = 0;
		for(LifeForm x: myWorld.getCreatureList()){
			if (x.getClass().getName().equals("Grass")) {
				numberOfGrasses++;
			}
		}
		int newX = (int)(Math.random()*20);
		int newY = (int)(Math.random()*20); 
		if (numberOfGrasses <= 40) {
		myWorld.getCreatureList().add(new Grass(new Location(newX,newY), myWorld));
		}
	}
	
	public void eat() {
	}

}
