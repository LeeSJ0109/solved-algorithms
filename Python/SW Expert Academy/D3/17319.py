TC = int(input())

for T in range(TC):
    N, S = int(input()), input()
    state = "No"

    if not N % 2:
        s = S[:N//2] * 2
        if s == S:
            state = "Yes"

    print('#' + str(T + 1), state)