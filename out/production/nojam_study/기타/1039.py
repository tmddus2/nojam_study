import sys
from collections import deque
N, K = map(int, sys.stdin.readline().split())
M = len(str(N))

ans = -1


queue = deque([[str(N), 0]])
visited = set()


while queue:
    num, count = queue.pop()

    if count == K:
        ans = max(ans, int(num))
    else:
        arr = list(map(int, num))
        for i in range(M-1):
            for j in range(i+1, M):
                if i == 0 and arr[j] == 0:
                    continue

                arr[i], arr[j] = arr[j], arr[i]
                t = ""
                for k in range(len(arr)):
                    t += str(arr[k])
                arr[i], arr[j] = arr[j], arr[i]
                if t+str(count+1) not in visited:
                    queue.append([t, count+1])
                    visited.add(t+str(count + 1))


print(ans)
