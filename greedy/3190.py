from collections import deque

N = int(input())
K = int(input())
board = [[0]*N for _ in range(N)]

for _ in range(K):
    x, y = map(int, input().split())
    board[x-1][y-1] = 'a'  # 사과

L = int(input())

turn = deque()
queue = deque()

for _ in range(L):
    X, C = input().split()
    turn.append([int(X), C])

count = 0

queue.append([0, 0, 0, 0, 0, 1])
board[0][0] = 1  # 첫번째 뱀

while queue:
    head_x, head_y, tail_x, tail_y, dir_x, dir_y = queue.popleft()
    old_x = head_x
    old_y = head_y

    if turn and turn[0][0] == count:
        _, dir = turn.popleft()
        if dir == "D":
            if dir_x == 0 and dir_y == 1:
                dir_x, dir_y = 1, 0
            elif dir_x == 0 and dir_y == -1:
                dir_x, dir_y = -1, 0
            elif dir_x == 1 and dir_y == 0:
                dir_x, dir_y = 0, -1
            elif dir_x == -1 and dir_y == 0:
                dir_x, dir_y = 0, 1
            head_x = head_x+dir_x
            head_y = head_y+dir_y

        if dir == "L":
            if dir_x == 0 and dir_y == 1:
                dir_x, dir_y = -1, 0
            elif dir_x == 0 and dir_y == -1:
                dir_x, dir_y = 1, 0
            elif dir_x == 1 and dir_y == 0:
                dir_x, dir_y = 0, 1
            elif dir_x == -1 and dir_y == 0:
                dir_x, dir_y = 0, -1
            head_x = head_x+dir_x
            head_y = head_y+dir_y

    else:
        head_x = head_x+dir_x
        head_y = head_y+dir_y

    if head_x < 0 or head_x >= N or head_y < 0 or head_y >= N:
        break

    if board[head_x][head_y] != 0 and board[head_x][head_y] != 'a':  # 뱀을 만났다.
        break

    if board[head_x][head_y] == 'a':  # 사과를 만났다
        board[head_x][head_y] = board[old_x][old_y] + 1

        count += 1
        queue.append([head_x, head_y, tail_x, tail_y, dir_x, dir_y])

    if board[head_x][head_y] == 0:
        board[head_x][head_y] = board[old_x][old_y] + 1
        c = board[tail_x][tail_y]
        board[tail_x][tail_y] = 0

        for i in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
            X = tail_x+i[0]
            Y = tail_y+i[1]
            if 0 <= X < N and 0 <= Y < N:
                if board[X][Y] != 0 and board[X][Y] != 'a' and board[X][Y] == c+1:
                    tail_x = X
                    tail_y = Y
                    break

        count += 1
        queue.append([head_x, head_y, tail_x, tail_y, dir_x, dir_y])

    # print(board)
    # print("==========")

print(count+1)
