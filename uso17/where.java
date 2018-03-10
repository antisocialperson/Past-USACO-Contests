import java.util.*;
import java.io.*;

public class where {

	private static int n;
	private static String[] map;
	private static boolean[][] vis;

	private static List<PCL> pcls;

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(new File("where.in"));
		n = in.nextInt();
		map = new String[n];
		for (int i = 0; i < n; i++) {
			map[i] = in.next();
		}
		in.close();
		pcls = new ArrayList<PCL>();
		vis = new boolean[n][n];
		for (int x1 = 0; x1 < n; x1++) {
			for (int y1 = 0; y1 < n; y1++) {
				for (int x2 = x1; x2 < n; x2++) {
					for (int y2 = y1; y2 < n; y2++) {
						if (works(x1, y1, x2, y2)) {
							pcls.add(new PCL(x1, x2, y1, y2));
						}
					}
				}
			}
		}

		int numOfPCL = 0; // number of PCLs
		for (int i = 0; i < pcls.size(); i++) {
			if (reallyWorks(i))
				numOfPCL++;
		}

		PrintWriter out = new PrintWriter(new File("where.out"));
		out.println(numOfPCL);
		out.flush();
		out.close();

	}

	private static boolean reallyWorks(int x) {

		for (int i = 0; i < pcls.size(); i++) {
			if (i != x && nested(x, i))
				return false;
		}
		return true;

	}

	private static boolean nested(int ind1, int ind2) {

		PCL a = pcls.get(ind1);
		PCL b = pcls.get(ind2);

		return a.x1 >= b.x1 && a.x2 <= b.x2 && a.y1 >= b.y1 && a.y2 <= b.y2;

	}

	private static boolean works(int x1, int y1, int x2, int y2) {

		int numOfColors = 0;
		int[] eachColor = new int[26];
		Arrays.fill(eachColor, 0);
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				vis[i][j] = false;
			}
		}
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (!vis[i][j]) {
					int col = map[i].charAt(j) - 'A';
					if (eachColor[col] == 0) {
						numOfColors++;
					}
					eachColor[col]++;
					flood(i, j, x1, y1, x2, y2, col);
				}
			}
		}

		// this CANNOT STAND!
		if (numOfColors != 2)
			return false;
		boolean oneReg = false, twoReg = false; // despite "twoReg" it is more than 2 regions
		for (int i = 0; i < 26; i++) {
			if (eachColor[i] == 1)
				oneReg = true;
			if (eachColor[i] > 1)
				twoReg = true;
		}

		return oneReg && twoReg; // exactly two colors must be present, one forming a contiguous region and
		// one forming two or more contiguous regions

	}

	private static void flood(int x, int y, int x1, int y1, int x2, int y2, int col) {

		vis[x][y] = true;
		if (x > x1 && map[x - 1].charAt(y) - 'A' == col && !vis[x - 1][y])
			flood(x - 1, y, x1, y1, x2, y2, col);
		if (x < x2 && map[x + 1].charAt(y) - 'A' == col && !vis[x + 1][y])
			flood(x + 1, y, x1, y1, x2, y2, col);
		if (y > y1 && map[x].charAt(y - 1) - 'A' == col && !vis[x][y - 1])
			flood(x, y - 1, x1, y1, x2, y2, col);
		if (y < y2 && map[x].charAt(y + 1) - 'A' == col && !vis[x][y + 1])
			flood(x, y + 1, x1, y1, x2, y2, col);

	}

	private static class PCL {

		// each PCL contains four values
		int x1, y1;
		int x2, y2;

		public PCL(int x1, int x2, int y1, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}

	}

}
