N, K = map(int, input().split(" "))

scheduling = list(map(int, input().split(" ")))
adaptor = [0]*N
temp = 0
ttemp = 0
count = 0

for i in range(len(scheduling)):
    if scheduling[i] in adaptor:
        pass
    elif 0 in adaptor:
        adaptor[adaptor.index(0)] = scheduling[i]
    else:
        for j in adaptor:
            if j not in scheduling[i:]:
                temp = j
                break
            elif scheduling[i:].index(j) > ttemp:
                temp = j
                ttemp = scheduling[i:].index(j)
        adaptor[adaptor.index(temp)] = scheduling[i]
        temp = 0
        ttemp = 0
        count += 1

print(count)
