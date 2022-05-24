import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

public class LocationLink extends JComponent {
	    Location locationA,locationB;
		String routeName, destinationName;
		Location dest;
		double travelDistance, travelDanger;
		Point2D[] points;
		
		@SuppressWarnings("unused")
		public LocationLink(Location cityA, Location cityB, String rName, double dist, double danger) {
			locationA = cityA;
			locationB = cityB;
			routeName = rName;
			travelDistance = dist;
			travelDanger = danger;
			points = null;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.GREEN);
			g2.setStroke(new BasicStroke(8));
			for (int i = 0; i < points.length - 1; i++) {
				g2.draw(new Line2D.Double(points[i], points[i + 1]));
			}
		}
		
		public void setPoints(Point2D[] p) {
			points = p;
		}
		
		public Point2D[] getPoints() {
			return points;
		}


		@SuppressWarnings("unused")
		public Location getLocationAName() {
			return locationA;
		}
		
		public Location getLocationBName(){
			return locationB;
		}

		@SuppressWarnings("unused")
		public String getRouteName() {
			return routeName;
		}

		@SuppressWarnings("unused")
		public double getTravelDistance() {
			return travelDistance;
		}

		@SuppressWarnings("unused")
		public double getTravelDanger() {
			return travelDanger;
		}
	}