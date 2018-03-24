// February Silver Contest of 2018 (Fail for me)
// Problem 1: Rest Stops

// cost me all but 1 test cases in contest:
// "int" IS 16-BIT --> USE "long long"
#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>

using namespace std;
typedef pair<long long, long long> pii;
#define x first
#define y second
int main()
{
    
    freopen("reststops.in", "r", stdin);
    freopen("reststops.out", "w", stdout);
    
    long long l, n, f, b; // length, number of stops, FJ's rate, Bessie's rate
    cin >> l >> n >> f >> b;
    pii stops[n]; // fi
    bool can_eat[n]; // can only eat if it is maximum
    for(long long i = 0; i < n; i++){
        cin >> stops[i].x >> stops[i].y;
    }
    long long max = 0;
    for(long long i = n-1; i > 0; i--){
        if(stops[i].y > max){
            max = stops[i].y;
            can_eat[i] = true;
        }
    }
    long long at = 0;
    long long tot = 0;
    for(long long i = 0; i < n; i++)if(can_eat[i]){
        // take the coordinate of the stop
            long long len = stops[i].x - at;
            // add to the total tastiness value
            tot += len * (f-b) * stops[i].y;
        }
    cout << tot << "\n";
    return 0;
}
