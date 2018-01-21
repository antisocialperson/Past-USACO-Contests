// USACO Gold 2015 December Contest
// Problem 2: Fruit Feast
#include <fstream>
#include <cmath>

using namespace std;

int main(){

	ifstream cin("feast.in"); // when you are too lazy to redefine as fin/fout you just change from iostream
	ofstream cout("feast.out"); // to fstream 

	int t, orange, lemon;
	cin >> t >> orange >> lemon;
	// knapsack question BUT there is the water twist
	// we cannot use a knapsack algorithm unless we tweak
	bool m[2][t+1]; // 0 for can drink, 1 for can't drink
	for(int i = 0; i < 2; i++){
	  for(int j = 0; j < t+1; j++){
	    m[i][j] = false; // set all to false, uninitialized
	  }
	}
	m[0][0] = true; // doing nothing will lead to a nothing and a nothing still works
	for(int i = 0; i < 2; i++){ // 0 or 1

		for(int j = 0; j < t+1; j++){ // sum up to t

			if(!m[i][j]) // if you can't get j satieties
				continue;
			if(j + orange <= t) // if you can add orange amount of satieties
				m[i][j+orange] = true;
			if(j + lemon <= t) // if you can add lemon amount of satieties
				m[i][j+lemon] = true;
			if(i == 0){ // if i is 0
				m[1][j/2] = true; // then m[1][half of satiety] = true
			}

		}

	}

	int dpisannoying = t; // keep at t
	while(!m[1][dpisannoying])
		dpisannoying--; // if you can't find one for current value go down one
	cout << dpisannoying << endl;

}
