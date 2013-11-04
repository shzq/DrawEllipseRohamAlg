package com.drawellipserohamalg;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DrawEllipeRohamAlg {
	
	// Hard coded focus
	private Focus a = new Focus(0,1);
	private Focus b = new Focus(2,0);
	private Focus c = new Focus(3,5);
	private Focus d = new Focus(5,5);
	private Focus e = new Focus(5,7);
	
	// Add foci into one array
	private List<Focus> foci = new ArrayList<Focus>();
	
	private final static double C = 25;
	private final double STEPSIZE = 0.05;
	private final static double THRESHOLD = 0.1;
	
	private static List<Double> px = new ArrayList<Double>();
	private static List<Double> py = new ArrayList<Double>();
	
	
	public void main(String[] args) {
		
		foci.add(a);
		foci.add(b); // foci.add(c); foci.add(d); foci.add(e);
		
		double ax = 0;
		for (int i = 0; i < foci.size(); i++) {
			ax += foci.get(i).getPoint().getX();
		}
		ax = ax/foci.size();
		
		double ay = 0;
		for (int i = 0; i < foci.size(); i++) {
			ay += foci.get(i).getPoint().getY();
		}
		ay = ay/foci.size();
		
		for (double i = ax; i <= C; i += STEPSIZE) {
			for (double j = ay; j <= C; j += STEPSIZE) {
				Calculate.sumOfDistance(foci, i, j);
			}
		}
		
		for (double i = -C; i <= ax; i += STEPSIZE) {
			for (double j = ay; j <= C; j += STEPSIZE) {
				Calculate.sumOfDistance(foci, i, j);
			}
		}
		
		for (double i = ax; i <= C; i += STEPSIZE) {
			for (double j = -C; j <= ay; j += STEPSIZE) {
				Calculate.sumOfDistance(foci, i, j);
			}
		}
		
		for (double i = -C; i <= ax; i += STEPSIZE) {
			for (double j = -C; j <= ay; j += STEPSIZE) {
				Calculate.sumOfDistance(foci, i, j);
			}
		}
	}
	
	private static class Calculate {
		
		private static void sumOfDistance(List<Focus> foci, double i, double j) {
			double d = 0;	
			for (int k = 0; k < foci.size(); k++) {
					d = Math.sqrt( Math.pow(foci.get(k).getPoint().getX() - i, 2) + Math.pow(foci.get(k).getPoint().getY(), 2) );
				}
			d -= C;
			if (Math.abs(d) < THRESHOLD) {
				px.add(i);
				py.add(j);
			}
		}
	}
	
}