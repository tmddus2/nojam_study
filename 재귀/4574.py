# alpha = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
#          "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]

# domino_check = [[0]*9 for _ in range(9)]


# def sudo_check(board, start_x, end_x, start_y, end_y):
#     part = board[start_x:end_x+1][start_y:end_y+1]
#     check_num = [[0]*9]
#     for i in range(9)


# while(1):
#     t = int(input())
#     if t == 0:
#         break
#     sudo = [[0]*9 for _ in range(9)]
#     for i in range(t):
#         domino = list(input().split())
#         sudo[alpha.index(domino[1][0])][int(domino[1][1])-1] = int(domino[0])
#         sudo[alpha.index(domino[3][0])][int(domino[3][1])-1] = int(domino[2])
#         domino_check[int(domino[0])][int(domino[2])] = 1
#         domino_check[int(domino[2])][int(domino[0])] = 1

#     p = list(input().split())
#     for i in range(len(p)):
#         sudo[alpha.index(p[i][0])][int(p[i][1])-1] = i+1
