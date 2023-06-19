n = int(input())

plus = []
minus = []

ans = 0

for _ in range(n):
    num = int(input())

    if num > 1:
        plus.append(num)
    elif num == 1:
        ans += num
    elif num <= 0:
        minus.append(num)

plus.sort(reverse=True)
minus.sort()

for i in range(0, len(plus), 2):
    if i+1 == len(plus):
        ans += plus[-1]

    else:
        ans = ans+plus[i]*plus[i+1]

for i in range(0, len(minus), 2):
    if i+1 == len(minus):
        ans += minus[-1]
    else:
        ans = ans+minus[i]*minus[i+1]

print(ans)
