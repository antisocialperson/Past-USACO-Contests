// same as maxcross.cpp

import java.util.*;
import java.io.*;

public class Maxcross {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream(new File("maxcross.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream
				(new File("maxcross.out"))));
		int n = sc.nextInt();
		int k = sc.nextInt();
		int b = sc.nextInt();
		int[] broken = new int[b];
		for(int i = 0; i < b; i++) {
			broken[i] = sc.nextInt();
		}
		Arrays.sort(broken);
		// we want the broken indices because we would rather it not start at a point
		// that we need to fix than have it start at a point we need to fix
		
		// if we need to fix the one we start at, we would need to, at the worst case,
		// fix one that we need to fix + the (k-1) lights after
		
		// if we do not need to fix it, then we would only need, in the worst case,
		// the (k-1) lights after
		
		// so starting at a good one is good
		int h = 0;
		// h is biggest index of broken[]
		while(h < b && broken[h] <= k)
			h++;
		
		int done = h;
		for(int i = 0; i < b; i++) {
			// no need to reset because broken[i] keeps getting bigger
			if(broken[i] + k > n)
				break; // it's not going to work anyways
			while(h < b && broken[h] <= broken[i] + k)
				h++; // h is not high enough for algorithm to run
			done = Math.min(done, h-i-1);
		}
		// if the current index + k is too big just give up
		// if the current index is too small then make a change
		// change current value
		pw.println(done);
		pw.flush();
		pw.close();
		sc.close();
		
	}
	
}
