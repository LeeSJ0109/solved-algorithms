T = int(input())

for t in range(T):
    S = input()
    N = len(S)

    if S == S[::-1] and S[:(N-1)//2] == S[:(N-1)//2][::-1] and S[::-1][:(N-1)//2] == S[::-1][:(N-1)//2][::-1]:
        state = "YES"
    else: state = "NO"

    print('#' + str(t + 1), state)