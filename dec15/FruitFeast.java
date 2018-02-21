// USACO 2015 December Contest, Gold
// Problem 2: Fruit Feast

import java.util.*;
import java.io.*;

public class FruitFeast {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("feast.in"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("feast.out"))));
		int t = in.nextInt();
		int orange = in.nextInt();
		int lemon = in.nextInt();
		in.close();
		boolean[][] dp = new boolean[2][t+1]; // dp[0][k] = can drink, dp[1][k] = can't
		dp[0][0] = true; // eating nothing and drinking nothing works pretty well
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j <= t; j++) {
				if(!dp[i][j])
					continue; // that's why we start at 0 0 lol
				if(j + orange <= t) {
					dp[i][j+orange] = true;
				}
				if(j + lemon <= t) {
					dp[i][j+lemon] = true;
				}
				if(i == 0) {
					dp[1][j/2] = true;
				}
			}
		}
		
		int max = t;
		while(!dp[1][max])
			--max;
		pw.println(max);
		pw.flush();
		pw.close();
		
	}
	
}
