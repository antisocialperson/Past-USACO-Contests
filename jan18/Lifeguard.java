// USACO 2018 January Silver Contest
// Problem 1: Lifeguards

// THE CONTEST IS OVER SO I WON'T BE BANNED BY USACO

import java.util.*;
import java.io.*;
import java.awt.Point;

public class Lifeguards {

	private static class cmp implements Comparator <Point> {

		public int compare(Point arg0, Point arg1) {
			// TODO Auto-generated method stub
			return arg0.x-arg1.x;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new File("lifeguards.in"));
		PrintWriter fa = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("lifeguards.out"))));
		int N = sc.nextInt();
		Point[] intv = new Point[2*N];
		// a set containing all working lifeguards
		TreeSet<Integer> jobs = new TreeSet<Integer>(); // Jobs, Jobs, Jobs! -Donald Trump, 2018
		for(int i = 0; i < N; i++) {
			intv[2*i] = new Point(sc.nextInt(), i); // start
			intv[2*i+1] = new Point(sc.nextInt(), i); // end
		}
		// sorting times / points of interest
		Arrays.sort(intv, new cmp());
		int coverage = 0; // coverave = the sum of times
		int[] alone = new int[N]; // the amount of time that they work alone
		int prev = 0;
		for(Point cw : intv) {
			if(jobs.size() == 1) {
				alone[jobs.first()] = cw.x - prev;
			} // only one person at this time
			if(!jobs.isEmpty()) {
				coverage += cw.x - prev;
			} // someone is there
			if(jobs.contains(cw.y))
				jobs.remove(cw.y); // end of session
			else
				jobs.add(cw.y); // beginning of session
			prev = cw.x; // the previous one dealt with
		}
		
		int maxCover = -313;
		for(int i = 0; i < N; i++) {
			maxCover = Math.max(maxCover, coverage-alone[i]); // maximum coverage so far, time without cow i
		}
		
		fa.println(maxCover); // self explanatory
		fa.flush();
		fa.close();
		sc.close();
		
	}
	
}
