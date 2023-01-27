import sys

N, M, K = map(int, sys.stdin.readline().split(" "))

numbers = []
for _ in range(N):
    numbers.append(int(sys.stdin.readline()))

for _ in range(M+K):
    a, b, c = map(int, sys.stdin.readline().split(" "))
    if a == 1:
        numbers[b-1] = c

    elif a == 2:
        n = 1
        for i in range(b-1, c):
            n *= numbers[i]
        print(n)
