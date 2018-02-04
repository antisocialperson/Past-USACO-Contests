// USACO January 2018 Silver Contest
// Problem 1: Lifeguards
// With custom class Time, instead of java.awt.Point

import java.util.*;
import java.io.*;

public class Lifeguards {
	
	private static class Time implements Comparable<Time> {
		int t, i;
		
		public int compareTo(Time tm) {
			return t-tm.t;
		}
		
		public Time(int t, int i) {
			this.t = t;
			this.i = i;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new FileInputStream(new File("lifeguards.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("lifeguards.out"))));
		int N = in.nextInt();
		Time[] times = new Time[2*N];
		for(int i = 0; i < N; i++) {
			times[2*i] = new Time(in.nextInt(), i);
			times[2*i+1] = new Time(in.nextInt(), i);
		}
		
		Arrays.sort(times);
		
		in.close();
		
		int[] tLost = new int[N];
		TreeSet<Integer> s = new TreeSet<Integer>();
		int sum = 0;
		int o = 0;
		
		for(Time t : times) {
			if(s.size() == 1) {
				tLost[s.first()] = t.t-o;
			}
			if(!s.isEmpty()) {
				sum += t.t-o;
			}
			if(s.contains(t.i)) {
				s.remove(t.i);
			}
			else {
				s.add(t.i);
			}
			o = t.t;
		}
		int maxCover = -1;
		for(int i : tLost) {
			maxCover = Math.max(maxCover, sum - i);
		}
		pw.println(maxCover);
		pw.flush();
		pw.close();
		
	}
	
}
