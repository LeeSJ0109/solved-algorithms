T = int(input())

for t in range(T):
    N, D = map(int, input().split())
    D = 2 * D + 1

    print('#' + str(t + 1), (N - 1) // D + 1)