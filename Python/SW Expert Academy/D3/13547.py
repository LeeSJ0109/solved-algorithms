T = int(input())

for t in range(T):
    S = input()
    o, x = 0, 0

    for s in S:
        if s == 'o':
            o += 1
        elif s == 'x':
            x += 1

    o += 15 - len(S)

    print('#' + str(t + 1), end=' ')
    if o >= 8:
        print("YES")
    else:
        print("NO")