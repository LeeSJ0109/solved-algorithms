TC = int(input())

for T in range(TC):
    N, M = map(int, input().split())
    s = input().split()
    t = input().split()
    Q = int(input())

    result = ''
    for _ in range(Q):
        Y = int(input())
        result += (s[Y % N - 1] + t[Y % M - 1] + ' ')

    print('#' + str(T + 1), result)