rank = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
T = int(input())

for t in range(T):
    N, K = map(int, input().split())

    score = []
    for _ in range(N):
        a, b, c = map(int, input().split())
        score.append(a * 0.35 + b * 0.45  + c * 0.2)
    
    print('#' + str(t + 1), rank[sorted(score, reverse=True).index(score[K-1])//(N//10)])