statement = list(input().split('-'))
ans = 0

for s in range(len(statement)):
    t = list(statement[s].split("+"))
    total = 0
    for tt in t:
        total += int(tt)
    if s == 0:
        ans += total
    else:
        ans -= total

print(ans)
