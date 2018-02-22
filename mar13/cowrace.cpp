/*input
4 3
1 2
4 1
1 1
2 10
2 3
1 2
3 9
*/

#include <iostream>
#include <stdio.h>

using namespace std;

#define T 1001000

// MAXIMUM RUNTIME IS 1,000,000 which is very much in time constraints

int main(){

  freopen("cowrace.in", "r", stdin);
  freopen("cowrace.out", "w", stdout);

  int N, M;
  cin >> N >> M;
  int b[T];
  int e[T];

  for(int i = 0; i < T; i++){
    b[i] = 0;
    e[i] = 0;
  }
  
  int ri = 0;
  for(int i = 0; i < N; i++){
    int s, t;
    cin >> s >> t;
    for(int j = 0; j < t; j++){
      b[ri] = s;
      ++ri;
    }
  }
  ri=0;
  for(int j = 0; j < M; j++){
    int s, t;
    cin >> s >> t;
    for(int i = 0; i < t; i++){
      e[ri] = s;
      ++ri;
    }
  }
  int c = 0;
  int l = 0; // 1 if bessie, -1 if elsie
  
  int bl = 0;
  int el = 0;
  for(int i = 0; i < T; ++i){
    bl += b[i];
    el += e[i];
    if(bl > el){
      if(l == -1){
        // cout << i << endl;
        ++c;
      }
      l = 1;
    }
    else if(el > bl){
      if(l == 1){
        // cout << i << endl;
        ++c;
        }
      l = -1;
    }
  }
  cout << c << endl;
}
