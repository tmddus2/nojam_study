import sys

T = int(sys.stdin.readline())


def answer():
    n = int(sys.stdin.readline())
    t = list(map(int, sys.stdin.readline().split()))

    dp = [[0]*(len(t)+1) for _ in range(len(t)+1)]
    '''
    for i in range(len(t)+1):
        dp[i][i] = t[i-1]
    '''
    s = [0 for _ in range(n+1)]

    for i in range(1, n+1):
        s[i] = s[i-1] + t[i-1]

    for i in range(2, n+1):  # 파일의 길이
        for j in range(1, n+2-i):  # 시작점
            dp[j][j+i-1] = min([dp[j][j+k]+dp[j+k+1][j+i-1]
                               for k in range(i-1)]) + s[j+i-1] - s[j-1]

        #i += j

    return dp[1][n]


for _ in range(T):
    print(answer())
