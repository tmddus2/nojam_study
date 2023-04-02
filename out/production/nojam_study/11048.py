# 한참 BFS로만 풀었더니 이것도 처음에는 BFS로 풀었다
# 그랬더니 시간초과가 났다
# 구글링해보니 다이나믹프로그래밍 문제라고 한다. BFS로도 풀 수 있지만 시간초과가 난다고.
# 괜히 다이나믹프로그래밍에 있었던 문제가 아니다
# 아래 주석이 내 BFS 풀이
"""
from collections import deque
n, m = map(int, input().split())

dx = [1, 0, 1]
dy = [0, 1, 1]
space = []

for i in range(n):
    space.append(list(map(int, input().split())))

visited = [[0]*m for _ in range(n)]

def bfs():
    queue = deque([[0,0]])

    while queue:
        point = queue.popleft()

        for i in range(3):
            newX = point[0] + dx[i]
            newY = point[1] + dy[i]
        
            if newX>=0 and newX<n and newY>=0 and newY<m:
                if visited[newX][newY] == 0:
                    queue.append([newX, newY])
                    visited[newX][newY] = visited[point[0]][point[1]] + space[newX][newY]
                else:
                    visited[newX][newY] = max(visited[newX][newY],  visited[point[0]][point[1]] + space[newX][newY])

bfs()
print(visited[n-1][m-1]+space[0][0])
"""

n, m = map(int, input().split())
space = []
for i in range(n):
    space.append(list(map(int, input().split())))

dp = [[0] * (m + 1) for _ in range(n + 1)]
# 아이디어는 다음과 같다.
# x, y 좌표로 온다고 했을 때, x, y 입장에서 왼쪽, 위, 왼쪽 대각선 위 이렇게 세 가지 경우로 올 수 있다
# 이 3가지 경우 중에 제일 큰 경우를 선택하기
for i in range(1, n + 1):
    for j in range(1, m + 1):
        dp[i][j] = space[i - 1][j - 1] + max(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) 
        # 해당 좌표 사탕 수 + 세가지 경로 중에 사탕 가장 많이 얻은 쪽 사탕 수 더하기

print(dp[-1][-1])