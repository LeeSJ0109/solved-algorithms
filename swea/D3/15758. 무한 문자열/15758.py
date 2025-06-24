T = int(input())

for t in range(T):
    S, T = input().split()
    S, T = S * len(T), T * len(S)

    print('#' + str(t + 1), end=' ')

    if S == T:
        print("yes")
    else:
        print("no")