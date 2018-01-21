// USACO Bronze 2017 December Contest
// Problem 3: Milk Measurement

#include <fstream>
#include <string>
#include <algorithm>

using namespace std;
typedef pair<int, pair<string, int> > pisi;

int score[3]; // score for each cow
int N;
int cnt = 0;

int main(){
  ifstream cin ("measurement.in");
  ofstream cout ("measurement.out");
	for(int i = 0; i < 3; i++){
		score[i] = 7;
	}	
	cin >> N;
	pisi times[N];
	for(int i = 0; i < N; i++){
		char sign;
		cin >> times[i].first >> times[i].second.first >> sign >> times[i].second.second;
		if(sign == '-')
			times[i].second.second = -(times[i].second.second);
	}	
	sort(times, times+N);
	int pmax = 120;
	for(int i = 0; i < N; i++){
	  if(times[i].second.first == "Bessie") score[0] += times[i].second.second;
	  if(times[i].second.first == "Elsie") score[1] += times[i].second.second;
	  if(times[i].second.first == "Mildred") score[2] += times[i].second.second;
	  // check which one
	  // embedded within this faulty code is the worst mistake I have ever made: I got 20/25
	  // on the AMC 8.
	  // check for the maximum value to see if it has changed
	  int temp = pmax;
	  if(score[0] > score[1] && score[0] > score[2])
	    pmax = 0;
	  else if(score[1] > score[0] && score[1] > score[2])
	    pmax = 1;
	  else if(score[2] > score[0] && score[2] > score[1])
	    pmax = 2;
	  else if(score[0] == score[1] && score[0] > score[2])
	    pmax = 10;
	  else if(score[0] == score[2] && score[0] > score[1])
	    pmax = 20;
	  else if(score[1] == score[2] && score[1] > score[0])
	    pmax = 12;
	  else if(score[0] == score[1] && score[1] == score[2])
	    pmax = 120;
	    
	  if(pmax != temp) cnt++;
	}
	cout << cnt << endl;

}
