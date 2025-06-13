T = int(input())

for t in range(T):
    print('#' + str(t + 1))    
    N = int(input())
    snail = [[0] * N for i in range(N)]

    i, j = 0, 0
    state = 'jp'
    for n in range(1, N * N + 1):
        snail[i][j] = n

        if state == 'jp':
            if j + 1 < len(snail[i]) and snail[i][j+1] == 0:
                j += 1
                continue
            else:
                state = 'im'
        if state == 'im':
            if i + 1 < len(snail) and snail[i+1][j] == 0:
                i += 1
                continue
            else:
                state = 'jm'
        if state == 'jm':
            if j - 1 >= 0 and snail[i][j-1] == 0:
                j -= 1
                continue
            else:
                state = 'ip'
        if state == 'ip':
            if i - 1 >= 0 and snail[i-1][j] == 0:
                i -= 1
                continue
            else:
                state = 'jp'
                j += 1
                
    for s in snail:
        print(*s)