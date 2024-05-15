T = int(input())

for t in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    
    result = []
    if N <= M:
        for i in range(M - N + 1):
            total = 0
            for j in range(N):
                total += A[j] * B[i + j]
            result.append(total)
            
    elif N > M:
        for i in range(N - M + 1):
            total = 0
            for j in range(M):
                total += B[j] * A[i + j]
            result.append(total)
            
    print('#' + str(t + 1), max(result))