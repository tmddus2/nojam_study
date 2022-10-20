import sys
import heapq

left = []
right = []

N = int(sys.stdin.readline())

for i in range(N):
    num = int(sys.stdin.readline())

    if len(left) == len(right):
        heapq.heappush(left, (-num, num))
    else:
        heapq.heappush(right, (num, num))

    if left and right and left[0][1] > right[0][1]:
        min = heapq.heappop(right)[0]
        max = heapq.heappop(left)[1]

        heapq.heappush(left, (-min, min))
        heapq.heappush(right, (max, max))

    print(left[0][1])
