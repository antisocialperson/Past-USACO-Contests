// 2017 USACO Silver December Contest
// Problem 3: The Bovine Shuffle

#include <fstream>
#include <queue>

using namespace std;

int main(){
	ifstream fin("shuffle.in");
	ofstream fout("shuffle.out");
	int N;
	fin >> N;
	int locs[N];
	int to[N];
	for(int i = 0; i < N; i++)
		locs[i] = 0; // needs to be initialized
	for(int i = 0; i < N; i++){
		fin >> to[i];
		--to[i];
		locs[to[i]]++;
	}
	int blocks = N;
	queue<int> emp; // all spots that will become empty
	for(int i = 0; i < N; i++){
		if(locs[i] == 0){
			blocks--;
			emp.push(i);
		}	
	}
	while(!emp.empty()){
		int i = emp.front();
		if(--locs[to[i]] == 0){
			blocks--;
			emp.pop();
			emp.push(to[i]);
		}
		else
			emp.pop();
	}
	fout << blocks << endl;
}
