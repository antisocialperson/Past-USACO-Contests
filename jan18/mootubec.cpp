// USACO Silver January 2018 Contest
// Problem 3: MooTube

#include <iostream>
#include <vector>
#include <queue>
#include <stdio.h>

using namespace std;

struct connection{

	int vid, k;

};

int main(){

	freopen("mootube.in", "r", stdin);
	freopen("mootube.out", "w", stdout);

	int N, Q;
	cin >> N >> Q;

	vector<connection> v[N]; // need to add connections

	for(int i = 0; i < N-1; i++){

		int x, y, r;
		cin >> x >> y >> r;
		connection c;
		c.vid = y-1;
		c.k = r;
		v[x-1].push_back(c);
		c.vid = x-1;
		v[y-1].push_back(c);

	}

	for(int i = 0; i < Q; i++){

		int ki, vi;
		cin >> ki >> vi;
		vi--;
		int num = 0;
		queue<int> q;
		q.push(vi);
		bool vis[N];
		for(int i = 0; i < N; i++){
			vis[i] = false;
		}
		vis[vi] = true;
		while(!q.empty()){
			int pos = q.front();
			q.pop();
			for(int j = 0; j < v[pos].size(); j++){
				if(!vis[v[pos][j].vid] && v[pos][j].k >= ki){
					vis[v[pos][j].vid] = true;
					q.push(v[pos][j].vid);
					num++;
				}
			}
		}
		cout << num << endl;

	}

}
