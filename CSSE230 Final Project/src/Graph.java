import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	HashMap<String, Location> nodes;

	public Graph() {
		nodes = new HashMap<String, Location>();
	}

	public void addLocation(String location, Location L) {
		nodes.put(location, L);
	}
	
	public Location getLocation(String loc) {
		if (loc == null) {
			return null;
		}
		return nodes.get(loc);
	}

	public void removeLocation(Location L) {

	}

	public LinkedList<LocationLink> distanceDijkstras(Location start, Location destination) {
		MyBoolean bool = new MyBoolean();
		ArrayList<Location> visitedNodes = new ArrayList<Location>();
		LinkedList<LocationLink> path = new LinkedList<LocationLink>();

		for (String location : nodes.keySet()) {
			if (nodes.get(location).equals(start)) {
				nodes.get(location).distance = 0;
			} else {
				nodes.get(location).distance = 10000;
			}
		}

		Location location = start;
		Location currentLeast = new Location("Temp");
		currentLeast.distance = 10000;
		visitedNodes.add(start);
		while (bool.getValue() != true) {

			for (LocationLink edge : location.adjacentLocations) {
				double tempDistance = location.distance + edge.travelDistance;
				if (edge.locationA.equals(location)) {
					if (edge.locationB.distance > tempDistance) {
						edge.locationB.distance = tempDistance;
						edge.locationB.path = location;
						edge.locationB.previous = edge;
					}
				} else {
					if (edge.locationA.distance > tempDistance) {
						edge.locationA.distance = tempDistance;
						edge.locationA.path = location;
						edge.locationA.previous = edge;
					}
				}
			}
			double least = 10000;
			for (String town : nodes.keySet()) {
				if (!visitedNodes.contains(nodes.get(town))) {
					if (nodes.get(town).distance < least) {
						least = nodes.get(town).distance;
						currentLeast = nodes.get(town);
					}
				}
			}
			if (currentLeast.equals(destination)) {
				bool.setTrue();
				visitedNodes.add(currentLeast);
			}
			if (visitedNodes.size() == nodes.size()) {
				bool.setTrue();
			} else {
				location = currentLeast;
				visitedNodes.add(currentLeast);
			}
		}
		Location node = destination;
		while (!node.equals(start)) {
			path.add(node.previous);
			node = node.path;
			
		}
		return path;
		

	}
	
	public LinkedList<LocationLink> dangerDijkstras(Location start, Location destination) {
		MyBoolean bool = new MyBoolean();
		ArrayList<Location> visitedNodes = new ArrayList<Location>();
		LinkedList<LocationLink> path = new LinkedList<LocationLink>();

		for (String location : nodes.keySet()) {
			if (nodes.get(location).equals(start)) {
				nodes.get(location).danger = 0;
			} else {
				nodes.get(location).danger = 10000;
			}
		}

		Location location = start;
		Location currentLeast = new Location("Temp");
		currentLeast.danger = 10000;
		visitedNodes.add(start);
		while (bool.getValue() != true) {

			for (LocationLink edge : location.adjacentLocations) {
				double tempDanger = location.danger + edge.travelDanger;
				if (edge.locationA.equals(location)) {
					if (edge.locationB.danger > tempDanger) {
						edge.locationB.danger = tempDanger;
						edge.locationB.path = location;
						edge.locationB.previous = edge;
					}
				} else {
					if (edge.locationA.danger > tempDanger) {
						edge.locationA.danger = tempDanger;
						edge.locationA.path = location;
						edge.locationA.previous = edge;
					}
				}
			}
			double least = 10000;
			for (String town : nodes.keySet()) {
				if (!visitedNodes.contains(nodes.get(town))) {
					if (nodes.get(town).danger < least) {
						least = nodes.get(town).danger;
						currentLeast = nodes.get(town);
					}
				}
			}
			if (currentLeast.equals(destination)) {
				bool.setTrue();
				visitedNodes.add(currentLeast);
			}
			if (visitedNodes.size() == nodes.size()) {
				bool.setTrue();
			} else {
				location = currentLeast;
				visitedNodes.add(currentLeast);
			}
		}
		Location node = destination;
		while (!node.equals(start)) {
			path.add(node.previous);
			node = node.path;
			
		}
		return path;
		

	}

	public LinkedList<LinkedList<LocationLink>> tripPlanner(Location start, int distance) {
		MyBoolean bool = new MyBoolean();
		ArrayList<Location> visitedNodes = new ArrayList<Location>();
		LinkedList<LinkedList<LocationLink>> options = new LinkedList<LinkedList<LocationLink>>();
		

		for (String location : nodes.keySet()) {
			if (nodes.get(location).equals(start)) {
				nodes.get(location).distance = 0;
			} else {
				nodes.get(location).distance = 10000;
			}
			nodes.get(location).path = null;
			nodes.get(location).previous = null;
		}

		Location location = start;
		Location currentLeast = new Location("Temp");
		currentLeast.distance = 10000;
		visitedNodes.add(start);
		while (bool.getValue() != true) {

			for (LocationLink edge : location.adjacentLocations) {
				double tempDistance = location.distance + edge.travelDistance;
				if (edge.locationA.equals(location)) {
					if (edge.locationB.distance > tempDistance) {
						edge.locationB.distance = tempDistance;
						edge.locationB.path = location;
						edge.locationB.previous = edge;
					}
				} else {
					if (edge.locationA.distance > tempDistance) {
						edge.locationA.distance = tempDistance;
						edge.locationA.path = location;
						edge.locationA.previous = edge;
					}
				}
			}
			double least = 10000;
			for (String town : nodes.keySet()) {
				if (!visitedNodes.contains(nodes.get(town))) {
					if (nodes.get(town).distance < least) {
						least = nodes.get(town).distance;
						currentLeast = nodes.get(town);
					}
				}
			}
			if (visitedNodes.size() == nodes.size()) {
				bool.setTrue();
			} else {
				location = currentLeast;
				visitedNodes.add(currentLeast);
			}
		}
		for (String town : nodes.keySet()) {
			LinkedList<LocationLink> path = new LinkedList<LocationLink>();
			Location node = nodes.get(town);
			while (!node.equals(start)) {
				if (node.distance <= distance) {
					path.add(node.previous);
				} else {
					break;
				}
				node = node.path;
			}
			if(path.size()>1){
				LocationLink first = path.getFirst();
				if(first.locationA.x != 0 && first.locationB.x != 0){
				options.add(path);
				}
			}
		}
		return options;
	}

	@Override
	public String toString() {
		String toReturn = "";
		for (String L : nodes.keySet()) {
			toReturn += nodes.get(L).toString() + "\n";
		}
		return toReturn;
	}

	private class MyBoolean {
		private boolean bool;

		public MyBoolean() {
			bool = false;
		}

		public void setTrue() {
			bool = true;
		}

		public void setFalse() {
			bool = false;
		}

		public boolean getValue() {
			return bool;
		}
	}

}
