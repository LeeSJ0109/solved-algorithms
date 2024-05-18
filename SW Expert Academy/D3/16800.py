TC = int(input())

for T in range(TC):
    N = int(input())

    result = 1
    for i in range(1, int(N**0.5) + 1):
        if not N % i:
            result = i + N//i - 2

    print('#' + str(T + 1), result)