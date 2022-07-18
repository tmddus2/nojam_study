N, M = map(int, input().split())
space = [[0]*M for _ in range(N)]
c1_x = -1
c1_y = -1
c2_x = -1
c2_y = -1
for i in range(N):
    t = input()
    for j in range(M):
        if t[j] == "o" and c1_x == -1:
            c1_x = i
            c1_y = j
        elif t[j] == "o" and c1_x != -1:
            c2_x = i
            c2_y = j
        space[i][j] = t[j]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
global ans
ans = -1

visited_c1 = [[0]*M for _ in range(N)]
visited_c2 = [[0]*M for _ in range(N)]
visited_c1[c1_x][c1_y] = 1
visited_c2[c2_x][c2_y] = 1


def dfs(coin1_x, coin1_y, coin2_x, coin2_y, step):
    global ans
    for i in range(4):
        n_c1_x = coin1_x+dx[i]
        n_c1_y = coin1_y+dy[i]
        n_c2_x = coin2_x+dx[i]
        n_c2_y = coin2_y+dy[i]

        if (not(0 <= n_c1_x < N) or not(0 <= n_c1_y < M)) and 0 <= n_c2_x < N and 0 <= n_c2_y < M:
            if ans == -1:
                ans = 1
            else:
                ans = min(ans, step)
            return
        elif (not(0 <= n_c2_x < N) or not(0 <= n_c2_y < M)) and 0 <= n_c1_x < N and 0 <= n_c1_y < M:
            if ans == -1:
                ans = 1
            else:
                ans = min(ans, step)
            return

        elif (not(0 <= n_c1_x < N) or not(0 <= n_c1_y < M)) and (not(0 <= n_c2_x < N) or not(0 <= n_c2_y < M)):
            continue

        else:
            if space[n_c1_x][n_c1_y] != "#" and space[n_c2_x][n_c2_y] != "#" and visited_c1[n_c1_x][n_c1_y] == 0 and visited_c2[n_c2_x][n_c2_y] == 0:
                visited_c1[n_c1_x][n_c1_y] == 1
                visited_c2[n_c2_x][n_c2_y] == 1
                dfs(n_c1_x, n_c1_y, n_c2_x, n_c2_y, step+1)
                visited_c1[n_c1_x][n_c1_y] == 0
                visited_c2[n_c2_x][n_c2_y] == 0
            elif space[n_c1_x][n_c1_y] == "#" and space[n_c2_x][n_c2_y] != "#" and visited_c2[n_c2_x][n_c2_y] == 0:
                visited_c2[n_c2_x][n_c2_y] = 1
                dfs(coin1_x, coin1_y, n_c2_x, n_c2_y, step+1)
                visited_c2[n_c2_x][n_c2_y] = 0
            elif space[n_c1_x][n_c1_y] != "#" and space[n_c2_x][n_c2_y] == "#" and visited_c1[n_c1_x][n_c1_y] == 0:
                visited_c1[n_c1_x][n_c1_y] = 1
                dfs(n_c1_x, n_c1_y, coin2_x, coin2_y, step+1)
                visited_c1[n_c1_x][n_c1_y] = 0


dfs(c1_x, c1_y, c2_x, c2_y, 0)

print(ans)
