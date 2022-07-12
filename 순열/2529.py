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

    if(idx == n+1):  # 끝까지 왔는데 => 예를 들어 숫자가 3자린데 3자리를 다 채웠다면
        if(len(min_ans) == 0):  # min_ans가 업데이트 된 적이 없다면
            min_ans = s  # min_ans를 우선적으로 업데이트. 왜냐면 0부터 시작했으니까 먼저 발견된 건 최소일 것.
        else:
            max_ans = s  # 그 min_ans가 업데이트 되고 난 후부터는 max_ans만 업데이트 하기.
        return
    for i in range(10):  # 0부터 9까지 가능한 숫자 돌기
        if(visited[i] == 0):  # 숫자가 아직 쓰지 않은 숫자라면
            # 무조건 처음에는 돌아야하고, 그 다음부터는 부호 만족할 때만
            if(idx == 0 or check(s[-1], str(i), ine_sing[idx-1])):
                visited[i] = True  # 방문하는 경우
                solve(idx+1, s+str(i))  # 문자열에 추가함
                visited[i] = False  # 방문 안하는 경우도 마저 체크


solve(0, "")
print(max_ans)
print(min_ans)
