#include <iostream>
#include <algorithm>
#include <cmath>
#include <set>
#include <cstdio>

using namespace std;

typedef pair<int, int> pii;

int main() {

	freopen("lifeguards.in", "r", stdin);
	freopen("lifeguards.out", "w", stdout);

	int N;
	cin >> N;
	pii poi[2 * N]; // points of interest: time, cow ind.
	for (int i = 0; i < N; i++) {
		int start, end;
		cin >> start >> end;
		poi[2 * i] = make_pair(start, i);
		poi[2 * i + 1] = make_pair(end, i);
	}
	sort(poi, poi + 2 * N);
	int alone[N];
	set<int> workers; // (communism intensifies)
	int last = 0; // last point of interest
	int coverage = 0;
	for (pii t : poi) {
		// each time we're interested in
		if (workers.size() == 1) alone[*workers.begin()] = t.first - last;
		if (!workers.empty()) coverage += t.first - last;
		if (workers.count(t.second) == 1) workers.erase(t.second);
		else workers.insert(t.second);
		last = t.first;
	}

	// cout << coverage << endl;

	int best = -1;
	for (int i : alone) {
		best = max(best, coverage - i);
		// cout << i << endl;
	}
	cout << best << endl;

}
