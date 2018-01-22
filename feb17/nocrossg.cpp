// USACO Gold February 2017 Contest
// Problem 2: Why Did the Cow Cross the Road II

#include <fstream>
#include <cmath>

using namespace std;

int dp[1000][1000];
int map1[1000], map2[1000];

int main() {

	ifstream cin("nocross.in");
	ofstream cout("nocross.out");

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> map1[i];
	}
	for (int i = 0; i < N; i++) {
		cin >> map2[i];
	}
	dp[0][0] = abs(map1[0] - map2[0]) <= 4;
	for (int i = 1; i < N; i++) {
		dp[i][0] = max(dp[i - 1][0], (int) (abs(map1[i] - map2[0]) <= 4));
	}
	for (int i = 1; i < N; i++) {
		dp[0][i] = max(dp[0][i - 1], (int) (abs(map1[0] - map2[i]) <= 4));
	}
	for (int i = 1; i < N; i++) {
		for (int j = 1; j < N; j++) {
			dp[i][j] = max(max(dp[i - 1][j], dp[i][j - 1]),
					dp[i - 1][j - 1] + (int) (abs(map1[i] - map2[j]) <= 4));
		}
	} // the "river" problem

	cout << dp[N - 1][N - 1] << endl;
}
