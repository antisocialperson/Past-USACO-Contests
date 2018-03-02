import java.util.*;
import java.io.*;

public class snowboots {

	private static int n, b;
	private static int boots = Integer.MAX_VALUE; // number of boots expended
	private static int depths[], s[], d[]; // depths is how deep it goes
	private static boolean vis[][];
	
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File("snowboots.in"));
		n = in.nextInt();
		b = in.nextInt();
		depths = new int[n];
		for(int i = 0; i < n; i++) {
			depths[i] = in.nextInt();
		}
		s = new int[b];
		d = new int[b];
		for(int i = 0; i < b; i++) {
			s[i] = in.nextInt();
			d[i] = in.nextInt();
		}
		in.close();
		vis = new boolean[n][b];
		dfs(0, 0);
		
		PrintWriter out = new PrintWriter(new File("snowboots.out"));
		out.println(boots);
		out.flush();
		out.close();

	}
	
	private static void dfs(int currPos, int boot) {
		// currPos - position
		// boot - boot index
		// check if in bounds
		if(vis[currPos][boot])
			return;
		vis[currPos][boot] = true;
		// if we are at the end then update and complete
		if(currPos == n-1) {
			boots = Math.min(boots, boot);
			return;
		}
		for(int i = currPos + 1; i < n && i - currPos <= + d[boot]; i++) {
			if(s[boot] >= depths[i])
				dfs(i, boot);
		}
		for(int i = boot; i < b; i++) {
			if(s[i] >= depths[currPos]) {
				dfs(currPos, i);
			}
		}
	}

}
