TC = int(input())

for T in range(TC):
    A, B = map(int, input().split())

    if A == B:
        result = 0
    elif A > B or B - A == 1:
        result = -1
    else:
        result = (B - A) // 2

    print('#' + str(T + 1), result)