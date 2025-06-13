T = int(input())

for t in range(T):
    N = int(input())

    d = ''
    for _ in range(N):
        C, K = input().split()
        for _ in range(int(K)):
            d += C
    print('#' + str(t + 1))
    for i in range(len(d)):
        if i != 0 and i % 10 == 0:
            print()
        print(d[i], end='')
    print()