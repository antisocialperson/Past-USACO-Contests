// problem 3: MooTube

import java.util.*;
import java.io.*;

public class Mootube {

	private static class Link {
		int v, r;
		public Link(int _v, int _r) {
			v = _v;
			r = _r;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new FileInputStream(new File("mootube.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("mootube.out"))));
		int n = in.nextInt();
		int q = in.nextInt();
		
		LinkedList<Link>[] list = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new LinkedList<Link>();
		}
		for(int i = 0; i < n-1; i++) {
			int v1 = in.nextInt()-1;
			int v2 = in.nextInt()-1;
			int r = in.nextInt();
			list[v1].add(new Link(v2, r));
			list[v2].add(new Link(v1, r));
		}
		for(int i = 0; i < q; i++) {
			int k = in.nextInt();
			int v = in.nextInt()-1;
			int x = 0;
			LinkedList<Integer> qu = new LinkedList<Integer>();
			qu.add(v);
			boolean[] vis = new boolean[n];
			vis[v] = true;
			while(!qu.isEmpty()) {
				int a = qu.removeFirst();
				for(Link l : list[a]) {
					if(!vis[l.v] && l.r >= k) {
						vis[l.v] = true;
						qu.add(l.v);
						x++;
					}	
				}
			}
			pw.println(x);
		}
		pw.flush();
		pw.close();
		in.close();
		
	}
	
}
