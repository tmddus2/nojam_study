from collections import deque # deque 쓰는 법은 외워두기 => queue 쓸 때! BFS 쓸 때 많이 쓴다

N, M = map(int, input().split()) # 그냥 입력

cnt_move_num=[-1]*101 # 100칸의 게임판을 만든 것. visited의 역할도 같이 해주고자 -1로 초기화
# 그 칸에 오기까지 몇 번의 주사위를 던졌는지. 값이 2라면 그 칸에 오기까지 2번 주사위를 던짐

ladder = dict() # a칸에서 b칸으로 이동. 딕셔너리 개념 쓰자. snake도 마찬가지
snake  = dict()

# 입력
for _ in range(N):
    i,j = map(int, input().split())
    ladder[i]=j

for _ in range(M):
    i,j = map(int, input().split())
    snake[i]=j

def bfs():
    cnt_move_num[1]=0 # 첫 시작점
    queue = deque([1]) # 큐에 넣기

    while queue: # 큐에 있는 게 다 빌 때까지! BFS는 대부분 while queue: 
        now = queue.popleft() 
        for i in range(1,7): # 6개 주사위 경우 다 돌린다
            next=now+i # 주사위 던져서 이동할 수 있는 위치
            if 0<next<=100 and cnt_move_num[next]==-1: # 우선 범위 내에 있는지, 한 번도 안 가본 곳인지
                if next in ladder.keys(): # 사다리면 이동
                    next=ladder[next]
                if next in snake.keys(): # 뱀이면 이동 
                    next=snake[next]
                if cnt_move_num[next]==-1: # 간 적 없는 곳이면
                    queue.append(next) # 큐에 넣고
                    cnt_move_num[next]=cnt_move_num[now]+1 # now -> next로 이동한 것. 그니까 now에 오기까지 주사위 던진 횟수+1

bfs()
print(cnt_move_num[100])

# 문제 풀면서 어려웠던 거
# visited 배열 따로 만들어야 하는거 아닌가? 왜냐면 주사위 던지면 6가지 경우로 흩어지는데 
# 예를 들어 이미 방문한 곳을 다음에 다른 경우의 수에서 방문할 수 있는데?
# 근데 생각해보니 이건 주사위를 던지는 최소의 경우를 구하는 것
# 어차피 50번째 칸에 오는데 1,27,50을 거쳐서 오나 1, 30, 50을 거쳐서 오나 1, 50으로 바로 오나 똑같음
# 그 칸에 도착하기까지 던진 주사위 수가 최소이기만 하면 됨. 그니까 이미 방문했다? 주사위를 최소로 던져서 이미 거기 온 것