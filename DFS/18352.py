from calendar import c


N, M, K, X = map(int, input().split())

space = [[] for _ in range(N)]
visited = [0 for _ in range(N)]


for i in range(M):
    start, end = map(int, input().split())
    space[start-1].append(end-1)


def dfs(city, distance):
    if visited[city] != 0:
        if city == 2:
            print("here1")
        visited[city] = min(visited[city], distance)
        return
    if visited[city] == 0:
        if city == 2:
            print("here2")
            print(distance)
        visited[city] = distance

    for i in range(len(space[city])):
        for j in space[i]:
            # print(j)
            if visited[j] == 0:
                dfs(j, distance+1)


print(space)
dfs(X-1, 0)
print(visited)
