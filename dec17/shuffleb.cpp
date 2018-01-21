// USACO Bronze 2017 December Contest
// Problem 2: The Bovine Shuffle

#include <fstream>

using namespace std;

int main(){
  ifstream cin ("shuffle.in");
  ofstream boi ("shuffle.out");
  int N;
  cin >> N;
  int a[N], ids[N];
  for(int i = 0; i < N; i++){
    cin >> a[i];
  }
  for(int i = 0; i < N; i++){
    cin >> ids[i];
  }
  for(int i = 0; i < 3; i++){
    int copy[N]; // copy
    for(int j = 0; j < N; j++){
      copy[j] = ids[j];
    }
    for(int j = 0; j < N; j++){
      ids[j] = copy[a[j]-1];
    }
  }
  for(int i = 0; i < N; i++){
    boi << ids[i] << endl;
  }
}
