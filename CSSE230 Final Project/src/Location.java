import java.util.LinkedList;

public class Location {
	String locationName;
	int x;
	int y;
	double distance;
	double danger;
	Location path;
	LocationLink previous;
	LinkedList<LocationLink> adjacentLocations;
	
	public Location(String name, int x, int y) {
		locationName = name;
		adjacentLocations = new LinkedList<>();
		distance = 0;
		path = null;
		this.x = x;
		this.y = y;
	}
	
	public Location(String name) {
		locationName = name;
		adjacentLocations = new LinkedList<>();
		this.x = 0;
		this.y = 0;
	}
	
	public void addLink(LocationLink LL) {
		adjacentLocations.add(LL);
	}
	
	public LinkedList<LocationLink> getAdjacents() {
		return adjacentLocations;
	}
	
	public String getName() {
		return locationName;
	}

	@Override
	public String toString() {
		String toReturn = "Name: " + locationName + ". Adjacent Locations: ";
		for (LocationLink LL : adjacentLocations) {
			toReturn += LL.getRouteName() + ", ";
		}
		return toReturn;
	}
}
