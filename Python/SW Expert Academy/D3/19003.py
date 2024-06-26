TC = int(input())

for T in range(TC):
    N, M = map(int, input().split())
    S = []

    for _ in range(N):
        S.append(input())

    result = 0
    for i in range(N - 1):
        if S[i][::-1] in S[i+1:]:
            result += len(S[i]) * 2
            S[i] = ''
            S[S.index(S[i][::-1])] = ''

    maximum = 0
    for s in S:
        if s != '':
            if s == s[::-1]:
                maximum = max(maximum, len(s))

    result += maximum

    print('#' + str(T + 1), result)