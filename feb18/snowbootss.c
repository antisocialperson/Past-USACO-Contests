#include <stdio.h>
#include <math.h>

#define MAXN 250
#define MAXB 250

int n, b;
int boots = MAXB + 1; // one more than highest n, b
int depths[MAXN], s[MAXB], d[MAXB];
int vis[MAXN][MAXB];
int i, j;

init_vis() {
    
    for(i = 0; i < MAXN; i++) {
        for(j = 0; j < MAXB; j++) {
            vis[i][j] = 0;
        }
    }
    
}

dfs(int tile, int boot) {
    
    if(vis[tile][boot]) return;
    vis[tile][boot] = 1;
    
    if(tile == n-1){
        boots = fmin(boots, boot);
    }
    
    for(i = tile + 1; i < n && i - tile <= d[boot]; i++){
        if(s[boot] >= depths[i]) dfs(i, boot);
    }
    
    for(i = boot; i < b; i++){
        if(s[i] >= depths[tile]) dfs(tile, i);
    }
    
}

main() {
    
    freopen("snowboots.in", "r", stdin);
    freopen("snowboots.out", "w", stdout);
    
    scanf("%d %d", &n, &b);
    for(i = 0; i < n; i++){
        scanf("%d", &depths[i]);
    }
    for(i = 0; i < b; i++){
        scanf("%d %d", &s[i], &d[i]);
    }
    
    dfs(0, 0);
    
    printf("%d\n", boots);
    
}
