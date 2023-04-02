N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())

num = 0
for i in range(len(A)):
    num += 1
    A[i] -= B
    if A[i] % C == 0:
        num += (A[i]//C)
    else:
        num += ((A[i]//C)+1)

print(num)
