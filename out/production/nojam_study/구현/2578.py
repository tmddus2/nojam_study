bingo = []
call = []

for _ in range(5):
    bingo.append(list(map(int, input().split())))

for _ in range(5):
    call.append(list(map(int, input().split())))

visited = []


def check_bingo():
    num = 0

    for i in range(5):
        for j in range(5):
            if j == 4 and bingo[i][j] in visited:
                num += 1
            elif bingo[i][j] not in visited:
                break

    for i in range(5):
        for j in range(5):
            if j == 4 and bingo[j][i] in visited:
                num += 1
            elif bingo[j][i] not in visited:
                break

    # 4,0 / 3,1 / 2,2 / 1,3 / 0,4

    for i in range(5):
        if bingo[i][4-i] not in visited:
            break
        if i == 4 and bingo[i][4-i] in visited:
            num += 1

    # 0,0 / 1,1

    for i in range(5):
        if bingo[i][i] not in visited:
            break
        if i == 4 and bingo[i][i] in visited:
            num += 1

    return num


ans = 0
for i in range(5):
    for j in range(5):
        visited.append(call[i][j])
        if check_bingo() >= 3:
            ans = i*5+j+1
            break
    if ans != 0:
        break

print(ans)
