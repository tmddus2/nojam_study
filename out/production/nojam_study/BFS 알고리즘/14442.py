# 14502.py와 비교해서 보기

import sys
input = sys.stdin.readline
from collections import deque

def bfs(x,y):
    queue = deque()
    queue.append([x,y,0]) 
    visited = [[[0]*(K+1) for _ in range(M)] for _ in range(N)] # visited 배열
    # 3차원 배열인데 벽 몇번 부셨는지에 따라서 배열 높이 달라짐(행,열,높이 중 높이)
    # K+1이 벽을 0번 부셨을 때부터 K번 부셨을 때까지 맵
    visited[x][y][0] = 1 # 0,0은 방문했다
    while queue: # queue가 빌 때까지
        x,y,b_cnt = queue.popleft() # x 좌표, y 좌표, 이 좌표에 오기까지 벽 부신 수
        if x==N-1 and y==M-1: # 만약 끝까지 오면
            return visited[x][y][b_cnt] # 최단거리 출력
        for i in range(4): # 상하좌우 돌아가면서
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<M: # 범위 체크해주고
                if not visited[nx][ny][b_cnt]: # 만약 방문하지 않은 곳이라면
                    if maps[nx][ny] and b_cnt < K: # 방문할 수 없는 곳인데 벽을 k번보다 작게 부셨다면 벽 한번 부시기
                        visited[nx][ny][b_cnt+1] = visited[x][y][b_cnt]+1 
                        # nx,ny로 b_cnt만큼 벽 부시면서 간 횟수 = x,y로 b_cnt만큼 벽 부시면서 간 횟수 + 1
                        queue.append([nx,ny,b_cnt+1])
                    elif not maps[nx][ny]: # 방문할 수 있는 곳이면 그냥 가기
                        visited[nx][ny][b_cnt] = visited[x][y][b_cnt]+1 # 벽 안 부시고 간 횟수++
                        queue.append([nx,ny,b_cnt])

    return -1 # 이때까지 return이 안되면, 최단거리가 없는거므로 -1 return

N, M, K = map(int, input().split())
maps = [list(map(int, list(input().rstrip()))) for _ in range(N)] # map 입력 받기

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
print(bfs(0,0)) # 0, 0 에서 시작

"""
from collections import deque
n, m, k = map(int, input().split())

space = []
dx = [1,-1,0,0]
dy = [0,0,1,-1]
for i in range(n):
    t = input()
    s = []
    for j in range(m):
        s.append(int(t[j]))
    space.append(s)

global ans

def bfs(space):
    queue = deque([[0,0]])
    cnt = 0
    while queue:
        point = queue.popleft()
        if point[0] == n-1 and point[1] == m-1:
            return cnt
        
        for i in range(4):
            newX = point[0] + dx[i]
            newY = point[1] + dy[i]
            
            if newX>=0 and newX<n and newY>=0 and newY<m:
                if space[newX][newY] == 0:
                    cnt += 1
                    space[newX][newY] = 1
                    queue.append([newX, newY])

    if cnt == 0:
        return -1
    else:
        return cnt


def wall(cnt):
    global ans
    ans = m*n
    if cnt == 3:
        #print(bfs(space))
        ans = min(ans, bfs(space))
        return
    
    else:
        for i in range(n):
            for j in range(m):
                space[i][j] = 1
                wall(cnt+1)
                space[i][j] = 0

wall(0)

if ans == m*n:
    print(-1)
else:
    print(ans)
"""