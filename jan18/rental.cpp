// USACO January 2018 Silver Contest
// Problem 2: Rental Service

// in C++
// SUPPORT T PUNCIL A VERY GOOD CLOUDSOUND RAPPER AT THE WEBSITE www.tpuncil.tk

// AND MAKE YOUR OWN FREE DOMAIN AT www.dot.tk

#include <iostream>
#include <cmath>
#include <algorithm>
#include <cstdio>

using namespace std;

typedef pair<int, int> pii;

bool comp(int a, int b)
{
	return b < a;
}
bool comp2(pii a, pii b)
{
	return (b.first < a.first);
}

int main()
{

	freopen("rental.in", "r", stdin);
	freopen("rental.out", "w", stdout);

	int N, M, R;
	cin >> N >> M >> R;
	int pr[N]; // milk product of each cow
	for(int i = 0; i < N; i++)
	{
		cin >> pr[i];
	}
	// sort in DECREASING ORDER because that is the order in which we want to deal with them
	sort(pr, pr+N, comp);

	pii vn[M]; // vendors, with profit per gallon first and number of gallons in store second
	for(int i = 0; i < M; i++)
	{
		cin >> vn[i].second >> vn[i].first;
	}
	// sort in DECREASING ORDER the vendors
	sort(vn, vn+M, comp2);

	int ind = 0; // index of vendor
	long long max_profit[N+1]; // maximum profit
	for(int i = 0; i < N; i++)
	{
		max_profit[i] = 0;
	}
	for(int i = 0; i < N; i++)
	{
		max_profit[i+1] = max_profit[i]; // keep adding running total
		while(ind < M && pr[i] > 0)
		{
			int ddc = min(pr[i], vn[ind].second); // deduction
			max_profit[i+1] += ddc*(vn[ind].first); 
			pr[i] -= ddc; // self explanatory
			vn[ind].second -= ddc;
			if(vn[ind].second == 0)
				ind++; // if there is no milk left in store x go to store y
		}
	}

	int rn[R]; // rentals
	for(int i = 0; i < R; i++)
	{
		cin >> rn[i];
	}
	// again sort in DECREASING ORDER for same reason
	sort(rn, rn+R, comp);

	ind = N-1; // from LOWEST output
	int indr = 0; // index of rn[]
	long long profit = 0; // profit so far
	while(indr < R && ind >= 0)
	{
		profit += rn[indr]; // add the current rental
		max_profit[ind] += profit; // add the total profit so far to the max at that time
		indr++;
		ind--;
	}

	long long mx = -633; // to use github.com or usaco.org or tpuncil.tk, pay $6.33
	for(int i = 0; i < N+1; i++)
	{
		mx = max(mx, max_profit[i]);
	}

	cout << mx << endl;

}
