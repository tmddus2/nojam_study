n = int(input())
ine_sing = list(map(str, input().split()))

visited = [0]*10  # 0부터 9까지 방문한 적 있는지 visited 배열 만든다.
max_ans = ""
min_ans = ""


def check(i, j, k):  # i와 j가 부등호 k 관계에 적합한지 체크해주는 함수
    if k == '<':
        return i < j
    else:
        return i > j


def solve(idx, s):
    global max_ans, min_ans

    if(idx == n+1):  # 끝까지 왔는데
        if(len(min_ans) == 0):  # min_ans가 업데이트 된 적이 없다면
            min_ans = s  # min_ans를 우선적으로 업데이트. 왜냐면 0부터 시작했으니까 먼저 발견된 건 최소일 것.
        else:
            max_ans = s  # 그 min_ans가 업데이트 되고 난 후부터는 max_ans만 업데이트 하기.
        return
    for i in range(10):
        if(visited[i] == 0):
            if(idx == 0 or check(s[-1], str(i), ine_sing[idx-1])):
                visited[i] = True
                solve(idx+1, s+str(i))
                visited[i] = False


solve(0, "")
print(max_ans)
print(min_ans)
