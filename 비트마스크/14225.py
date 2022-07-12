N = int(input())
S = list(map(int, input().split()))

visited = [0]*10000000


def cal(i, sum):
    if i == N:
        return

    visited[sum+S[i]] = 1

    cal(i+1, sum+S[i])
    cal(i+1, sum)


cal(0, 0)
print(visited[1:].index(0)+1)  # 내 풀이랑 달랐던 부분은 이 부분!
# 나는 배열을 만들어서 나올 수 있는 경우의 합을 다 저장하고, for문을 돌며 최소를 찾았는데
# 시간초과가 났다.
# 얘는 visited 배열을 만들고, 0이 나온 인덱스를 찾고 => index(0)은 가장 먼저 나온 0의 인덱스 반환
# 그 인덱스 + 1을 해줌.
