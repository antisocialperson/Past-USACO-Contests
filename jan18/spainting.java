import java.util.*;
import java.io.*;

public class spainting {

	// GIVEN
	private static final int MODULUS = 1000000007;
	private static long[] dpSum; // complementary sum
	
	public static void main(String[] args) throws IOException {
		
		// GIVEN
		Scanner sc = new Scanner(new File("spainting.in"));
		PrintWriter pw = new PrintWriter(new File("spainting.out"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		dpSum = new long[n+1]; // in {0, 1, 2, ...., n-1, n}
		dpSum[0] = 0; // beginning is 0 because you need at least one color
		
		// address base cases
		
		for(int i = 1; i < k; i++) {
			// base cases, less than K
			dpSum[i] = (m*(dpSum[i-1]) + m) % MODULUS;
		}
		
		// apply a recursion
		
		for(int i = k; i <= n; i++) {
			dpSum[i] = (m*(dpSum[i-1]) + MODULUS - ((m-1)*(dpSum[i-k])) % MODULUS) % MODULUS;
		}
		
		// without restrictions the number of cases you have
		// do not do Math.pow because a million to a million is not fun
		
		long poss = 1;
		for(int i = 0; i < n; i++) {
			poss = m * poss % MODULUS;
		}
		
		pw.println((poss - dpSum[n] + MODULUS + dpSum[n-1]) % MODULUS);
		pw.flush();
		pw.close();
		
	}

}
