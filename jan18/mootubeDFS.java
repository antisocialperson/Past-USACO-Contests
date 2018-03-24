import java.io.*;
import java.util.*;

public class mootubeDFS {

	private static ArrayList<Link>[] links;
	private static int X = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("mootube.in"))));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		links = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			links[i] = new ArrayList<Link>();
		}
		
		for(int i = 1; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken());
			
			links[a].add(new Link(b, x));
			links[b].add(new Link(a, x));
			
		}
		
		PrintWriter pw = new PrintWriter(new File("mootube.out"));
		
		for(int i = 0; i < q; i++) {
			
			boolean[] vis = new boolean[n];
			X = 0;
			
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken())-1;
			
			dfs(vis, v, k);
			
			pw.println(X);
			
		}
		
		br.close();
		pw.flush();
		pw.close();
		
	}
	
	private static void dfs(boolean[] vis, int v, int k) {
		
		// System.out.println(Arrays.toString(vis) + " " + v + " " + k);
		
		vis[v] = true;
		
		for(int i = 0; i < links[v].size(); i++) {
			// System.out.println("rel= " + links[v].get(i).k + " v= " + links[v].get(i).v + " v2 = " + v + " vis = " + vis[links[v].get(i).v]);
			if((!vis[links[v].get(i).v]) && links[v].get(i).k >= k) {
				// System.out.println("is good");
				dfs(vis, links[v].get(i).v, k);
				X++;
			}
			// System.out.println("done");
		}
		
	}
	
	private static class Link {
		
		int v, k;
		public Link(int v, int k) {
			this.v = v;
			this.k = k;
		}
		
	}
	
}
