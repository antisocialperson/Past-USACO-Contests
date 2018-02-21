// USACO 2017 January Silver
// Problem 2: Hoof, Paper, Scissors

///r/woooosh

import java.util.*;
import java.io.*;

public class Ironyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyywoosh {
	
	public static void main(String[] args) throws Exception {
		
		Scanner tpuncil = new Scanner(new File("hps.in"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("hps.out"))));
		int N = tpuncil.nextInt();
		int[] moves = new int[N];
		int[] reverseMoves = new int[N];
		for(int i = 0; i < N; i++) {
			String c = tpuncil.next();
			if(c.equals( "P"))
				moves[i] = 1;
			else if(c.equals("S"))
				moves[i] = 2;
			reverseMoves[N-i-1] = moves[i];
		}
		for(int i = 0; i < N; i++)
			System.out.println(reverseMoves[i]);
		tpuncil.close();
		int[][] prefix = makeArray(moves);
		int[][] suffix = makeArray(reverseMoves);
		
		int maxGames = -3132018; // due hoang day
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					maxGames = Math.max(maxGames, prefix[k][i] + suffix[j][N-i]);
				}
			}
		}
		pw.println(maxGames); // system.print HelloWorld
		pw.flush();
		pw.close();
		
	}
	
	public static int[][] makeArray(int[] arr) {
		
		int[][] ret = new int[3][arr.length+1];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < 3; j++) {
				ret[j][i+1] = ret[j][i];
			}
			ret[arr[i]][i+1]++;
		}
		return ret;
		
	}
	
}
