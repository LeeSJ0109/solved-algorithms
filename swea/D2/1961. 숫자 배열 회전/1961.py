T = int(input())

for t in range(T):
    print('#' + str(t + 1))
    N = int(input())

    l = []
    for _ in range(N):
        l.append(list(map(str, input().split())))
        
    rl = list(zip(*l[::-1]))

    for i in range(N):
        print(*rl[i], sep='', end=' ')
        print(*l[::-1][i][::-1], sep='', end=' ')
        print(*rl[::-1][i][::-1], sep='')