T = int(input())

for t in range(T):
    N, M = map(int, input().split())

    fly = []
    for _ in range(N):
        fly.append(list(map(int, input().split())))

    result = 0
    for i in range(N-M+1):
        for j in range(N-M+1):
            s = []
            for k in range(M):
                s += fly[j+k][i:i+M]
                
            result = max(result, sum(s))
            
    print('#' + str(t + 1), result)        