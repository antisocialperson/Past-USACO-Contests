// 2013 Bronze US OPEN
// Problem 3: Photo

#include <iostream>
#include <algorithm>
#include <cstdio>

using namespace std;

typedef pair<int, int> pii;

int main(){
    
    freopen("photo.in", "r", stdin);
    freopen("photo.out", "w", stdout);
    
    int N, K;
    cin >> N >> K;
    pii prk[K];
    for(int i = 0; i < K; i++){
        cin >> prk[i].first >> prk[i].second;
        if(prk[i].first < prk[i].second){
        	int t = prk[i].first; // what the usaco grader always looks like
        	prk[i].first = prk[i].second;
        	prk[i].second = t;
        }
    }
    sort(prk, prk+K); // sort in terms of larger index (may already be, as sample case shows)
    int last = 0; // the last one that we did not do
    int cnt = 1; // we add one more at the end
    for(int i = 0; i < K; i++){
        if(prk[i].second >= last){
            cnt++; // add one if big enough
            last=prk[i].first;
        }
    }
    cout << cnt << endl;
}
