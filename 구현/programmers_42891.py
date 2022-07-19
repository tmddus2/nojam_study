import heapq


def solution(food_times, k):
    if sum(food_times) <= k:  # k초 전에 다  먹을 수 있는 음식량이면 -1 리턴
        return -1

    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i + 1))  # heapq에 (음식량, 인덱스)를 넣어준다.

    sum_value = 0  # 지금까지 해치운 음식량 총합
    previous = 0  # 이전에 제거한 음식의 음식량

    length = len(food_times)  # 음식 가짓수

    # q[0][0]-previous는 지금 가장 작은 음식량-예전에 없앴던 음식량
    # *length 해주는 이유는 한 바퀴를 쭉 돌아야하기 때문
    # 그러니까 요약을 해보면 음식량이 작은 음식부터 제거를 할 수 있냐 없냐 체크하는 것
    # 제거를 했다는 거는 제일 작은 음식량을 루프를 한 바퀴씩 돌면서 모든 음식량에서 빼줬다는 것!
    # sum_value + ((q[0][0] - previous) * length) <= k 라면 깔끔하게 루프 한 바퀴를 쭉 돌아서 음식량이 가장 적은 음식을 제거할 수 있음
    # 그렇지 않다면, 루프 한 바퀴를 채 돌지 못하고 중간에 어떤 음식을 먹다가 멈추게 된다.
    # q[0][0] - previous는 남은 최소 음식량. 그냥 q[0][0]에서 previous를 빼주면 지금까지 음식을 지워오면서 업데이트 되었어야 할 음식량이 된다.
    while sum_value + ((q[0][0] - previous) * length) <= k:
        now = heapq.heappop(q)[0]  # 음식량 제일 작은 거 해치우기 성공
        sum_value += (now - previous) * length  # 한 바퀴 돌면서 총 없앤 음식량
        length -= 1  # 음식 수는 1개 줄어듦
        previous = now  # 이제 이전에 해치웠던 음식량은 now로 업데이트

    result = sorted(q, key=lambda x: x[1])
    # (k - sum_value) => 3
    # length = 2
    # 3초 후에 선택될 데이터를 return
    # 0  1
    # 2 '3'
    # [(8,1),(6,2)]
    return result[(k - sum_value) % length][1]
