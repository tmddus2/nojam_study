N = int(input())
mine = [list(input()) for _ in range(N)]
board = [list(input()) for _ in range(N)]

dx = [1, -1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]


def check(x, y):
    num = 0
    for i in range(8):
        new_x = x+dx[i]
        new_y = y+dy[i]
        if 0 <= new_x < N and 0 <= new_y < N:
            if mine[new_x][new_y] == '*':
                num += 1

    return num


def bomb():
    b = []
    for i in range(N):
        for j in range(N):
            if mine[i][j] == '*':
                b.append([i, j])

    return b


for i in range(N):
    for j in range(N):
        if board[i][j] == 'x' and mine[i][j] != '*':
            board[i][j] = check(i, j)
        elif board[i][j] == 'x' and mine[i][j] == '*':
            bombs = bomb()
            for b in bombs:
                new_x, new_y = b[0], b[1]
                board[new_x][new_y] = '*'


for i in range(N):
    line = ""
    for j in range(N):
        line += str(board[i][j])
    print(line)
