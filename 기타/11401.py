import sys

N, K = map(int, sys.stdin.readline().split())

const = 1

for i in range(K):
    const = const*(N-i)
    const = const/(i+1)


print(const % 1000000007)
