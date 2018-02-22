// USACO Gold January 2017 Contest
// Problem 1: Balanced Photo

import java.util.*;
import java.io.*;

public class BalancedPhoto {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("bphoto.in"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("bphoto.out"))));
		int N = in.nextInt();
		
		Cow[] cws = new Cow[N];
		for(int i = 0; i < N; i++) {
			cws[i] = new Cow(in.nextInt(), i);
		}
		in.close();
		
		Arrays.sort(cws);
		int unb = 0;
		int seen = 0;
		Tree t = new Tree(N);
		for(Cow cw : cws) {
			int left = t.query(cw.index);
			int right = seen-left;
			if(Math.max(left, right) > 2*Math.min(left, right))
				unb++;
			t.update(cw.index, 1);
			seen++;
		}
		pw.println(unb);
		pw.flush();
		pw.close();
		
	}
	
	private static class Cow implements Comparable<Cow> {
		
		public int height, index;
		
		public Cow(int height, int index) {
			this.height = height;
			this.index = index;
		}

		public int compareTo(Cow arg0) {
			return arg0.height - height;
		}
		
	}
	
	private static class Tree {
		
		public static int[] arr;
		
		public Tree(int N) {
			arr = new int[N+5];
		}
		
		public static void update(int ind, int val) {
			
			ind++;
			while(ind < arr.length) {
				arr[ind] += val;
				ind += ind & -ind;
			}
			
		}
		
		public static int query(int ind) {
			
			int arg = 0;
			while(ind > 0) {
				arg += arr[ind];
				ind -= ind & -ind;
			}
			return arg;
			
		}
		
	}
	
}
