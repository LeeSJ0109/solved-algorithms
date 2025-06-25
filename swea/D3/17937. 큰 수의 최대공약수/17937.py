TC = int(input())

for T in range(TC):
    A, B = map(int, input().split())

    result = 1
    if A == B:
        result = A

    print('#' + str(T + 1), result)