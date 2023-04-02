import sys

"""
N = int(sys.stdin.readline())
arr = []

for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split(" "))))
"""

inf = float('inf')
dp = [[inf]*(1 << 5) for _ in range(5)]
print([inf]*(1 << 5))
print([2]*(1 << 5))
