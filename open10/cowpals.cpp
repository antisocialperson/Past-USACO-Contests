// 2010 US Open (Bronze)
// Cow Pals

#include <iostream>
#include <stdio.h>
using namespace std;

int sum(int cowid)
{
    int temp = 0;
    for(int i = 1; i*i <= cowid; i++)
    {
        if(cowid%i == 0)
        {
            temp += i;
            if(cowid / i != i)
                temp += (cowid/i);
        }
    }
    return temp-cowid;
} // further decreasing time bounds

int main()
{
    freopen("cowpals.in", "r", stdin);
    freopen("cowpals.out", "w", stdout);
    
    int cowid;
    cin >> cowid; // we only need to randomly loop because it can go up to 500 million cows
    // before declaring tle
    // and it is going to be way less (so we can include a method with for loops)
    
    // even if it doesn't work it will
    for(;;cowid++)
    {
        int pal = sum(cowid);
        if(cowid == pal)
            continue; // Cows that are superpals of themselves are shunned; do not consider them!
        if(cowid == sum(pal))
        {
            cout << cowid << " " << pal << endl;
            return 0;
        }
    }
}
