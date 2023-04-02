N = int(input())
student = {}

for _ in range(N*N):
    t = list(map(int, input().split()))
    student[t[0]] = t[1:]

classrooom = [[0]*N for _ in range(N)]


def condition1(num):
    result = []
    for i in range(N):
        for j in range(N):
            if classrooom[i][j] == 0:
                t = 0
                e = 0
                for k in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                    x = i+k[0]
                    y = j+k[1]
                    if 0 <= x < N and 0 <= y < N:
                        if classrooom[x][y] in student[num]:
                            t += 1
                        if classrooom[x][y] == 0:
                            e += 1
                result.append([i, j, t, e])
    return result.sort(key=lambda x: (x[2], x[3], -x[0], x[1]))


for i in student.keys():
    print(condition1(i))
