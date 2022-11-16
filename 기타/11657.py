import sys

N, M = map(int, sys.stdin.readline().split())
arr = [[0]*(N+1) for _ in range(N+1)]

for _ in range(M):
    A, B, C = map(int, sys.stdin.readline().split())
    arr[A][B] = C  # A -> B : 비용은 C

INF = float('inf')
dist = [INF for _ in range(N+1)]
dist[1] = 0  # 1에서 시작

negative = False  # 무한히 오래 전으로 되돌릴 수 있다면

for i in range(1, N+1):  # 1번부터 차례로
    for j in range(1, N+1):
        if arr[i][j] != 0 and dist[i] != INF and dist[j] > dist[i]+arr[i][j]:  # 노선이 있음 and j로 가는 거리가 더 짧다면
            dist[j] = dist[i]+arr[i][j]  # 거리 업데이트
            if i == N:  # N번째 라운드에서도 업데이트 된다면
                negative = True  # True로


if negative:  # negative가 True면
    print(-1)
else:  # 아니면
    for i in range(2, N+1):
        if dist[i] == INF:  # 갈 수 없음
            print(-1)
        else:
            print(dist[i])
