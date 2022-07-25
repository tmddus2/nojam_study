N = input()

front = 0
back = 0

for i in range(len(N)):
    if i < len(N)//2:
        front += int(N[i])
    else:
        back += int(N[i])

if front == back:
    print("LUCKY")
else:
    print("READY")
