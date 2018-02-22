#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> pii;

multiset<int> ck; // needs to return iterator and remove
vector<pii> cw; // needs to remove

int main(){
  
  freopen("helpcross.in", "r", stdin);
  freopen("helpcross.out", "w", stdout);
  
  int N, C;
  cin >> C >> N;
  for(int i = 0; i < C; i++){
    int c;
    cin >> c;
    ck.insert(c); // have to remove
  }
  for(int i = 0; i < N; i++){
    int c1, c2;
    cin >> c1 >> c2;
    cw.push_back(make_pair(c2, c1)); // have to remove
  }
  sort(cw.begin(), cw.end()); // sort
  int relations = 0;
  for(int i = 0; i < N; i++){
    auto kyIt = ck.lower_bound(cw[i].second); // why do you want
    // to define a type to an iterator?
    // returns an iterator to the lowest time in range
    if(kyIt != ck.end() /*there is a lower bound*/ && *kyIt <= cw[i].first /*it fits*/){
      relations++;
      ck.erase(kyIt);
    }
  }
  cout << relations << endl; 
    
}
