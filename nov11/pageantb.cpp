// November 2011 USACO Bronze Contest
// Problem 4: Cow Beauty Pageant

#include <fstream>
#include <cmath>

using namespace std;

char grid[50][50];
int N, M;

void floodfill(int x, int y, int fill_num){
  if(grid[x][y] != 'X')
    return;
  grid[x][y] = fill_num + 49;
  //cout << grid[x][y] << endl;
  bool expand = true;
  while(expand != false){
  expand = false;
  for(int i = 0; i < N; i++){
    for(int j = 0; j < M; j++){
      if(grid[i][j] == 'X'){
        if ((i > 0 && grid[i-1][j] == fill_num + 49) || 
        (i < N && grid[i+1][j] == fill_num + 49) ||
        (j > 0 && grid[i][j-1] == fill_num + 49) || 
        (j < M && grid[i][j+1] == fill_num + 49)){
          // cout << i << " " << j << endl;
          grid[i][j] = fill_num + 49;
          expand = true;
        }
      }
    }
  }
  }
}

int main(){
  
  ifstream cin("pageant.in");
  ofstream cout("pageant.out");
  
  // greedy algorithm will work, N, M are between 1, 50
  cin >> N >> M;
  for(int i = 0; i < N; i++){
    for(int j = 0; j < M; j++){
      cin >> grid[i][j];
    }
  }
  
  int fill_num = 0;
  
  for(int i = 0; i < N; i++){
    for(int j = 0; j < M; j++){
      // cout << grid[i][j] << endl;
      if(grid[i][j] == 'X'){
        floodfill(i,j,fill_num);
        fill_num++;
        // cout << fill_num << endl;
        
      }
      if(fill_num >= 2) break;
    }
  }
  
  
  int best = 99999999;
  
  for(int i = 0; i < N; i++){
    for(int j = 0; j < M; j++){
      for(int k = 0; k < N; k++){
        for(int m = 0; m < M; m++){
          if(grid[i][j] == '1' && grid[k][m] == '2'){
            best = min(best, abs(m-j) + abs(k-i)-1);
          }
        }
      }
    }
  }
  cout << best << endl;
}
