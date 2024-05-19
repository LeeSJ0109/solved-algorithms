T = int(input())

for t in range(T):
    N = int(input())
    origin_N = [j for j in str(N)]
    origin_N.sort()
    
    state = 'impossible'
    for i in range(2, 10):
        newN = [j for j in str(i * N)]
        newN.sort()
        if origin_N == newN:
            state = 'possible'
            break

    print('#' + str(t + 1), state)