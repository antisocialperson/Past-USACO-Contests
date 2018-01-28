// USACO Silver 2018 January Contest
// Problem 2: Rental Service

// Since the contest is over I won't be banned for life :)

import java.util.*;
import java.io.*;
import java.awt.Point;

public class Rental {
	
	public static void sort(int[] l) {
		Arrays.sort(l);
		for(int i = 0; i < l.length-1-i; i++) {
			l[i] ^= l[l.length-1-i];
			l[l.length-1-i] ^= l[i];
			l[i] ^= l[l.length-1-i];
		}
	}
	
	static class comp implements Comparator <Point> {

		public int compare(Point arg0, Point arg1) {
			
			return arg1.x-arg0.x;
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner qw = new Scanner(new File("rental.in"));
		PrintWriter er = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("rental.out"))));
		int N = qw.nextInt();
		int M = qw.nextInt();
		int R = qw.nextInt();
		int[] product = new int[N]; // The cows' milk product
		for(int i = 0; i < N; i++) {
			product[i] = qw.nextInt();
		}
		sort(product);
		// Shops are points
		Point[] shops = new Point[M];
		for(int i = 0; i < M; i++) {
			shops[i] = new Point();
			shops[i].y = qw.nextInt();
			shops[i].x = qw.nextInt();
		}
		Arrays.sort(shops, new comp());
		long[] prof = new long[N+1];
		
		int ind = 0; // selling milk
		for(int i = 0; i < N; i++) {
			prof[i+1] = prof[i];
			while(ind < M && product[i] > 0) {
				int tm = Math.min(product[i], shops[ind].y);
				prof[i+1] += tm*(long)(shops[ind].x);
				shops[ind].y -= tm;
				product[i] -= tm;
				if(shops[ind].y == 0)
					ind++;
			}
		}
		
		int[] renters = new int[R]; // The people who want to rent
		for(int i = 0; i < R; i++) {
			renters[i] = qw.nextInt();
		}
		sort(renters);
		// All of the arrays are now sorted
		
		// Rental = 0
		ind = N-1;
		int re = 0;
		long rnp = 0;
		while(ind >= 0 && re < R) {
			rnp += renters[re]; // add one rental cost
			prof[ind] += rnp; // add that to profit
			re++;
			ind--; // adjust indices
		}
		
		long mx = 0;
		for(long i : prof) { // long i in the profit
			mx = Math.max(i, mx);
		}
		er.println(mx);
		qw.close();
		er.flush();
		er.close();
		
	}
	
}
