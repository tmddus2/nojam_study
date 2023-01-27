N = int(input())

youngsik = {}
daegun = []

for i in range(N):
    youngsik[input()] = N-i

for i in range(N):
    daegun.append(youngsik[input()])


num = 0

for i in range(N-1):
    for j in range(i+1, N):
        if daegun[i] < daegun[j]:
            num += 1
            break

print(num)
