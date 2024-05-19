T = int(input())

for t in range(T):
    N = input()
    L = len(N)

    min_M, max_M = int(N), int(N)
    for i in range(L):
        for j in range(i + 1, L):
            M = N[:i] + N[j] + N[i+1:j] + N[i] + N[j+1:]
            if M[0] != '0':
                min_M = min(min_M, int(M))
                max_M = max(max_M, int(M))

    print('#' + str(t + 1), min_M, max_M)