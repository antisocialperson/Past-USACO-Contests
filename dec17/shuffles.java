// December 2017 USACO Silver Competition
// Problem 3: The Bovine Shuffle

import java.util.*;
import java.io.*;

public class shuffles {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new InputStreamReader(new FileInputStream(new File("shuffle.in"))));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("shuffle.out"))));
		
		int N = in.nextInt();
		int[] a = new int[N]; // N, A defined as in problem
		int[] b = new int[N]; // companion to a is b
		for(int i = 0; i < N; i++) {
			a[i] = in.nextInt() - 1;
			b[a[i]]++;
		}
		int locs = N; // start off with the number of locations as N
		ArrayList<Integer> q = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			if(b[i] == 0) {
				locs--; // locations go down by 1
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int i = q.get(q.size()-1); // remove last element
			int size = q.size();
			q.remove(size-1); // actually remove the element
			if(--b[a[i]] == 0) {
				q.add(a[i]); // if it becomes 0 after moving away add back
				locs--; // go down by 1
			}
		}
		pw.println(locs);
		pw.flush();
		pw.close();
		in.close();
		
	}
	
}
