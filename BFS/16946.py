from collections import deque
import queue

n, m = map(int, input().split())
space = []
dx = [1,-1,0,0]
dy = [0,0,1,-1]
for i in range(n):
    space.append(input())

ans = [[0]*m for _ in range(n)]
global cnt

def dfs(x,y):
    global cnt
    queue = deque()
    queue.append([x,y])
    visited = [[0]*m for _ in range(n)]
    visited[x][y] = 1 
    while queue:
        point = queue.popleft()
        for i in range(4):
            newX = point[0] + dx[i]
            newY = point[1] + dy[i]
            if newX>=0 and newX<n and newY>=0 and newY<m:
                if space[newX][newY] == '0' and visited[newX][newY] == 0:
                    cnt+=1
                    visited[newX][newY] = 1
                    queue.append([newX,newY])


for i in range(n):
    for j in range(m):
        if space[i][j] == '1':
            cnt = 0
            dfs(i,j)
            ans[i][j] = cnt+1

for i in range(n):
    for j in range(m):
        print(ans[i][j], end="")
    print()
