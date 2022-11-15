import sys
import heapq
INF = float('inf')


def dijkstra(n, s, graph):  # n: 교차로 개수, s: 시작점, graph: 연결되어 있는 교차로 정보
    d = [INF*(n+1)]  # 가중치들 무한대로 초기화
    d[s] = 0  # 출발지 s는 0으로 => 0 + 다른 가중치

    hq = []
    heapq.heappush(hq, [0, s])  # 가중치, 교차로 저장

    while hq:
        tmp = heapq.heappop(hq)
        cost = tmp[0]  # 지금까지 비용
        node = tmp[1]  # 지금 교차로 => 여기서 다음 교차로로 갈 수 있는지 계산함.

        if cost > d[node]:  # 만약 비용이 더 든다 => 안 바꾸고 다음 경우 계산
            continue

        for v in graph[node]:  # node에서 v로 가는 경우 계산
            neighbor = v[0]  # 이웃 교차로
            n_cost = d[node]+v[1]  # 이웃 교차로로 가는데 드는 비용

            if n_cost < d[neighbor]:  # neighnor까지 가는 비용이 더 적으면
                d[neighbor] = n_cost  # 업데이트
                heapq.heappush(hq, [n_cost, neighbor])

    return d  # 각 교차로까지 가는데 드는 최소 비용


T = int(input())
for _ in range(T):
    n, m, t = map(int, input().split())  # n: 교차로 개수, m: 도로 개수, t: 목적지 개수
    s, g, h = map(int, input().split())  # s: 출발지, g, h: 지나간 교차로

    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        a, b, d = map(int, input().split())

        # h와 g는 꼭 지나가야 하는 곳 => 0.1만큼 빼서 소수 만들어 놓기. 지나갔는지 체크할 때 편하도록
        if (a == g and b == h) or (a == h and b == g):
            d -= 0.1

        graph[a].append([b, d])  # a와 b를 지날 때, 가중치는 d
        graph[b].append([a, d])  # a와 b를 지날 때, 가중치는 d

    targets = []  # 체크해야 할 목적지
    for _ in range(t):
        targets.append(int(input()))
    targets.sort()  # 나중에 출력 오름차순으로 해야하니까 미리 정렬해놓기

    ans_d = dijkstra(n, s, graph)

    for target in targets:
        # 만약 INF가 아니고 => 갈 수 없는 곳 아니고, 만약 실수라면 => h와 g가 포함되어 있다는 뜻
        if ans_d[target] != INF and type(ans_d[target]) == float:
            print(target, end=' ')
    print()
