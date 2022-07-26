from collections import deque
N, M = map(int, input().split())

space = []
house = []
store = []

for i in range(N):
    space.append(list(map(int, input().split())))

for i in range(N):
    for j in range(N):
        if space[i][j] == 1:
            house.append([i, j])
        elif space[i][j] == 2:
            store.append([i, j])

check = [0]*len(store)


def select_store(c, index):
    if sum(c) == M:
        check_chicken_distance(c)
        # print(c)
        return

    if index >= len(check):
        return

    else:
        c[index] = 1
        select_store(c, index+1)
        c[index] = 0
        select_store(c, index+1)


global chicken_distance
chicken_distance = N*N*N


def check_chicken_distance(space):
    global chicken_distance
    sum_distance = 0
    # print(space)
    for i in range(len(house)):
        min_distance = N*N*N
        for j in range(len(store)):
            if space[j] == 1:
                min_distance = min(min_distance, abs(
                    house[i][0]-store[j][0])+abs(house[i][1]-store[j][1]))
        sum_distance += min_distance
    chicken_distance = min(chicken_distance, sum_distance)


select_store(check, 0)

print(chicken_distance)
