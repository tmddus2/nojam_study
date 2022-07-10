def solve():
    N, A = int(input()), [0]+list(map(int, input().split()))

    S = [0 for _ in range(N+1)]  # N+1인 이유는 S[i]는 i까지 누적 비용을 나타내려고.
    # S[3]은 파일3까지 누적 비용. A[1]+A[2]+A[3]를 나타냄.
    for i in range(1, N+1):
        S[i] = S[i-1] + A[i]

    DP = [[0 for i in range(N+1)]
          for _ in range(N+1)]  # DP[i][j]: 파일 i에서 j까지 합치는 비용
    # DP[1][3]은 1번부터 3번까지 파일을 합치는 비용.
    for i in range(2, N+1):  # 부분 파일의 길이 => 결국 파일 길이는 2, 3, 4, ... N까지 늘어나게 됨.
        for j in range(i, N+2-i):  # 파일의 시작점 => 파일은 1부터 시작해서 N-i+1까지 늘어나게 됨.
            DP[j][j+i-1] = min([DP[j][j+k]+DP[j+k+1][j+i-1]
                               for k in range(i-1)]) + (S[j+i-1] - S[j-1])
            # j부터 j+i-1까지 파일 합을 구하는데,
            # (S[j+i-1] - S[j-1])는 j부터 j+i-1 까지 누적합.

    print(DP[1][N])


for _ in range(int(input())):
    solve()
