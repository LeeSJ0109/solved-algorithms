T = int(input())

for t in range(T):
    N = int(input())
    p = list(map(int, input().split()))

    result = 0
    for i in range(1, N - 1):
        max_p, min_p = max(p[i-1], p[i], p[i+1]), min(p[i-1], p[i], p[i+1])
        if p[i] != max_p and p[i] != min_p:
            result += 1

    print('#' + str(t + 1), result)