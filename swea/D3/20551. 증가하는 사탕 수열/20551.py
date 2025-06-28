T = int(input())

for t in range(T):
    A, B, C = map(int, input().split())

    state = 0

    if C <= B:
        state += B - C + 1
        B = C - 1
    if B <= A:
        state += A - B + 1
        A = B - 1
    if A < 1:
        state = -1

    print('#' + str(t + 1), state)