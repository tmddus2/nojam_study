t = input()


def pri(visited, num, ind):
    if num >= 6:
        for i in range(len(visited)):
            if visited[i] == 1:
                print(li[i], end=" ")
        print()
        return

    for i in range(ind, len(visited)):
        if visited[i] == 0:
            visited[i] = 1
            pri(visited, num+1, i+1)
            visited[i] = 0


while t != "0":
    li = list(map(int, t.split()))
    k = li[0]
    li = li[1:]
    visited = [0]*k

    pri(visited, 0, 0)
    t = input()
    if t != "0":
        print()
