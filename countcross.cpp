#include <fstream>
#include <set>

#define x first
#define y second

using namespace std;

typedef pair<int, int> pii;

int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

bool vis[100][100];

set<pii> roads[100][100];
int N, K, R;

void dfs(int x, int y){
  if(x < 0 || x >= N || y < 0 || y >= N || vis[x][y])
    return;
  vis[x][y] = true;
  for(int i = 0; i < 4; i++){
    int nx = x+dx[i];
    int ny = y+dy[i];
    if(roads[x][y].count(make_pair(nx, ny)) == 0){
      // cout << x << " " << y << endl;
      dfs(nx, ny);
    }
  }
}

void initArray(){
  for(int i = 0; i < 100; i++){
    for(int j = 0; j < 100; j++){
      vis[i][j] = false;
    }
  }
}

int main() {
  ifstream cin("countcross.in");
  ofstream cout("countcross.out");
  cin >> N >> K >> R;
  for(int i = 0; i < R; i++){
    int a1, a2, b1, b2;
    cin >> a1 >> a2 >> b1 >> b2;
    a1--;
    a2--;
    b1--;
    b2--;
    roads[a1][a2].insert(make_pair(b1, b2)); // blocked
    roads[b1][b2].insert(make_pair(a1, a2));
  }
  
  pii points[K];
  int blocked = 0;
  // cout << "start" << endl;
  for(int i = 0; i < K; i++){
    // dfs for each cow
    int x, y;
    cin >> x >> y;
    points[i] = (make_pair(x-1, y-1));
    initArray();
    dfs(x-1, y-1);
    // cout << "done" << endl;
    for(int j = 0; j < i; j++){
      // cout << vis[points[j].x][points[j].y] << endl;
      if(!vis[points[j].x][points[j].y])
        blocked++;
    }
  }
  cout << blocked << "\n";
}
