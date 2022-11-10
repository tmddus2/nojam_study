import sys
sys.setrecursionlimit(10**6)
N, B = map(int, sys.stdin.readline().split())

mat = []

for i in range(N):
    mat.append(list(map(int, sys.stdin.readline().split())))
result = mat


def mult(result, b):
    if b == 0:
        return result
    r = [[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            # result의 i 번째 줄, mat의 j 번쨰 줄(세로로)

            for k in range(N):
                r[i][j] = r[i][j] + result[i][k]*mat[k][j]
            r[i][j] = r[i][j] % 1000
    return mult(r, b-1)


# for i in range(B-1):
#    result = mult(result, mat)


print(mult(result, B-1))
