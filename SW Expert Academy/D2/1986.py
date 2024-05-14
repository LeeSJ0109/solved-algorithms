T = int(input())

for t in range(T):
    N = int(input())
    a = [i for i in range(1, N + 1) if i % 2]
    b = [i for i in range(1, N + 1) if not i % 2]

    print('#' + str(t + 1), sum(a) - sum(b))