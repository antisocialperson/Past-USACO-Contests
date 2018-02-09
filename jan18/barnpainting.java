// December 2017 USACO Gold Contest
// Problem 2: Barn Painting

import java.util.*;
import java.io.*;

public class barnpainting {

	public static final int MOD = (int) (Math.pow(10, 9) + 7);
	static long[][] dp;
	static int[] col;
	static LinkedList<Integer>[] list;
	
	public static void main(String[] args) throws Exception, Error { // lol
		
		Scanner sc = new Scanner(new FileInputStream(new File("barnpainting.in")));
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("barnpainting.out")));
		int N = sc.nextInt();
		int K = sc.nextInt();
		col = new int[N];
		list = new LinkedList[N];
		dp = new long[N][3];
		Arrays.fill(col, -1);
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
			list[i] = new LinkedList();
		}
		// same links as in the Silver problem / Gold problem MooTube this mo.
		for(int i = 0; i < N-1; i++) {
			int b1 = sc.nextInt()-1;
			int b2 = sc.nextInt()-1;
			list[b1].add(b2);
			list[b2].add(b1);
		}
		for(int i = 0; i < K; i++) {
			int ind = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			col[ind] = c;
		}
		
		pw.println((ways(0, 0, -1, -1) + ways(0, 1, -1, -1) + ways(0, 2, -1, -1))
				%MOD);
		
		pw.flush();
		pw.close();
		sc.close();
		
	}
	
	private static long ways(int vertex, int color, int parentv, int parentc) {
		
		if(color == parentc || col[vertex] >= 0 && col[vertex] != color)
			return 0; // bessie will be confused or this just is ... not going to work
			// the color has to be the same, clearly
		if(dp[vertex][color] >= 0)
			return dp[vertex][color]; // already the state for this vertex and color
		dp[vertex][color] = 1;
		for(int i : list[vertex]) {
			// for each kid
			if(i == parentv)
				continue; // just going back the same place we came from
			// would amount to a TLE clearly
			long ways = 0;
			for(int co = 0; co < 3; co++) {
				ways += ways(i, co, vertex, color); // continue going along
				ways %= MOD; // dealing with modular condition
			}
			dp[vertex][color] *= ways; // clearly multiplication
			dp[vertex][color] %= MOD; // dealing with modular condition
		}
		
		return dp[vertex][color];
	}
	
}
