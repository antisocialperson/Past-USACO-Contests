// January 2017 Silver Contest
// 3. Secret Cow Code

#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;

char get(string s, long long i){
    
    if(i < s.length()){
        return s.at((int)i);
    } // if i is in the string
    long long l = s.length();
    while(2 * l <= i) // while twice the length is less than the index
        l *= 2; // this brings it to said length
    if (l == i) // if length is equal to index
        return get(s, l-1);
    else return get(s, i-l-1);
    
}

int main(){
    
    freopen("cowcode.in", "r", stdin);
    freopen("cowcode.out", "w", stdout);
    
    string s;
    cin >> s;
    long long i;
    cin >> i;
    cout << get(s, i-1) << endl;
    
}
