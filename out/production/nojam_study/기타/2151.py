"""
import sys

N = int(sys.stdin.readline())
house = [[0]*N for _ in range(N)]
dx_m = [1, 1, -1, -1]
dy_m = [1, -1, 1, -1]
dx_n = []
dy_n = []

start_x, start_y, end_x, end_y = -1, -1, -1, -1

for i in range(N):
    t = list(sys.stdin.readline())
    for j in range(N):
        house[i][j] = t[j]
        if t[j] == '#' and start_x == -1:
            start_x, start_y = i, j
        elif t[j] == '#' and start_x != -1:
            end_x, end_y = i, j


ans = float('inf')


def set_mirror(x, y, mirror_num, dir):
    global ans
    if mirror_num > ans:
        return

    if x == end_x and y == end_y:
        ans = min(ans, mirror_num)
        return

    if house[x][y] == "!":
        # 거울 놓을 수 있을 때
        for i in range(4):
            new_x = x+dx_m[i]
            new_y = y+dy_m[i]
            if 0 <= new_x < N and 0 <= new_y < N and house[new_x][new_y] != "*":
                t, house[x][y] = house[x][y], "%"
                set_mirror(new_x, new_y, mirror_num+1, i)
                house[x][y] = t

    elif house[x][y] == "%":
        for i in range(4):
            new_x = x+dx_m[i]
            new_y = y+dy_m[i]
            if 0 <= new_x < N and 0 <= new_y < N and house[new_x][new_y] != "*":
                house[x][y] = "*"  # 방문 표시
                set_mirror(new_x, new_y, mirror_num, i)
                house[x][y] = "%"  # 방문 다시 안 한걸로

    elif house[x][y] == ".":
        new_x = x+dx_n[dir]
        new_y = y+dy_n[dir]

        if 0 <= new_x < N and 0 <= new_y < N and house[new_x][new_y] != "*":
            house[x][y] = "*"  # 방문 표시
            set_mirror(new_x, new_y, mirror_num, i)
            house[x][y] = "."  # 방문 다시 안 한걸로

    elif house[x][y] == "#":
        for i in range(4):
            new_x = x+dx_n[i]
            new_y = y+dy_n[i]

            if 0 <= new_x < N and 0 <= new_y < N and house[new_x][new_y] != "*":
                house[x][y] = "*"  # 방문 표시
                set_mirror(new_x, new_y, mirror_num, i)
                house[x][y] = "#"  # 방문 다시 안 한걸로


set_mirror(start_x, start_y, 0, 0)
print(ans)
"""

from collections import deque
from sys import stdin
input = stdin.readline

# 상하좌우
dr = (-1, 1, 0, 0)
dc = (0, 0, -1, 1)
changeDir = ((2, 3), (2, 3), (0, 1), (0, 1))


def bfs():
    # 방문 체크 => 4인 이유는 4가지 방향 체크하려고
    check = [[[-1] * 4 for _ in range(N)] for _ in range(N)]
    for sr, sc, sd in Q:
        check[sr][sc][sd] = 0  # 이미 있는건 방문했다고 표시

    while Q:  # 큐가 빌 때까지
        r, c, d = Q.popleft()  # x, y, 방향
        nr = r + dr[d]  # 새로운 x 좌표
        nc = c + dc[d]  # 새로운 y 좌표

        # 격자 밖이거나 벽이면 => 갈 수 없다
        if not (0 <= nr < N and 0 <= nc < N) or A[nr][nc] == "*":
            continue

        # 빈 공간인 경우 => 빛이 통과할 수 있다
        if A[nr][nc] == ".":
            if check[nr][nc][d] == -1:      # 첫 방문
                check[nr][nc][d] = check[r][c][d]
                Q.append((nr, nc, d))
            else:     # 이미 방문했다면 갱신할 수 있는 경우에만
                if check[nr][nc][d] > check[r][c][d]:
                    check[nr][nc][d] = check[r][c][d]   # 최솟값 갱신 => 놓을 수 있는 거울
                    Q.append((nr, nc, d))

        # 거울 설치할 수 있는 경우 => 설치할 수도 있고 아닐 수도 있음
        elif A[nr][nc] == "!":
            # 거울 설치 X
            if check[nr][nc][d] == -1:      # 첫 방문
                check[nr][nc][d] = check[r][c][d]
                Q.append((nr, nc, d))
            else:     # 이미 방문했다면 갱신할 수 있는 경우에만
                if check[nr][nc][d] > check[r][c][d]:
                    check[nr][nc][d] = check[r][c][d]   # 최솟값 갱신
                    Q.append((nr, nc, d))

            # 거울 설치 O
            for nd in changeDir[d]:
                if check[nr][nc][nd] == -1:     # 첫 방문
                    check[nr][nc][nd] = check[r][c][d] + 1
                    Q.append((nr, nc, nd))
                else:     # 이미 방문했다면 갱신할 수 있는 경우에만
                    if check[nr][nc][nd] > check[r][c][d] + 1:      # 최솟값 갱신
                        check[nr][nc][nd] = check[r][c][d] + 1
                        Q.append((nr, nc, nd))

    temp = []   # 가능한 경우의 수
    for chk in check[gr][gc]:
        if chk == -1:
            continue
        temp.append(chk)
    return min(temp)


# main
N = int(input())
A = []
doors = []

# 입력 받는 부분
for i in range(N):
    A.append(list(input().strip()))
    for j in range(N):
        if A[i][j] == "#":
            doors.append([i, j])
            A[i][j] = "."

sr, sc = doors[0]   # 시작 좌표
gr, gc = doors[1]   # 도착 좌표

Q = deque()  # 갈 수 있는 좌표 모음 큐
for d in range(4):
    nr = sr + dr[d]
    nc = sc + dc[d]
    if not (0 <= nr < N and 0 <= nc < N) or A[nr][nc] == "*":
        continue
    Q.append((sr, sc, d))   # 시작 가능한 방향 모두 큐에 담기

print(bfs())
