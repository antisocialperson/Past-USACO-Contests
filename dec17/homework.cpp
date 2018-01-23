// USACO Silver December 2017 Contest
// Problem 1: My Cow Ate My Homework

#include <fstream> // Why did I even chicken on this...
#include <cmath>

using namespace std;

// 10000 * 100000 > 2^31 so we have to use long long
// Actually. If we use int it goes bad

long long score[100001];
long long notprefixsum[100001];
long long orange[100001]; // there was a problem where i used an array called blue[] in prefix sums
// this is a suffix sum so :)
/**
 * Anyways, the purpose of orange[] is to track down the minimum in each given set. 
 * We will subtract that from the end result to find the maximum.
**/

int main(){
  
  ifstream c("homework.in");
  ofstream d("homework.out");
  
  long long N;
  c >> N;
  for(long long i = 1; i <= N; i++){
    c >> score[i];
  }// 3 1 9 2 7
  notprefixsum[N] = score[N];
  orange[N] = score[N];
  for(long long i = N-1; i >= 1; i--){
    notprefixsum[i] = notprefixsum[i+1] + score[i];
    orange[i] = min(orange[i+1], score[i]); // how to be minimum of self lol
  }
  long long add1 = 0;
  long long add2 = 1;
  // d << "hi" << endl;
  for(long long i = 1; i <= N-2; i++){
    if((notprefixsum[i+1]-orange[i+1]) * add2 > add1 * (N-i-1)){
      // if sum down to i+1 - the minimum * denominator > numerator * (countdown from index)
      add1 = notprefixsum[i+1]-orange[i+1];
      add2 = N-i-1; // Self Explanatory
    }
  }
  // d << "hi" << endl;
  for (long long i=1; i<=N-2; i++) 
    if ((notprefixsum[i+1]-orange[i+1]) * add2 == add1 * (N-i-1)) 
      d << i << endl;
  // d << "hi" << endl;
  
}
