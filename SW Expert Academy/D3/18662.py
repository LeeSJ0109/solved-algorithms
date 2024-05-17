TC = int(input())

for T in range(TC):
    a, b, c = map(int, input().split())

    if a + c == 2 * b:
        result = '0.0'
    else:
        if a + c > 2 * b:
            result = (a + c - 2 * b)/2
        else:
            result = (2 * b - (a + c))/2

    print('#' + str(T + 1), result)