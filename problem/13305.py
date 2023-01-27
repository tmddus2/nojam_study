N = int(input())
length = list(map(int, input().split()))
cost = list(map(int, input().split()))

ans = float('inf')

total = sum(length)


def answer(now_cost, left_length, left_oil, position):
    global ans
    if now_cost > ans:
        return

    if position == N-1:
        ans = min(ans, now_cost)
        return

    for i in range(left_length//cost[position]):
        now_cost += (i*cost[position])
        left_oil = left_oil-length[i]+i

        answer(now_cost, left_length-length[i], left_oil, position+1)


answer(0, total, 0, 0)

print(ans)
