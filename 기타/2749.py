# M = 10의 k승일 때, k>2라면 주기 P는 15*(10의 k-1승)
# N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M으로 나눈 나머지와 같다.
import sys

n = int(sys.stdin.readline())
m = 1000000
p = 1
for i in range(5):
    p = p*10
n = n % (15*p)

a, b = 0, 1
f = 1
for i in range(n-2):
    a = b
    b = f
    t = a + b
    f = t % m


print(f)
