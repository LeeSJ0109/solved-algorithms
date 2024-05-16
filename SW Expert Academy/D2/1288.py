T = int(input())

for t in range(T):
    N = int(input())
    result, s = 1, set()
    
    while len(s) != 10:
        for i in str(result * N):
            s.add(i)
        result += 1

    print('#' + str(t + 1), (result - 1) * N)