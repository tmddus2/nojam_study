N, K = map(int, input().split(" "))

weight = []
value = []
bag = []

for _ in range(N):
    w, v = map(int, input().split(" "))
    weight.append(w)
    value.append(v)

for _ in range(K):
    bag.append(int(input()))

weight.sort(reverse=True)
value.sort(reverse=True)
