// 2017 US Open Silver Contest
// Problem 1: Paired Up

#include <stdio.h>
#include <algorithm>

using namespace std;

int N;
pair<int, int> arr[100000];

int main() {

  freopen("pairup.in", "r", stdin);
  freopen("pairup.out", "w", stdout);

  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%d %d", &arr[i].second, &arr[i].first);
  }
  sort(arr, arr+N);
  int M = 0, i = 0, j = N-1;
  while (i <= j) {
    int x = min(arr[i].second, arr[j].second);
    if(i == j) x /= 2;
    M = max(M, arr[i].first + arr[j].first);
    arr[i].second -= x;
    arr[j].second -= x;
    if(arr[i].second == 0) i++;
    if(arr[j].second == 0) j--;
  }

  printf("%d\n", M);

}

