// USACO Silver February 2017 Contest
// Problem 2: Why Did the Cow Cross the Road II

#include <fstream>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
  
  ifstream fin("maxcross.in");
  ofstream fout("maxcross.out");
  
  int N, K, B;
  fin >> N >> K >> B;
  int br[B]; // broken indices
  for(int i = 0; i < B; i++){
    fin >> br[i];
  }
  sort(br, br+B); // sorted broken indices into
  // increasing order
  int b = 0;
  while(b < B && br[b] <= K){
    b++;
  }
  int re = b;
  for(int i = 0; i < B; i++){
      if(br[i] + K > N)
        break;
      while(b<B && br[b] <= br[i]+K)
        b++;
      re = min(re, b-i-1);
  }
  fout << re << endl;
  
}
