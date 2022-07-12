N, S = map(int, input().split())
li = list(map(int, input().split()))

global ans
ans = 0


def check(sum, i):
    global ans
    new_sum = sum + li[i]
    if new_sum == S:
        ans += 1
    if i+1 >= N:
        return
    check(sum+li[i], i+1)
    check(sum, i+1)


check(0, 0)
print(ans)
