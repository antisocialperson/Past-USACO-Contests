// USACO 2017 Silver Contest
// Problem 3: Secret Cow Code

import java.util.*;
import java.io.*;

public class cowcode {

	public static void main(String[] args) throws Exception {
		
		/**
		 * 
		 * This appears to be a string processing problem.
		 * It would be too inefficient to simulate the duplication, but it acts in a trend
		 * 
		 * The last char of the first substring is equal to the first char of the last substring
		 * The rest of the first substring goes after the first char and the index shifts by 1
		 * 
		 * **/
		
		Scanner sc = new Scanner(new FileInputStream(new File("cowcode.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("cowcode.out"))));
		String str = sc.next();
		long ind = sc.nextLong();
		sc.close();
		pw.println(get(str, ind-1));
		pw.flush();
		pw.close();
		
	}
	
	public static char get(String str, long ind) {
		if(ind < str.length()) {
			return str.charAt((int)ind);
		}
		long l = str.length();
		while(2*l <= ind) {
			l *= 2;
		}
		if(l == ind) {
			return get(str, l-1);
		}
		return get(str, ind-l-1);
	}
	
}
