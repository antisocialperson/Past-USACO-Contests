// USACO 2017 January Silver Contest
// Problem 1: Cow Dance

import java.util.*;
import java.io.*;

public class Cowdance {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream(new File("cowdance.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("cowdance.out"))));
		int N = sc.nextInt(); // as defined in problem
		int T = sc.nextInt(); // Maximum T
		int[] dur = new int[N]; // duration
		for(int i = 0; i < N; i++) {
			dur[i] = sc.nextInt();
		}
		
		int lo = 0; // smallest k
		int hi = N; // biggest k
		while(lo != hi) {
			int mid = (lo+hi)/2; // mean k
			if(works(dur, mid, T)) // mean is possible
				hi = mid; // high becomes mean
			else // otherwise
				lo = mid + 1; // low becomes 1 more than mean
		}
		pw.println(lo);
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static boolean works(int[] durations, int k, int maxt) {
		int last = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < durations.length; i++) {
			if(q.size() == k)
				last = q.poll(); // take and remove
			if(last + durations[i] > maxt) // if last removal + duration > max time
				return false;
			q.add(last + durations[i]); // add last removal + duration
		}
		return true;
	}
	
}
