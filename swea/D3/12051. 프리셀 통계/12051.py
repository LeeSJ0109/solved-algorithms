T = int(input())

for t in range(T):
    N, P_D, P_G = map(int, input().split())

    if P_G == 0 and P_D != 0:
        state = "Broken"
    elif P_G == 100 and P_D < 100:
        state = "Broken"
    else:
        state = "Broken"
        for i in range(1, N + 1):
            if (i * P_D) / 100 == (i * P_D) // 100:
                state = "Possible"
                break

    print('#' + str(t + 1), state)