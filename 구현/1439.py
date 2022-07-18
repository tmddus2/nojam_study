N = input()

list_0 = 0
list_1 = 0

before_num = int(N[0])
if before_num == 0:
    list_0 += 1
else:
    list_1 += 1

for i in N:
    n = int(i)
    if before_num == n:
        continue
    else:
        before_num = (before_num+1) % 2
        if before_num == 0:
            list_0 += 1
        else:
            list_1 += 1

print(min(list_0, list_1))
