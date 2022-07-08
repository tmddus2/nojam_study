# https://velog.io/@himi/백준-10942.-팰린드롬
import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))
m = int(input())

dp = [[0] * n for _ in range(n)]  # [1][2]라면 start는 1, end는 2

# 배열이 [start, start+1, ... end-1, end] 이런 식으로 되어있다면
# start ~ end 가 팰린드롬이다 ==> start와 end가 같다 && start+1 ~ end-1 이 팰린드롬
# [start+1, end-1]이 팰린드롬이라는 사실을 알고 있다면, 문자열 전체를 검사할 필요 없이 start와 end만 같은지 비교하면 된다.

# 양 끝 문자가 다르다 (start != end) => 팰린드롬 아님
# 양 끝 문자가 같다 (start == end) => 1. 가운데 문자열이 팰린드롬이면 팰린드롬. 2. 가운데가 팰린드롬이 아니면 아님.
# 만약 가운데가 팰린드롬인지 아닌지 모른다면? 문자열의 길이를 앞뒤로 하나씩 줄이면서 과정 반복

# 이 문제는 왜 DP로 접근할 수 있는지가 중요!!
# 가운데 문자열이 팰린드롬인지 아닌지 아는 문자열이 나올때까지 문자열의 범위를 줄여가면서 같은 과정을 계속 반복한다는 점에서 DP 문제라고 할 수 있다!

for num_len in range(n):  # 팰린드롬 문자열 길이가 0, 1, 2, ...
    # 문자열 앞부터 팰린드롬 문자열로 돌기 시작함. ex. num_len이 3일때, 0-2, 1-3, 2-4 처럼 팰린드롬 조합을 만들어 감.
    for start in range(n - num_len):
        end = start + num_len  # start에서 길이만큼을 더한 게 end

        # 시작점과 끝점이 같다면, 즉 num_len이 0이라면 글자수가 1개이므로 무조건 팰린드롬
        # dp 배열에서 [0][0], [1][1], [2][2], ... 이 부분을 채워나감.
        if start == end:
            dp[start][end] = 1

        # 시작점의 글자와 끝점의 글자가 같다면 => start+1 ~ end-1 이 팰린드롬이면 팰린드롬
        elif numbers[start] == numbers[end]:
            # 두 글자짜리 문자열이라면 무조건 팰린드롬
            # start+1 ~ end-1 비교할 때 역전되지 않도록 => 예를 들어 [2][3]이 [3][2]이 되려고 할 때는 다 온거니까 걸러주기
            # dp 배열은 [0][0], [1][1], [2][2], ... 라인을 기준으로 위쪽만 update됨. 즉, [2][3]은 업데이트 돼도 [3][2]는 안됨.
            if start + 1 == end:
                dp[start][end] = 1
            # 가운데 문자열이 팰린드롬이라면 팰린드롬
            elif dp[start+1][end-1] == 1:
                dp[start][end] = 1


# 정답출력하기
for question in range(m):
    s, e = map(int, input().split())
    print(dp[s-1][e-1])
