// My Cow Ate My Homework in Java

import java.util.*;
import java.io.*;

public class homework {

	static long[] suffixSum;
	static long[] minSoFar;
	
	public static void main(String[] args) throws Exception{
		
		Scanner in = new Scanner(new FileInputStream(new File("homework.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("homework.out"))));
		int N = in.nextInt();
		long[] scores = new long[N+1];
		suffixSum = new long[N+1];
		minSoFar = new long[N+1];
		for(int i = 1; i <= N; i++) {
			scores[i] = in.nextLong();
		}
		suffixSum[N] = scores[N];
		minSoFar[N] = scores[N];
		for(int i = N-1; i >= 1; i--) {
			suffixSum[i] = suffixSum[i+1] + scores[i];
			minSoFar[i] = Math.min(minSoFar[i+1], scores[i]);
		}
		// the sum is just a running total
		// the minimum becomes the minimum of the old minimum and the new score
		// subtract minSoFar[i] from suffixSum[i];
		// (minSoFar[i]-suffixSum[i]) * some number = some other number * (N-i-1)
		long someNum = 0; // lol reversed
		long someOtherNum = 1;
		for(int i = 1; i <= N-2; i++) {
			if((suffixSum[i+1] - minSoFar[i+1]) * someOtherNum > someNum * (N-i-1)) {
				someNum = suffixSum[i+1] - minSoFar[i+1];
				someOtherNum = N-i-1;
			}
		}
		for(int i = 1; i <= N-2; i++) {
			if((suffixSum[i+1] - minSoFar[i+1]) * someOtherNum == someNum * (N-i-1)) {
				pw.println(i);
			}
		}
		in.close();
		pw.flush();
		pw.close();
	}

}
