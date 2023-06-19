from collections import deque
N = int(input())
r1, c1, r2, c2 = map(int, input().split())
dx = [-2,-2,0,0,2,2]
dy = [-1,1,-2,2,-1,1]

visited=[[0]*N for _ in range(N)]

queue = deque()
queue.append([r1, c1, 0])
visited[r1][c1]=1
ans = -1

while queue and ans==-1:
    temp=queue.popleft()
    x=temp[0]
    y=temp[1]
    moveN=temp[2]

    for i in range(6):
        newX = x+dx[i]
        newY = y+dy[i]
        if 0<=newX<N and 0<=newY<N and visited[newX][newY]==0:
            if newX==r2 and newY==c2:
                ans=moveN+1
                break
            
            queue.append([newX, newY, moveN+1])
            visited[newX][newY]=1

print(ans)

# 문제 풀면서 어려웠던 거
# 처음에 visited 배열 안 만들었더니 무한루프 돈다 => 2번 case(-1 나오는 경우)
# 어차피 최소 횟수 구하는 거니까 한번 방문한 곳은 또 방문할 필요 없음.
# while queue: 만 조건으로 하면 최소인 경우가 아니라 최대인 경우가 나옴.
# if 문에 걸려서 ans 업데이트 해도 또 다시 r2, c2 방문하면 최소값 아닌걸로 업데이트 됨.
