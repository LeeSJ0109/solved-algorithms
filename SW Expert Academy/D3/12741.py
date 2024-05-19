ans = ''

T = int(input())
for t in range(T):
    A, B, C, D = map(int, input().split())
    start, end = max(A, C), min(B, D)

    ans += f'#{t + 1} {max(end-start, 0)}\n'
    
print(ans)