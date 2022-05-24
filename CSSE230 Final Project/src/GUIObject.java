import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUIObject {

	public String[][] mapNodes;
	public JLabel start;
	public JLabel end;
	public boolean navigationMode;
	public boolean distanceParameter;
	public int tripPlannerDist;
	public int tripPlannerDanger;
	public Location location1;
	public Location location2;
	public Graph graph;
	public LinkedList<LocationLink> path;
	public LinkedList<LinkedList<LocationLink>> options;
	// start node, end node

	public GUIObject() {
		mapNodes = new String[45][28];
		path = new LinkedList<LocationLink>();
		options = new LinkedList<LinkedList<LocationLink>>();
		tripPlannerDist = 25;
		tripPlannerDanger = 25;
		fillGraph();
		makeGUI();
		new MusicPlayer();
	}

	public void fillGraph() {
		this.graph = new Graph();

		Location twinleafTown = new Location("Twinleaf Town", 80, 500);// x
		Location sandgemTown = new Location("Sandgem Town", 140, 480);// x
		Location jubilifeCity = new Location("Jubilife City", 140, 400);// x
		Location canalaveCity = new Location("Canalave City", 20, 400);// x
		Location oreburghCity = new Location("OreBurgh City", 260, 400);// x
		Location snowpointCity = new Location("Snowpoint City", 320, 20);// x
		Location floaromaTown = new Location("Floaroma Town", 140, 320);// x
		Location solaceonTown = new Location("Solaceon Town", 500, 340);// x
		Location eternaCity = new Location("Eterna City", 260, 240);// x
		Location hearthomeCity = new Location("Hearthome City", 420, 380);// x
		Location veilstoneCity = new Location("Veilstone City", 640, 300);// x
		Location pastoriaCity = new Location("Pastoria City", 540, 460);// x
		Location celesticTown = new Location("Celestic Town", 420, 240);// x
		Location sunyshoreCity = new Location("SunyShore City", 780, 420);// x
		Location pokemonLeague = new Location("Pokemon League", 780, 260);// x
		Location fightArea = new Location("Fight Area", 560, 180); // can get here through Snowpoint City x
		Location survivalArea = new Location("Survival Area", 600, 100);// x
		Location resortArea = new Location("Resort Area", 740, 200);// x
		Location ironIsland = new Location("Iron Island", 80, 220); // this location taken from a boat in canalave city
		Location fullMoonIsland = new Location("Full Moon Island", 20, 60); // this location is unlocked with cheat
																			// codes/ surf glich
		// this location can only be acssesed if full moon island has been acsessed then
		// this location will unlock through canalave city
		Location newMoonIsland = new Location("New Moon Island", 120, 60);
		Location flowerParadise = new Location("Flower Paradise", 840, 20); // can only be acsessed from 2010 to 2011 if
																			// you have betten the elite 4

		// locations that done have points on the map
		Location mtCoronetTopExit = new Location("Mt. Coronet Top Exit");// x
		Location mtCoronetBottemExit = new Location("Mt. Coronet Bottem Exit");// x
		Location route215Entrance = new Location("Route 215 Entrance");// x
		Location valorLakefront = new Location("Valor Lakefront");// x

		mapNodes[twinleafTown.x / 20][twinleafTown.y / 20] = twinleafTown.locationName;
		mapNodes[sandgemTown.x / 20][sandgemTown.y / 20] = sandgemTown.locationName;
		mapNodes[jubilifeCity.x / 20][jubilifeCity.y / 20] = jubilifeCity.locationName;
		mapNodes[canalaveCity.x / 20][canalaveCity.y / 20] = canalaveCity.locationName;
		mapNodes[oreburghCity.x / 20][oreburghCity.y / 20] = oreburghCity.locationName;
		mapNodes[snowpointCity.x / 20][snowpointCity.y / 20] = snowpointCity.locationName;
		mapNodes[floaromaTown.x / 20][floaromaTown.y / 20] = floaromaTown.locationName;
		mapNodes[solaceonTown.x / 20][solaceonTown.y / 20] = solaceonTown.locationName;
		mapNodes[eternaCity.x / 20][eternaCity.y / 20] = eternaCity.locationName;
		mapNodes[hearthomeCity.x / 20][hearthomeCity.y / 20] = hearthomeCity.locationName;
		mapNodes[veilstoneCity.x / 20][veilstoneCity.y / 20] = veilstoneCity.locationName;
		mapNodes[pastoriaCity.x / 20][pastoriaCity.y / 20] = pastoriaCity.locationName;
		mapNodes[celesticTown.x / 20][celesticTown.y / 20] = celesticTown.locationName;
		mapNodes[sunyshoreCity.x / 20][sunyshoreCity.y / 20] = sunyshoreCity.locationName;
		mapNodes[pokemonLeague.x / 20][pokemonLeague.y / 20] = pokemonLeague.locationName;
		mapNodes[fightArea.x / 20][fightArea.y / 20] = fightArea.locationName;
		mapNodes[survivalArea.x / 20][survivalArea.y / 20] = survivalArea.locationName;
		mapNodes[resortArea.x / 20][resortArea.y / 20] = resortArea.locationName;
		mapNodes[ironIsland.x / 20][ironIsland.y / 20] = ironIsland.locationName;
		mapNodes[fullMoonIsland.x / 20][fullMoonIsland.y / 20] = fullMoonIsland.locationName;
		mapNodes[newMoonIsland.x / 20][newMoonIsland.y / 20] = newMoonIsland.locationName;
		mapNodes[flowerParadise.x / 20][flowerParadise.y / 20] = flowerParadise.locationName;

		LocationLink route201 = new LocationLink(twinleafTown, sandgemTown, "Route 201", 2.625, 2.5);
		route201.setPoints(new Point2D[] { new Point2D.Double(90, 510), new Point2D.Double(90, 490),
				new Point2D.Double(150, 490) });
		LocationLink route202 = new LocationLink(sandgemTown, jubilifeCity, "Route 202", 6, 3.2);
		route202.setPoints(new Point2D[] { new Point2D.Double(150, 410), new Point2D.Double(150, 490) });
		LocationLink route203 = new LocationLink(jubilifeCity, oreburghCity, "Route 203", 2.625, 4.6);
		route203.setPoints(new Point2D[] { new Point2D.Double(270, 410), new Point2D.Double(150, 410) });
		LocationLink route204 = new LocationLink(jubilifeCity, floaromaTown, "Route 204", 4.375, 4.5);
		route204.setPoints(new Point2D[] { new Point2D.Double(150, 330), new Point2D.Double(150, 410) });
		LocationLink route205 = new LocationLink(floaromaTown, eternaCity, "Route 205", 2.125, 10);
		route205.setPoints(new Point2D[] { new Point2D.Double(150, 330), new Point2D.Double(190, 330),
				new Point2D.Double(190, 250), new Point2D.Double(270, 250) });
		LocationLink route206 = new LocationLink(oreburghCity, eternaCity, "Route 206", 3, 17.2);
		route206.setPoints(new Point2D[] { new Point2D.Double(270, 410), new Point2D.Double(270, 250) });
		LocationLink route218 = new LocationLink(canalaveCity, jubilifeCity, "Route 218", 2.75, 29);
		route218.setPoints(new Point2D[] { new Point2D.Double(30, 410), new Point2D.Double(150, 410) });
		LocationLink route209 = new LocationLink(hearthomeCity, solaceonTown, "Route 209", 3.5, 17.5);
		route209.setPoints(new Point2D[] { new Point2D.Double(430, 390), new Point2D.Double(510, 390),
				new Point2D.Double(510, 350) });
		LocationLink route212 = new LocationLink(hearthomeCity, pastoriaCity, "Route 212", 4.75, 23.3);
		route212.setPoints(new Point2D[] { new Point2D.Double(430, 390), new Point2D.Double(430, 470),
				new Point2D.Double(550, 470) });
		LocationLink route211 = new LocationLink(eternaCity, celesticTown, "Route 211", 2.5, 21.5);
		route211.setPoints(new Point2D[] { new Point2D.Double(430, 250), new Point2D.Double(270, 250) });
		LocationLink eternaToMtCoronetTop = new LocationLink(eternaCity, mtCoronetTopExit,
				"Mt.Coronet-Upper South Exit", 1.25, 14.5);
		eternaToMtCoronetTop.setPoints(new Point2D[] { new Point2D.Double(270, 250), new Point2D.Double(370, 250),
				new Point2D.Double(370, 160) });
		LocationLink celesticToMtCoronetTop = new LocationLink(celesticTown, mtCoronetTopExit,
				"Mt.Coronet-Upper South Exit", 1.25, 28.4);
		celesticToMtCoronetTop.setPoints(new Point2D[] { new Point2D.Double(430, 250), new Point2D.Double(370, 250),
				new Point2D.Double(370, 160) });
		LocationLink mtCoronetToptoSnowPointCity = new LocationLink(snowpointCity, mtCoronetTopExit, "Route 217", 4.25,
				33.6);
		mtCoronetToptoSnowPointCity.setPoints(new Point2D[] { new Point2D.Double(370, 160),
				new Point2D.Double(280, 160), new Point2D.Double(280, 30), new Point2D.Double(330, 30) });
		LocationLink oreburghToMtCoronetBottem = new LocationLink(oreburghCity, mtCoronetBottemExit,
				"Mt.Coronet-Lower South Exit", 3.0, 5.9);
		oreburghToMtCoronetBottem.setPoints(new Point2D[] { new Point2D.Double(340, 390), new Point2D.Double(270, 390),
				new Point2D.Double(270, 410) });
		LocationLink hearthomeToMtCoronetBottem = new LocationLink(hearthomeCity, mtCoronetBottemExit,
				"Mt.Coronet-Lower South Exit", 3.625, 18.6);
		hearthomeToMtCoronetBottem
				.setPoints(new Point2D[] { new Point2D.Double(340, 390), new Point2D.Double(430, 390) });
		LocationLink mtCoronetBottemToMtCoronetTop = new LocationLink(mtCoronetTopExit, mtCoronetBottemExit,
				"Mt.Coronet Center", 7.875, 35);
		mtCoronetBottemToMtCoronetTop.setPoints(new Point2D[] { new Point2D.Double(340, 390),
				new Point2D.Double(340, 320), new Point2D.Double(370, 320), new Point2D.Double(370, 160) });
		LocationLink celesticTownToRoute15 = new LocationLink(celesticTown, route215Entrance, "Route 210", 5.375, 19.8);
		celesticTownToRoute15.setPoints(new Point2D[] { new Point2D.Double(430, 250), new Point2D.Double(510, 250),
				new Point2D.Double(510, 310) });
		LocationLink solaceonTownToRoute15 = new LocationLink(solaceonTown, route215Entrance, "Route 210", 5.375, 19.8);
		solaceonTownToRoute15.setPoints(new Point2D[] { new Point2D.Double(510, 350), new Point2D.Double(510, 310) });
		LocationLink veilstoneCityToRoute15 = new LocationLink(veilstoneCity, route215Entrance, "Route 215", 2.625,
				20.6);
		veilstoneCityToRoute15.setPoints(new Point2D[] { new Point2D.Double(650, 310), new Point2D.Double(510, 310) });
		LocationLink veilstoneCityToValorLakefront = new LocationLink(veilstoneCity, valorLakefront, "Route 214", 3.5,
				22.3);
		veilstoneCityToValorLakefront
				.setPoints(new Point2D[] { new Point2D.Double(650, 430), new Point2D.Double(650, 310) });
		LocationLink pastoriaCityToValorLakefront = new LocationLink(pastoriaCity, valorLakefront, "Route 213", 4.75,
				24.5);
		pastoriaCityToValorLakefront
				.setPoints(new Point2D[] { new Point2D.Double(550, 470), new Point2D.Double(650, 470), new Point2D.Double(650, 430)});
		LocationLink sunyshoreCityToValorLakeFront = new LocationLink(sunyshoreCity, valorLakefront, "Route 222", 2.875,
				39.3);
		sunyshoreCityToValorLakeFront
				.setPoints(new Point2D[] { new Point2D.Double(790, 430), new Point2D.Double(650, 430) });
		LocationLink sunyshoreCityToPokemonLeague = new LocationLink(sunyshoreCity, pokemonLeague, "Route 223", 4.125,
				40);
		sunyshoreCityToPokemonLeague
				.setPoints(new Point2D[] { new Point2D.Double(790, 270), new Point2D.Double(790, 430) });
		LocationLink boatRideToFightArea = new LocationLink(snowpointCity, fightArea, "S.S. Spiral", 0.5, 0);
		boatRideToFightArea.setPoints(new Point2D[] { new Point2D.Double(330, 30), new Point2D.Double(570, 190) });
		LocationLink route225 = new LocationLink(fightArea, survivalArea, "Route 225", 3, 48.5);
		route225.setPoints(new Point2D[] { new Point2D.Double(570, 190), new Point2D.Double(570, 110),
				new Point2D.Double(610, 110) });
		LocationLink route230 = new LocationLink(fightArea, resortArea, "Route 230", 2.625, 48.4);
		route230.setPoints(new Point2D[] { new Point2D.Double(570, 190), new Point2D.Double(750, 190),
				new Point2D.Double(750, 210) });
		LocationLink route226 = new LocationLink(survivalArea, resortArea, "Route 226", 2.125, 48.9);
		route226.setPoints(new Point2D[] { new Point2D.Double(610, 110), new Point2D.Double(730, 110),
				new Point2D.Double(730, 190), new Point2D.Double(750, 190), new Point2D.Double(750, 210) });
		LocationLink boatRideToIronIsland = new LocationLink(canalaveCity, ironIsland, "Ferry to Iron Island", 0.5, 0);
		boatRideToIronIsland.setPoints(new Point2D[] { new Point2D.Double(30, 410), new Point2D.Double(90, 230) });
		LocationLink boatRideToFullMoonIsland = new LocationLink(canalaveCity, fullMoonIsland,
				"Ferry To Full Moon Island", 0.5, 0);
		boatRideToFullMoonIsland.setPoints(new Point2D[] { new Point2D.Double(30, 410), new Point2D.Double(30, 70) });
		LocationLink boatRideToNewMoonIsland = new LocationLink(canalaveCity, newMoonIsland, "Ferry to New Moon Island",
				0.5, 0);
		boatRideToNewMoonIsland.setPoints(new Point2D[] { new Point2D.Double(30, 410), new Point2D.Double(130, 70) });
		LocationLink seabreakPath = new LocationLink(pokemonLeague, flowerParadise, "Seabreak Path", 8.0, 47.7);
		seabreakPath.setPoints(new Point2D[] { new Point2D.Double(790, 270), new Point2D.Double(815, 270),
				new Point2D.Double(815, 250), new Point2D.Double(850, 250), new Point2D.Double(850, 30) });

		twinleafTown.addLink(route201);

		sandgemTown.addLink(route201);
		sandgemTown.addLink(route202);

		jubilifeCity.addLink(route202);
		jubilifeCity.addLink(route203);
		jubilifeCity.addLink(route204);
		jubilifeCity.addLink(route218);

		canalaveCity.addLink(route218);
		canalaveCity.addLink(boatRideToFullMoonIsland);
		canalaveCity.addLink(boatRideToNewMoonIsland);
		canalaveCity.addLink(boatRideToIronIsland);

		oreburghCity.addLink(route203);
		oreburghCity.addLink(route206);
		oreburghCity.addLink(oreburghToMtCoronetBottem);

		snowpointCity.addLink(mtCoronetToptoSnowPointCity);
		snowpointCity.addLink(boatRideToFightArea);

		floaromaTown.addLink(route205);
		floaromaTown.addLink(route204);

		solaceonTown.addLink(route209);
		solaceonTown.addLink(solaceonTownToRoute15);

		eternaCity.addLink(route205);
		eternaCity.addLink(route206);
		eternaCity.addLink(eternaToMtCoronetTop);
		eternaCity.addLink(route211);

		hearthomeCity.addLink(hearthomeToMtCoronetBottem);
		hearthomeCity.addLink(route209);
		hearthomeCity.addLink(route212);

		veilstoneCity.addLink(veilstoneCityToRoute15);
		veilstoneCity.addLink(veilstoneCityToValorLakefront);

		pastoriaCity.addLink(route212);
		pastoriaCity.addLink(pastoriaCityToValorLakefront);

		celesticTown.addLink(celesticTownToRoute15);
		celesticTown.addLink(celesticToMtCoronetTop);
		celesticTown.addLink(route211);

		sunyshoreCity.addLink(sunyshoreCityToValorLakeFront);
		sunyshoreCity.addLink(sunyshoreCityToPokemonLeague);

		pokemonLeague.addLink(sunyshoreCityToPokemonLeague);
		pokemonLeague.addLink(seabreakPath);

		mtCoronetTopExit.addLink(mtCoronetToptoSnowPointCity);
		mtCoronetTopExit.addLink(eternaToMtCoronetTop);
		mtCoronetTopExit.addLink(celesticToMtCoronetTop);
		mtCoronetTopExit.addLink(mtCoronetBottemToMtCoronetTop);

		mtCoronetBottemExit.addLink(mtCoronetBottemToMtCoronetTop);
		mtCoronetBottemExit.addLink(oreburghToMtCoronetBottem);
		mtCoronetBottemExit.addLink(hearthomeToMtCoronetBottem);

		route215Entrance.addLink(celesticTownToRoute15);
		route215Entrance.addLink(veilstoneCityToRoute15);
		route215Entrance.addLink(solaceonTownToRoute15);

		valorLakefront.addLink(veilstoneCityToValorLakefront);
		valorLakefront.addLink(pastoriaCityToValorLakefront);
		valorLakefront.addLink(sunyshoreCityToValorLakeFront);

		fightArea.addLink(boatRideToFightArea);
		fightArea.addLink(route225);
		fightArea.addLink(route230);

		survivalArea.addLink(route225);
		survivalArea.addLink(route226);

		resortArea.addLink(route230);
		resortArea.addLink(route226);

		ironIsland.addLink(boatRideToIronIsland);
		fullMoonIsland.addLink(boatRideToFullMoonIsland);
		newMoonIsland.addLink(boatRideToNewMoonIsland);

		flowerParadise.addLink(seabreakPath);

		graph.addLocation("Twinleaf Town", twinleafTown);
		graph.addLocation("Sandgem Town", sandgemTown);
		graph.addLocation("Jubilife City", jubilifeCity);
		graph.addLocation("Canalave City", canalaveCity);
		graph.addLocation("OreBurgh City", oreburghCity);
		graph.addLocation("Snowpoint City", snowpointCity);
		graph.addLocation("Floaroma Town", floaromaTown);
		graph.addLocation("Solaceon Town", solaceonTown);
		graph.addLocation("Eterna City", eternaCity);
		graph.addLocation("Hearthome City", hearthomeCity);
		graph.addLocation("Veilstone City", veilstoneCity);
		graph.addLocation("Pastoria City", pastoriaCity);
		graph.addLocation("Celestic Town", celesticTown);
		graph.addLocation("SunyShore City", sunyshoreCity);
		graph.addLocation("Pokemon League", pokemonLeague);
		graph.addLocation("Fight Area", fightArea);
		graph.addLocation("Survival Area", survivalArea);
		graph.addLocation("Resort Area", resortArea);
		graph.addLocation("Iron Island", ironIsland);
		graph.addLocation("Full Moon Island", fullMoonIsland);
		graph.addLocation("New Moon Island", newMoonIsland);
		graph.addLocation("New Moon Island", newMoonIsland);
		graph.addLocation("Flower Paradise", flowerParadise);

		graph.addLocation("Mt. Coronet Top Exit", mtCoronetTopExit);
		graph.addLocation("Mt. Coronet Bottom Exit", mtCoronetBottemExit);
		graph.addLocation("Route 216 Entrance", route215Entrance);
		graph.addLocation("Valor Lakefront", valorLakefront);
	}

	public void makeGUI() {
		final JFrame frame = new JFrame("Pokemon Platinum Navigation System");
		final GUIComponent component = new GUIComponent();
		component.setPreferredSize(new Dimension(900, 545));
		JPanel panel = new JPanel(new BorderLayout());
		JPanel innerPanelTop = new JPanel();
		JPanel innerPanelLeft = new JPanel(new GridLayout(4, 0));
		JPanel innerPanelRight = new JPanel(new GridLayout(4, 0));
		JPanel innerPanelBottom = new JPanel(new GridLayout(2, 2));
		JPanel innerPanelCenter = new JPanel(new GridLayout(4, 0));
		JButton clearButton = new JButton();
		clearButton.setText("Clear");
		JButton findButton = new JButton();
		findButton.setText("Find");

		final JRadioButton mode1 = new JRadioButton("Navigation");
		final JRadioButton mode2 = new JRadioButton("Trip Planner");
		mode1.setSelected(true);
		ButtonGroup g1 = new ButtonGroup();
		g1.add(mode1);
		g1.add(mode2);

		final JRadioButton par1 = new JRadioButton("Distance");
		final JRadioButton par2 = new JRadioButton("Danger");
		par1.setSelected(true);
		ButtonGroup g2 = new ButtonGroup();
		g2.add(par1);
		g2.add(par2);

		final JSlider distSlide = new JSlider();
		final JSlider dangerSlide = new JSlider();
		distSlide.setMaximum(25);
		dangerSlide.setMaximum(25);
		distSlide.setPaintTrack(true);
		distSlide.setPaintTicks(true);
		distSlide.setPaintLabels(true);
		dangerSlide.setPaintTrack(true);
		dangerSlide.setPaintTicks(true);
		dangerSlide.setPaintLabels(true);
		distSlide.setMajorTickSpacing(5);
		distSlide.setMinorTickSpacing(1);
		dangerSlide.setMajorTickSpacing(5);
		dangerSlide.setMinorTickSpacing(1);
		final JLabel distLabel = new JLabel();
		distLabel.setText("Max Distance: " + distSlide.getValue());
		final JLabel dangerLabel = new JLabel();
		dangerLabel.setText("Max Danger: " + dangerSlide.getValue());
		

		JLabel directionText = new JLabel();
		JLabel direction2 = new JLabel();
		start = new JLabel();
		end = new JLabel();
		directionText.setText("   For navigation: select two points, select a parameter, and press find.");
		direction2.setText("   For trip planner: select one point, select a parameter, move slider to desired value, and press find.");
		start.setText("  Start: ");
		end.setText("   End: ");

		distSlide.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				tripPlannerDist = distSlide.getValue();
				distLabel.setText("Max Distance: " + tripPlannerDist);
			}
		});
		dangerSlide.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				tripPlannerDanger = dangerSlide.getValue();
				dangerLabel.setText("Max Danger: " + tripPlannerDanger);
			}
		});

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				location1 = null;
				location2 = null;
				path.clear();
				options.clear();
				start.setText("  Start: ");
				end.setText("   End: ");
				component.repaint();

			}

		});
		findButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (mode1.isSelected()) {
					if (location1 != null && location2 != null) {
						if (par1.isSelected()) {
							// dickstraws distance
							path = graph.distanceDijkstras(location1, location2);
						} else {
							path = graph.dangerDijkstras(location1, location2);
						}
						component.repaint();
					} else {
						JOptionPane.showMessageDialog(frame, "Navigation requires two points");
					}
				} else {
					if (location1 != null) {
						if (par1.isSelected()) {
							// tripPlanner distance
							options = graph.tripPlanner(location1, tripPlannerDist);
							System.out.println(tripPlannerDist);
						} else {
							//path = graph.dangerDijkstras(location1, location2);
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Trip Planner requires one point");
					}
					component.repaint();
				}

			}

		});

		innerPanelTop.setPreferredSize(new Dimension(900, 100));
		innerPanelLeft.setPreferredSize(new Dimension(300, 200));
		innerPanelRight.setPreferredSize(new Dimension(300, 200));
		innerPanelCenter.setPreferredSize(new Dimension(300, 200));
		innerPanelBottom.setPreferredSize(new Dimension(900, 100));

		innerPanelTop.add(directionText);
		innerPanelTop.add(direction2);
		innerPanelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
		innerPanelLeft.add(mode1);
		innerPanelLeft.add(mode2);
		innerPanelRight.add(start);
		innerPanelRight.add(end);
		innerPanelRight.add(clearButton);
		innerPanelRight.add(findButton);
		innerPanelCenter.add(par1);
		innerPanelCenter.add(par2);
		innerPanelBottom.add(distSlide);
		innerPanelBottom.add(dangerSlide);
		innerPanelBottom.add(distLabel);
		innerPanelBottom.add(dangerLabel);

		innerPanelTop.setBorder(BorderFactory.createTitledBorder("Directions"));
		innerPanelLeft.setBorder(BorderFactory.createTitledBorder("Mode"));
		innerPanelRight.setBorder(BorderFactory.createTitledBorder("Ready"));
		innerPanelCenter.setBorder(BorderFactory.createTitledBorder("Search Parameter"));
		innerPanelBottom.setBorder(BorderFactory.createTitledBorder("Trip Planner Input"));

		panel.add(innerPanelTop, BorderLayout.NORTH);
		panel.add(innerPanelLeft, BorderLayout.WEST);
		panel.add(innerPanelRight, BorderLayout.EAST);
		panel.add(innerPanelCenter, BorderLayout.CENTER);
		panel.add(innerPanelBottom, BorderLayout.SOUTH);

		frame.add(component, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public class GUIComponent extends JComponent {

		public Image mep;
		public Color switchOnColor = Color.GREEN;
		public Color switchOffColor = Color.GRAY;

		public GUIComponent() {
			try {
				this.mep = ImageIO.read(new File("./mep.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.addMouseListener(new ClickListener());
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			g2.drawImage(mep, 0, 0, 900, 545, null);

			Location current;
			for (int row = 0; row < 45; row++) {
				for (int col = 0; col < 28; col++) {
					current = graph.getLocation(mapNodes[row][col]);
					if (current != null) {
						g2.setColor(Color.BLACK);
						g2.fillRect(current.x, current.y, 20, 20);
						g2.setColor(Color.CYAN);
						g2.fillRect(current.x + 2, current.y + 2, 16, 16);
					}
//					g2.setColor(Color.BLACK);
//					g2.drawRect(row*20, col*20, 20, 20);
				}
			}
//			
//			Location l = graph.getLocation("Jubilife City");
//			LocationLink ll = l.adjacentLocations.getFirst();
//			ll.paintComponent(g2);
//			
			if (!path.isEmpty()) {
				for (LocationLink link : path) {
					link.paintComponent(g2);
				}
			}
			
			if (!options.isEmpty()) {
				for (LinkedList<LocationLink> list : options) {
					for (LocationLink link : list) {
						link.paintComponent(g2);
					}
				}
			}
			
			if (location1 != null) {
				// get x-y coord, fill rect
				g2.setColor(Color.BLACK);
				g2.fillRect(location1.x, location1.y, 20, 20);
				g2.setColor(Color.GREEN);
				g2.fillRect(location1.x + 2, location1.y + 2, 16, 16);

			}
			if (location2 != null) {
				// get x-y coord, fill rect
				g2.setColor(Color.BLACK);
				g2.fillRect(location2.x, location2.y, 20, 20);
				g2.setColor(Color.RED);
				g2.fillRect(location2.x + 2, location2.y + 2, 16, 16);
			}
		}

		class ClickListener implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = arg0.getX() / 20;
				int col = arg0.getY() / 20;
				// System.out.println(arg0.getX() + ", " + arg0.getY());
				Location clicked = graph.getLocation(mapNodes[row][col]);
				if (clicked != null) {
					if (location1 == null) {
						location1 = clicked;
						start.setText("  Start: " + location1.locationName);
					} else if (location2 == null && !location1.equals(clicked)) {
						location2 = clicked;
						end.setText("   End: " + location2.locationName);
					}
				}
				// global variables for location 1 and location 2
				// if both are full, clear both, start again
//				} else if (col == 52 && row == 22) {
//					if (location1 != null && location2 != null) {
//						System.out.println("ruuuuuuuun");
//					//call pathfinder
//					//fill globalvariable arraylist with nodes
//					//call repaint
//					//clear location 1 and location 2
//					}
//				}
				repaint();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		}

	}
}
