T = int(input())

for t in range(T):
    N, K = map(int, input().split())
    result, p = 0, '0' * (N + 2)
    q = ''
    for _ in range(N):
        p += ('\n0' + input().replace(' ', '') + '0')
    p += ('\n' + '0' * (N + 2))
    
    q = [''.join(i) for i in p.split('\n')]
    q = list(zip(*q))
    q = [''.join(i) for i in q]
    q = '\n'.join(q)
    
    result = (p+q).count('0' + '1' * K + '0')
    print('#' + str(t + 1), result)