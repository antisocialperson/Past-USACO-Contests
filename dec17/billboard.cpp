// 2017 December USACO Bronze
// Problem 1: Blocked Billboard

#include <fstream>

// we can loop through all possibilities in time 4,000,000, which is fast enough for
// the program to run; then check if it is also a coordinate of the truck through
// an if block, which adds no time.

using namespace std;

int main(){
  ifstream cin ("billboard.in");
  ofstream cout ("billboard.out");
  int x1[3], y1[3], x2[3], y2[3];
  for(int i = 0; i < 3; i++){
    cin >> x1[i] >> y1[i] >> x2[i] >> y2[i];
  }
  int total = 0; // total invisible area
  for(int i = x1[0]; i <= x2[0]; i++){
    for(int j = y1[0]; j <= y2[0]; j++){
      if(i > x1[0] && j > y1[0] && i > x1[2] && i <= x2[2] && j > y1[2] && j <= y2[2]) total++;
      // checks if it is in the boundaries of the truck
    }
  }
  for(int i = x1[1]; i <= x2[1]; i++){
    for(int j = y1[1]; j <= y2[1]; j++){
      if(i > x1[1] && j > y1[1] && i > x1[2] && i <= x2[2] && j > y1[2] && j <= y2[2]) total++;
      // checks if it is in the boundaries of the truck
    }
  }
  cout << (x2[0]-x1[0])*(y2[0]-y1[0])+(x2[1]-x1[1])*(y2[1]-y1[1])-total << endl;
}
