T = int(input())

for t in range(T):
    N, K = map(int, input().split())
    a = list(map(int, input().split()))
    a.sort()

    minimum = a[-1] - a[0]
    for i in range(N-K+1):
        c = a[i:i+K]
        minimum = min(minimum, (max(c) - min(c)))

    print('#' + str(t + 1), minimum)