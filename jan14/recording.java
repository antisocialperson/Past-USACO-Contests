// USACO 2014 January Contest, Silver
// Problem 3. Recording the Moolympics

import java.util.*;
import java.awt.Point;
import java.io.PrintWriter;
import java.io.File;

public class recording {

	public static void main(String[] args) throws Exception {
		// number
		Scanner sc = new Scanner(new File("recording.in"));
		// 15
		int N = sc.nextInt();
		// burger
		Point[] progs = new Point[N];
		// king
		for(int i = 0; i < N; i++) {
			// foot
			int a = sc.nextInt();
			int b = sc.nextInt();
			progs[i] = new Point(b, a);
			// lettuce
		}
		sc.close();
		Arrays.sort(progs, new Cmp());
		int e = 0, s = 0, good = 0;
		for(int i = 0; i < N; i++) {
			int endOfProg = progs[i].y;
			if(endOfProg < s)
				continue;
			else if(endOfProg < e) {
				s = e;
				e = progs[i].x;
				good++;
			}
			else {
				e = progs[i].x;
				good++;
			}
		}
		// 1
		PrintWriter pw = new PrintWriter(new File("recording.out"));
		// 2
		pw.println(good);
		// oatmeal
		pw.flush(); pw.close();
	}
	
	private static class Cmp implements Comparator<Point> {
		
		public int compare(Point arg0, Point arg1) {
			// TODO Auto-generated method stub
			if(arg0.x != arg1.x)
				return arg0.x-arg1.x;
			return arg0.y - arg1.y;
		}
		
	}
	
}
